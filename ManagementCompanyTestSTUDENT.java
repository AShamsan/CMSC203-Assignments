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

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestSTUDENT {
	Property p1 ,p2,p3,p4,p5,p6;
	ManagementCompany m ; 
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		m= new ManagementCompany("Abdullah", "685300",9);
				
		//student add three properties, with plots, to mgmt co
		p1 = new Property("The Tree House", "Rockville", 2300.00, "Johnathan Schwimmer", 2, 1, 2, 2);
		p2 = new Property("Orient Pearl", "Gaithersburg", 710, "Ghaidan Shamsan",4, 1, 2, 2);
		p3 = new Property("Pyramids", "Arlington", 1890, "Hendrick Nguyen",6, 1, 2, 2);
		
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
	}

	@After
	public void tearDown()  {
		
		//student set mgmt co to null  
		p1=p2=p3=p4=p5=p6=null;
		m=null;
	}
			

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		p4 = new Property ("The Fort", "Bethesda", 3500.00, "Maxuel Ross");
		
		//student should add property with 8 args
		p5 = new Property("Dream", "Takoma Park", 1800.00, "Bruce Wayne", 1, 2, 3,4);
		
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		p6 = new Property("Beach Hut", "Miami", 4700.00, "Dwayne Johnson", 7,8,6,9);

	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(m.totalRent(),4900.0,0);
	}

	 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(m.maxRentProp(), 2300.0, 0);
	

	}

}

