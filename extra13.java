// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 2-9-11
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// this program creates an applet program that is like 
// the paintbrush program with color, size and erase
// options
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// red,green,blue,magenta,black,pen,brush,roller,clear,eraser --> buttons 
// numColor --> represents the chosen color to draw with
// numSize --> represents the size of the paint tool
// numDraw --> represents the kind of drawing or clearing
// virtualMem --> represents the memory that is created and saved
// to be dumped into video memory 
// gBuffer --> represents the information being sent to virtual memory
// oldX, oldY, newX, newY --> represents the continuous x and y values
// appletWidth --> the applet's width
// appletHeight --> the applet's height
// first --> represents if it is the first time clicking on a new feature
// ***********************************************
// Lab13.java
// 110 Version

import java.awt.*;
import java.applet.*;
import java.util.*;

public class Lab13 extends Applet 
{
	Rectangle pannel;
	Rectangle black, red, blue, green, yellow;
	Rectangle gray, magenta, cyan, orange, pink;
	Rectangle pen, brush, roller, spray, band;
	Rectangle eraser, clear;
	
	Rectangle small, medium, large;
	
	int numColor;
	int numSize;
	int numDraw;
	Image virtualMem;
	Graphics gBuffer;
	int oldX, oldY, newX, newY;
	int appletWidth;
	int appletHeight;
	boolean first;
	boolean color;
	boolean rubberBand;
	Polygon penta;
	Random rnd = new Random();
	int x, y;
	int size;
	int s; //size of spray paint and eraser
	
	int startX,startY,endX,endY;

	public void init()
    {
    	//set background
		appletWidth = getWidth();
		appletHeight = getHeight();
		virtualMem = createImage(appletWidth,appletHeight);
		gBuffer = virtualMem.getGraphics();
		gBuffer.setColor(Color.white);
		gBuffer.fillRect(0,0,appletWidth,appletHeight);
		
		//pannel
		pannel  = new Rectangle(-10,5,75,410);
		
		//color buttons
		black   = new Rectangle(15,20,20,20); //first column
		red     = new Rectangle(15,40,20,20);
		blue    = new Rectangle(15,60,20,20);
		green   = new Rectangle(15,80,20,20);
		yellow  = new Rectangle(15,100,20,20);
		gray    = new Rectangle(35,20,20,20); //second column
		magenta = new Rectangle(35,40,20,20);
		cyan    = new Rectangle(35,60,20,20);
		orange  = new Rectangle(35,80,20,20);
		pink    = new Rectangle(35,100,20,20);
		numColor = 0;

		//drawing tool buttons
		pen     = new Rectangle(15,120,20,30);
		brush   = new Rectangle(35,120,20,30);
		roller  = new Rectangle(15,150,20,30);
		spray   = new Rectangle(35,150,20,30);
		band    = new Rectangle(15,180,20,30);
		numSize = 0;
		
		//clear and eraser draw buttons
		eraser  = new Rectangle(35,180,20,30);
		clear   = new Rectangle(10,210,50,25);
		numDraw = 0;
		
		//size buttons for spray, eraser, and rubber band
		small  = new Rectangle(25,270,20,20);
		medium = new Rectangle(25,290,20,20);
		large  = new Rectangle(25,310,20,20);
		size = 0;
   	}

