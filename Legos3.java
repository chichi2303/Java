package cs520.hw4;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Legos3 extends JFrame {
	
	//Declare the instance variables 
	int startX; //Left coordinate 
	int startY; //Top cooridinate 
	int legoWidth; //Width of each block 
	int legoHeight;  //Heigh of each block 
	int baseLength; //The number of blocks in the bottom row 


	//Declare, allocate, and initialize the array of colors 
	Color[] colors = new Color []
	{
		Color.red, Color.blue, Color.yellow,
		Color.green, Color.pink,Color.black, Color.magenta,
		Color.orange, Color.cyan				
	};
	
	//Constructor with title 
	public Legos3 ()
	{
	super ("Nguyen's LEGOs");
	//Assign value for variables 
	startX = 20;
	startY = 300;
	legoWidth = 50;
	legoHeight = 20;
	baseLength = 10;
	}
	
	public void paint (Graphics g)
	{
		super.paint(g);
		int currentX;	
		Color previousColor = null; //Initialize the value of previous color 


		//drawRect to make rectangles 
		for (int row = 1; row <= baseLength; row++)
		{
			//Reset the value of X after each row
			currentX = startX;
			
			for (int col = 0; col <= baseLength - row; col++)
			{	
				//Random select a color
				Random randomGenerator = new Random (); //Construct a new random color generator 
				//Set each block to a random color 
				Color currentColor = colors[randomGenerator.nextInt(colors.length)];
				/*Using while loop here so that the system will keep generating new colors if the current color one
				is the same as the previous one*/
				while (currentColor == previousColor)
				{
					currentColor = colors[randomGenerator.nextInt(colors.length)];
				}					
				g.setColor(currentColor);
				
				//Store the current one as the previous one after generating so that it won't repeat 
				previousColor = currentColor;
				
	        	g.fillRoundRect(currentX, startY,legoWidth, legoHeight, 2, 2);	
	            currentX += legoWidth;


			}
			startY -= legoHeight; //Move top row upward by legoHeight px
			startX += legoWidth/2;
		}
	}
	


	//Main method 
	public static void main (String[] args)
	{
		//Create the application object
		Legos3 lego = new Legos3(); 
		//Set the size of the application window 
		lego.setSize(550, 325);
		//Make the window visible 
		lego.setVisible (true);
		//To close the application when the "X" is clicked 
		lego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
