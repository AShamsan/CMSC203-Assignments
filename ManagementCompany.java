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

public class ManagementCompany {
	private final int  MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10; 

	private double mgmFeePer;
	private String name; 
	private Property[] properties; 
	private String taxID; 
	private Plot plot; 
	

	/*No-Arg Constructor that creates a ManagementCompany object using empty strings 
	 * and a default Plot. "properties" array is initialized here as well.
	 */
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}


	
	/*Constructor Creates a ManagementCompany object using the passed information. 
	 * Mgmt Co plot is initialized to default Plot. "properties" array is initialized here as well.
	 */
	public ManagementCompany(String name,String taxID,double mgmFee) {
		this.name = name; 
		this.taxID = taxID; 
		this.mgmFeePer = mgmFee; 
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}


	/*Constructor Creates a ManagementCompany object using the passed information. 
	"properties" array is initialized here as well.
	*/
	public ManagementCompany(String name,String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID; 
		this.mgmFeePer = mgmFee; 
		this.plot = new Plot(x, y, width, depth);
		this.properties =new Property[MAX_PROPERTY];
	}


	/*Copy Constructor creates a ManagementCompany object using 
	 * another ManagementCompany object. "properties" array is initialized here as well.
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		this.properties = new Property[MAX_PROPERTY];
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = otherCompany.plot;
	}



	//Returns the name
	public String getName() {
		return name; 
	} 


	//Returns the plot
	public Plot getPlot() {
		return plot;
	}


	//Adds the property object to the "properties" array
	public int addProperty(Property property) {
		
		//Statement runs if property p is empty "null" and returns -2
		  if (property == null)
		  	{
			  	return -2;
		  	}
	       
		  //Runs if property p is out of management company range and return -3
		  else if (!(this.plot.encompasses(property.getPlot())))
	       		{
			  		return -3;
	       		}
		  
		  
		  //A loop that checks each property inside the array properties
		  for (int i = 0; i < this.properties.length; i++) 
		  	{
				
			  	//Checks if property at each index of the array is not "null" 
			  	if (!(properties[i] == null)) 
			  	{
			  			//Runs if the property at each index overlaps with other property and return -4
				  		if (properties[i].getPlot().overlaps(property.getPlot())) 
				  		{	
				  			return -4;
				  		}
			  	}
			  
			  //Runs if the property at the index is empty "null", if so
			  //it will be initialized into the value of the passed property and then
			  // return the index
			  else 
			  	{
					properties[i] = property;
					return i;
			  	}	
	
		  }
	        
		  	//Returns -1 if there was a problem in adding the property
	        return -1;
	        
	}


	//Creates a property object and adds it to the "properties" array, in a default plot.
	public int addProperty(String name,String city,double rent,String owner) {		
		
		//Call addProperty and pass a new Property (of 4 args & default plot (0,0,1,1)) object as a parameter
		// and return the returned value
		return addProperty(new Property(name,city,rent,owner));

	}

	
	//Creates a property object and adds it to the "properties" array.
	public int addProperty(String name,String city,double rent,String owner, int x, int y, int width,int depth) {
		
		//Call addProperty and pass a new Property (of 8 args) object as a parameter
		// and return the returned value
		return addProperty(new Property(name,city,rent,owner,x,y,width,depth));
		
	}
	

	//Displays the information of the property at index i
	public String displayPropertyAtIndex(int i){
		
		//Return the components of the property at the passed index after Calling the toString method
		return properties[i].toString();
		
	}

	//Return the MAX_PROPERTY constant that represent the size of the "properties" array.
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}


	//This method finds the property with the maximum rent amount (using maxRentPropertyIndex and getRentAmount methods) 
	//and returns its toString result.
	public double maxRentProp() {
		
		return properties[maxRentPropertyIndex()].getRentAmount();
	}


	//This method finds the index of the property with the maximum rent amount.
	private int maxRentPropertyIndex() {
		//Define and initialize the int that will hold the index value
		int ind = 0;

		double max = Integer.MIN_VALUE;
		
		//A loop to check the rent in every property in the array properties
		for(int i = 0; i < MAX_PROPERTY; i++) 
			{
			
				//Statement runs if the property at the index is not empty "null"
				if(!(properties[i]==null)) 
					{
					
						//Statement runs if the rent of property at the index is larger than the int max
						if(properties[i].getRentAmount() > max) 
							{
					
								//Max is is set to equal the rent of the property of the largest rent 
								max = properties[i].getRentAmount();
					
								//Set int ind to equal i
								ind= i; 
								}
						}

				}
		
		//return ind
		return ind;
	}


	//Displays the information of all the properties in the "properties" array
	public String toString() {
		String str = "";
		str = ("List of the properties for " + getName() + " , taxID: " + taxID+"\n"+"__________________________________________________\n");
		double total = totalRent();
		double mgmFee = ((mgmFeePer*total)/100);
		
		//A loop to add the information of each property in the array properties
		for(int i = 0; i < MAX_PROPERTY; i++) 
			{
				//Checks if the property at i is not empty "null"
				if(!(properties[i] == null)) 
				{
				
					str += (" Property Name: " + properties[i].getPropertyName() +"\n" + "  Located in: " + properties[i].getCity() + "\n" + 
							"  Belonging to: " + properties[i].getOwner() + "\n" + 
							"  Rent Amount: " + properties[i].getRentAmount()+"\n"); 
				
				}
				

			}
		
		
		str += ("__________________________________________________" + "\n"+"Total management Fee: " + (mgmFee));
		


		return str;
	}

	/*This method accesses each "Property" object within the array "properties"
	and sums up the property rent and returns the total amount.
	*/
	public double totalRent() {
		double totRent = 0.0;
		//A loop to add-on the rent of each property in the array properties
		for (int i = 0; i < MAX_PROPERTY; i++) {

			if(!(properties[i] == null)) {
				totRent += properties[i].getRentAmount();
				
			}

		}

		return totRent; 
	}


}
