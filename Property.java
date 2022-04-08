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
public class Property {

	private String city; 
	private String owner; 
	private String propertyName; 
	private double rentAmount; 
	private Plot plot; 


	//No-arg Constructor, creates a new object with default values of empty strings, 0 for rent amount, and default Plot
	public Property(){
		this.city = "";
		this.owner = "";
		this.propertyName = "";
		this.rentAmount = 0 ;
		this.plot = new Plot(0,0,1,1);

	}

	//Copy Constructor, creates a new object using the information of the object passed to it.
	public Property(Property property){
		this.city = property.city;
		this.propertyName = property.propertyName; 
		this.rentAmount = property.rentAmount;
		this.owner = property.owner;
		this.plot = new Plot(property.getPlot().getX(),property.getPlot().getY(),property.getPlot().getWidth(),property.getPlot().getDepth());
	}
	

	//Constructor, Parameterized constructor with no Plot information (uses default Plot where x,y are set to 0, width and depth set to 1)
	public Property(String propertyName, String city, double rentAmount, String owner){
		this.propertyName = propertyName; 
		this.city = city; 
		this.owner = owner; 
		this.rentAmount = rentAmount; 
	}
	
	
	//Constructor, Parameterized constructor
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth){
		this.city = city;
		this.propertyName = propertyName; 
		this.rentAmount = rentAmount; 
		this.owner = owner; 
		this.plot = new Plot(x,y,width,depth);
	}


	//Return the city
	public String getCity(){
		return city;
	}
	
	
	//Return the owner name
	public String getOwner() {
		return owner;
	}
	
	
	//Return the property Name
	public String getPropertyName() {
		return propertyName;
	}
	
	
	//Return the rent amount
	public double getRentAmount() {
		return rentAmount;
	}
	
	
	//Return the plot
	public Plot getPlot() {
		return plot;
	}


	
	//Set the Plot values and return the Plot instance
	public void setPlot(int x, int y, int width, int depth){
		this.plot = new Plot(x,y,width,depth);
	}


	
	//Set the city
	public void setCity(String city) {
		this.city = city; 
	}


	//Set the owner name
	public void setOwner(String owner) {
		this.owner = owner;
	}


	//Set the property name
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName; 
	}


	//Set the rent amount
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount; 
	}
	

	//Prints out the name, city, owner and rent amount for a property
	public String toString() {

		String str = "Property Name: "+this.propertyName+"\n" + 
				"Located in "+this.city+"\n" + 
				"Belonging to: "+this.owner+"\n" + 
				"Rent Amount: "+this.rentAmount+ " ";
		
		return str;
	}

}