    public void paint(Graphics g)
    {
    	//pannel
    	gBuffer.setColor(Color.black);
		gBuffer.drawRect(5,15,60,400);
		
    	//color buttons
    	gBuffer.setColor(Color.black); //first column
		gBuffer.fillRect(15,20,20,20);
		gBuffer.setColor(Color.red);
		gBuffer.fillRect(15,40,20,20);
		gBuffer.setColor(Color.blue);
		gBuffer.fillRect(15,60,20,20);
		gBuffer.setColor(Color.green);
		gBuffer.fillRect(15,80,20,20);
		gBuffer.setColor(Color.yellow);
		gBuffer.fillRect(15,100,20,20);
		gBuffer.setColor(Color.gray); //second column
		gBuffer.fillRect(35,20,20,20);
		gBuffer.setColor(Color.magenta);
		gBuffer.fillRect(35,40,20,20);
		gBuffer.setColor(Color.cyan);
		gBuffer.fillRect(35,60,20,20);
		gBuffer.setColor(Color.orange);
		gBuffer.fillRect(35,80,20,20);
		gBuffer.setColor(Color.pink);
		gBuffer.fillRect(35,100,20,20);
		gBuffer.setColor(Color.black);//draw first column button outlines
		gBuffer.drawRect(15,20,20,20); 
		gBuffer.drawRect(15,40,20,20);
		gBuffer.drawRect(15,60,20,20);
		gBuffer.drawRect(15,80,20,20);
		gBuffer.drawRect(15,100,20,20);
		gBuffer.fillRect(15,20,20,20);
		gBuffer.drawRect(35,20,20,20); //draw second column button outlines
		gBuffer.drawRect(35,40,20,20);
		gBuffer.drawRect(35,60,20,20);
		gBuffer.drawRect(35,80,20,20);
		gBuffer.drawRect(35,100,20,20);
		
		//pen button design
		gBuffer.setColor(Color.black);
		gBuffer.drawRect(23,125,3,20);
		penta = new Polygon();
		penta.addPoint(23,145);
		penta.addPoint(26,145);
		penta.addPoint(25,148);
		gBuffer.drawPolygon(penta);
		
		//brush button design 
		gBuffer.setColor(Color.gray);
		gBuffer.fillRect(45,128,3,10);
		penta = new Polygon();
		penta.addPoint(45,138);
		penta.addPoint(48,138);
		penta.addPoint(51,141);
		penta.addPoint(42,141);
		gBuffer.drawPolygon(penta);
		gBuffer.setColor(Color.black);
		gBuffer.drawRect(42,141,9,5);
		gBuffer.drawLine(45,146,45,144);
		gBuffer.drawLine(48,146,48,143);
		
		//roller button design
		gBuffer.setColor(Color.black); //handle
		gBuffer.fillRect(23,155,3,10);
		gBuffer.drawRect(19,165,9,4);
		gBuffer.setColor(Color.white); //roller front
		gBuffer.fillOval(27,166,4,4);
		gBuffer.setColor(Color.black); //roller round side
		gBuffer.drawOval(27,166,3,3);
		
		//spray paint button design
		gBuffer.setColor(Color.black);   //top of can
		penta = new Polygon();
		penta.addPoint(43,156);
		penta.addPoint(48,160);
		penta.addPoint(43,163);
		gBuffer.drawPolygon(penta);
		gBuffer.setColor(Color.blue);    //spray button
		gBuffer.fillRect(42,155,2,3);
		//paint spray	          
		penta = new Polygon();		     //can
		penta.addPoint(43,163);
		penta.addPoint(48,160);
		penta.addPoint(53,172);
		penta.addPoint(48,177);
		gBuffer.fillPolygon(penta);
		gBuffer.setColor(Color.black);
		gBuffer.drawPolygon(penta);
		
		//rubber band drawing button design
		gBuffer.setColor(Color.black);
		gBuffer.drawLine(20,185,30,205);
		
		gBuffer.drawRect(15,120,20,30);
		gBuffer.drawRect(35,120,20,30);
		gBuffer.drawRect(15,150,20,30);
		gBuffer.drawRect(35,150,20,30);
		gBuffer.drawRect(15,180,20,30);
		gBuffer.drawRect(35,180,20,30);
		gBuffer.drawRect(10,210,50,25);
		
		//eraser button design 
		gBuffer.setColor(Color.yellow); //top
		penta = new Polygon();    		
		penta.addPoint(45,185);
		penta.addPoint(50,185);
		penta.addPoint(45,200);
		penta.addPoint(40,200);
		gBuffer.fillPolygon(penta);
		gBuffer.setColor(Color.black);	//outline
		gBuffer.drawPolygon(penta);
		gBuffer.setColor(Color.yellow); //side
		penta = new Polygon();			
		penta.addPoint(50,185);
		penta.addPoint(45,200);
		penta.addPoint(48,204);
		penta.addPoint(52,189);
		gBuffer.fillPolygon(penta);
		gBuffer.setColor(Color.black); //outline
		gBuffer.drawPolygon(penta);
		penta = new Polygon();			//front
		penta.addPoint(40,200);
		penta.addPoint(45,200);
		penta.addPoint(48,204);
		penta.addPoint(43,204);
		gBuffer.drawPolygon(penta);
		
		//clear button design
		gBuffer.setFont(new Font("Arial",Font.BOLD,20));
		gBuffer.drawString("Clear",10,229);
		
		//draw pannel and buttons
		g.drawImage(virtualMem,0,0,this);
		
		if ((numSize == 4)||(numColor == 11))
		{
			//draw different size buttons for spray paint, eraser, and rubber band
			gBuffer.setColor(Color.white);
			gBuffer.fillRect(20,265,35,75);
			gBuffer.setColor(Color.black);
			gBuffer.drawRect(20,265,30,70); //size pannel
			gBuffer.drawRect(25,270,20,20); //small
			gBuffer.drawRect(25,290,20,20); //medium
			gBuffer.drawRect(25,310,20,20); //large
			
			if (numSize == 4)
			{
				for (int n=0;n<=20;n++)
				{
				x = 35+((int)(3*Math.cos((rnd.nextDouble()*2*Math.PI))));
				y = 280+((int)(3*Math.sin((rnd.nextDouble()*2*Math.PI))));
				gBuffer.fillRect(x,y,1,1);
				}
				for (int n=0;n<=40;n++)
				{
				x = 34+((int)(6*Math.cos((rnd.nextDouble()*2*Math.PI))));
				y = 300+((int)(6*Math.sin((rnd.nextDouble()*2*Math.PI))));
				gBuffer.fillRect(x,y,1,1);
				}
				for (int n=0;n<=70;n++)
				{
				x = 35+((int)(8*Math.cos((rnd.nextDouble()*2*Math.PI))));
				y = 319+((int)(8*Math.sin((rnd.nextDouble()*2*Math.PI))));
				gBuffer.fillRect(x,y,1,1);
				}
				switch (size)
					{
						case 1: 
							s = 3;
							break;
						case 2:
							s = 6;
							break;
						case 3:
							s = 8;
					}
			}
			else
			{
				gBuffer.drawRect(33,278,4,4);
				gBuffer.drawRect(32,297,7,7);
				gBuffer.drawRect(30,315,10,10);
				
				switch (size)
					{
						case 1: 
							s = 4;
							break;
						case 2:
							s = 7;
							break;
						case 3:
							s = 10;
					}
			}
			g.drawImage(virtualMem,0,0,this);	
		}
		else
		{
			gBuffer.setColor(Color.white);
			gBuffer.fillRect(20,265,35,75);
		}

		//changing what color it draws with
		switch (numColor)
		{
			case 1:
				gBuffer.setColor(Color.black);
				break;
			case 2:
				gBuffer.setColor(Color.red);
				break;
			case 3:
				gBuffer.setColor(Color.blue);
				break;
			case 4:
				gBuffer.setColor(Color.green);
				break;
			case 5:
				gBuffer.setColor(Color.yellow);
				break;
			case 6:
				gBuffer.setColor(Color.gray);
				break;
			case 7:
				gBuffer.setColor(Color.magenta);
				break;
			case 8:
				gBuffer.setColor(Color.cyan);
				break;
			case 9:
				gBuffer.setColor(Color.orange);
				break;
			case 10:
				gBuffer.setColor(Color.pink);
				break;
			case 11:
				gBuffer.setColor(Color.white);		
				break;
		}
		
		//changing how it draws
		switch (numDraw)
		{
			case 1: //clear drawing
				gBuffer.setColor(Color.white);
				gBuffer.fillRect(0,0,appletWidth,appletHeight);
				g.drawImage(virtualMem,0,0,this);
				numDraw = 0;
				repaint();
				break;
			default:
				switch (numSize)
					{
						case 1: //draw with pen
							if (!first)
							{
								gBuffer.drawLine(oldX,oldY,newX,newY);
								g.drawImage(virtualMem,0,0,this);
							}	
							else
								first = false;
							break;
						case 2: //draw with brush
							if (!first)
							{
								gBuffer.fillRect(oldX,oldY,4,4);
								g.drawImage(virtualMem,0,0,this);
							}
							else
								first = false;
							break;
						case 3: //draw with roller
							if (!first)
							{
								gBuffer.fillRect(oldX,oldY,10,10);
								g.drawImage(virtualMem,0,0,this);
							}	
							else
								first = false;
							break;
						case 4: //draw with spray paint
							if (!first)
							{
								for (int n=0;n<=20;n++)
								{
									x = oldX+((int)(s*Math.cos((rnd.nextDouble()*2*Math.PI))));
									y = oldY+((int)(s*Math.sin((rnd.nextDouble()*2*Math.PI))));
									gBuffer.fillRect(x,y,1,1);
									g.drawImage(virtualMem,0,0,this);
								}
							}
							else
								first = false;
							
							break;
						case 5: //draw with rubber band style
							if (!first)
							{
								gBuffer.drawLine(startX,startY,endX,endY);
								g.drawImage(virtualMem,0,0,this);
							}	
							else
								first = false;
							break;
						case 6:
							gBuffer.fillRect(oldX,oldY,s,s);
							g.drawImage(virtualMem,0,0,this);
							break;
						default: // default to drawing with pen
							if (!first)
							{
								gBuffer.drawLine(oldX,oldY,newX,newY);
								g.drawImage(virtualMem,0,0,this);
							}	
							else
								first = false;	
					}	
		}	
    }
    
