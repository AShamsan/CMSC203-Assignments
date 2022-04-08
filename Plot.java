/*Class: CMSC203 
 Program: Assignment 4 Design
 Instructor: Prof. Khandan Monshi
 Summary of Description: (Give a brief description for a Program) 
 Due Date: 04/8/2021
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: Abdullah Shamsan
*/

/**
 * 
 * @author Abdullah Shamsan
 *
 */

public class Plot {
	
	//Create Plot class attributes
	private int x; 
	private int y; 
	private int width; 
	private int depth; 


	//No-arg Constructor, creates a default Plot with args x=0, y=0, width=1, depth=1
	public Plot(){
		x = 0; 
		y = 0; 
		width = 1;
		depth = 1; 
	}

	//Copy Constructor, creates a new object using the information of the object passed to it.
	public Plot(Plot p){
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.width; 
	}


	//Parameterized Constructor
	public Plot(int x, int y, int width, int depth){
		this.x = x; 
		this.y = y; 
		this.width = width; 
		this.depth = depth; 
	}


	
	//determines if this plot overlaps the parameter,returns true if the two plots overlap, false otherwise
	public boolean overlaps(Plot plot) {
		
		//This statement runs if the plots doesn't overlap in the vertical direction and return false
		if (this.y + depth <= plot.getY() || this.y >=plot.getY()+plot.getDepth() ) {
			return false;
		}
		
		//This statement runs if the plots doesn't overlap in the horizontal direction and return false
		 if (this.x + width <= plot.getX() || this.x >= plot.getX()+plot.getWidth()) {
			return false;
		}
		
		else 
		return true;


	}
	
	
	//Takes a Plot instance and determines if the current plot contains it.
	public boolean encompasses(Plot plot) {
		 
		//this nested if-statement runs if the current plot is contained in the Plot instance and return true
		if(this.getX() <= plot.getX() && x + this.getWidth() >= plot.getX()+plot.getWidth())
		{
			if (this.getY()<=plot.getY() && y + this.getDepth() >= plot.getY()+plot.getDepth())
			{
				return true; 
			}
		}
		
		
		return false;
	}
	
	
	//Sets the x value
	public void setX(int x) {
		this.x = x;
	}
	
	
	//Returns the x value
	public int getX() {
		return x; 
	}


	//Sets the y value
	public void setY(int y) {
		this.y = y;
	} 
	
	
	//Returns the y value
	public int getY() {
		return y; 
	}


	//Sets the width value
	public void setWidth(int w) {
		this.width = w;
	}


	//Returns the width value
	public int getWidth(){
		return width;
	}


	//Sets the depth value
	public void setDepth(int d) {
		this.depth = d;
	}
	
	
	//Returns the depth value
	public int getDepth() {
		return depth; 
	}


	
	//Prints the X,Y of the upper left corner, the width and the depth
	public String toString() {
		String str = "Upper left: ("+this.getX()+","+this.getY()+"); Width: "+this.getWidth()+" Depth: "+this.getDepth();
		
		return str;
	}


}

