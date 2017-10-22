package cs520.hw4;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Legos1 extends JFrame{
	
	//Declare the instance variables 
	int startX; //Left coordinate 
	int startY; //Top cooridinate 
	int legoWidth; //Width of each block 
	int legoHeight;  //Heigh of each block 
	int baseLength; //The number of blocks in the bottom row 
		
	//Constructor with title 
	public Legos1 ()
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
		int currentY = startY;
		//drawRect to make rectangles 
		for (int row = 1; row <= baseLength; row++)
		{
			//Reset the value of X 
			currentX = startX;
			
			for (int col = 0; col <= baseLength - row; col++)
			{
	        	if (col % 2  == 0)
				{
					g.setColor(Color.red);
				}
				else 
				{
					g.setColor(Color.blue);
				}
	        	g.fillRoundRect(currentX, currentY,legoWidth, legoHeight, 2, 2);	
	            currentX += legoWidth;
			}
			currentY -= legoHeight;
			startX += legoWidth/2;
		}
	}


	//Main method 
	public static void main (String[] args)
	{
		//Create the application object
		Legos1 lego = new Legos1(); 
		//Make the window visible 
		lego.setVisible (true);
		//Set the size of the application window 
		lego.setSize(550, 325);
		//To close the application when the "X" is clicked 
		lego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