    public boolean mouseDown(Event e, int x, int y)
	{
		//defines when something is clicked to not draw in last coordinates
		first = true;
								
		//checks if mouse is clicked inside one of the buttons
		if(black.inside(x,y))
			numColor = 1;
		else if(red.inside(x,y))
			numColor = 2;
		else if(blue.inside(x,y))
			numColor = 3;
		else if(green.inside(x,y))
			numColor = 4;
		else if(yellow.inside(x,y))
			numColor = 5;
		else if(gray.inside(x,y))
			numColor = 6;
		else if(magenta.inside(x,y))
			numColor = 7;
		else if(cyan.inside(x,y))
			numColor = 8;
		else if(orange.inside(x,y))
			numColor = 9;
		else if(pink.inside(x,y))
			numColor = 10;
		else if(eraser.inside(x,y))
		{
			numColor = 11;
			numSize = 6;
			rubberBand = false;
		}
		else if(clear.inside(x,y))
		{
			numDraw = 1;
			rubberBand = false;
		}
		else if(pen.inside(x,y))
		{
			if (numColor==11)
				numColor = 1;	
			numSize = 1;
			rubberBand = false;	
		}	
		else if(brush.inside(x,y))
		{
			if (numColor==11)
				numColor = 1;
			numSize = 2;
			rubberBand = false;	
		}
		else if(roller.inside(x,y))
		{
			if (numColor==11)
				numColor = 1;
			numSize = 3;
			rubberBand = false;	
		}
		else if(spray.inside(x,y))
		{
			if (numColor==11)
				numColor = 1;
			numSize = 4;
			rubberBand = false;	
		}	
		else if(band.inside(x,y))
		{
			if (numColor==11)
				numColor = 1;
			numSize = 5;
			rubberBand = true;
		}
		else if(small.inside(x,y))
			size = 1;
		else if(medium.inside(x,y))
			size = 2;
		else if(large.inside(x,y))
			size = 3;
		else if(pannel.inside(x,y));
		else 			//default to drawing when a button isn't clicked
		{
			newX = x;
			newY = y;
			oldX = newX;
			oldY = newY;
			first = false;
			rubberBand = false;
		}
		if (rubberBand == true)
		{
			startX = x;
			startY = y;
		}
		repaint();
		return true;
	}

	public boolean mouseDrag(Event e, int x, int y)
	{
		if (rubberBand == true)
		{
			endX = x;
			endY = y;
		}
		else if(pannel.inside(x,y));	//stops it from drawing on the buttons pannel
		
		//tracks mouse's movement
		else					
		{
			newX = x;
			newY = y;
			oldX = newX;
			oldY = newY;
		}	
		repaint();
		return true;
	}

	public void update(Graphics g)
	{
		paint(g);
	}

}