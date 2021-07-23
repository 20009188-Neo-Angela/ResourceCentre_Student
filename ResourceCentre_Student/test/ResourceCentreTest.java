import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;

	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;

	public ResourceCentreTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList = new ArrayList<Camcorder>();
		chromebookList = new ArrayList<Chromebook>();
	}


	@Test
	public void testAddCamcorder() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));

		// Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}

	@Test
	public void testAddChromebook() {
		// fail("Not yet implemented");
		// write your code here
		// Item list is not null, so that can add a new item

				assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
				
				//Given an empty list, after adding 1 item, the size of the list is 1
				ResourceCentre.addChromebook(chromebookList, cb1);		
				assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());
				
				//The item just added is as same as the first item of the list
				assertSame("Test that Chromebook is added same as 1st item of the list?", cb1, chromebookList.get(0));
				
				//Add another item. test The size of the list is 2?
				ResourceCentre.addChromebook(chromebookList, cb2);
				assertEquals("Test that Chromebook arraylist size is 2?", 2, chromebookList.size());
		assertNotNull("Test if there is valid Camcorder arraylist to add to", chromebookList);

		// Given an list that have already 2 elements inside, after adding 1 item, the size of the list is 3
		ResourceCentre.addChromebook(chromebookList, cb1);
		assertEquals("Test if that Chromebook arraylist size is 3?", 3, chromebookList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Chromebook is added same as 1st item of the list?", cb1, chromebookList.get(0));

		// Add another item. test The size of the list is 4?
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test that Chromebook arraylist size is 4?", 4, chromebookList.size());
	}

	@Test
	public void testRetrieveAllCamcorder() {
		// Test if Item list is not null but empty, so that can add a new item
		
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);

		// test if the list of camcorders retrieved from the SourceCentre is empty
		String allCamcorder = ResourceCentre.retrieveAllCamcorder(camcorderList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());

		// test if the expected output string same as the list of camcorders retrieved
		// from the SourceCentre
		allCamcorder = ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-12s %-22s %-15s %-15s %-7d\n", "CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-12s %-22s %-15s %-15s %-7d\n", "CC0012", "Sony DSC-RX100M7", "Yes", "", 20);

		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);

	}

	@Test
	public void testRetrieveAllChromebook() {
		// fail("Not yet implemented");
		// write your code here
		//syaz
		
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);

		// test if the list of chromebooks retrieved from the SourceCentre is empty
		String allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);
		String testOutput = "";
		assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());

		// test if the expected output string same as the list of camcorders retrieved
		// from the SourceCentre
		allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);

		testOutput = String.format("%-12s %-22s %-15s %-15s %-7s\n", "CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
		testOutput += String.format("%-12s %-22s %-15s %-15s %-7s\n", "CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");

		assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);

	}

	@Test
	public void testDoLoanCamcorder() {
		// fail("Not yet implemented");
		// write your code here
		//yt  
		assertNotNull("Test if there is valid Camcorder arraylist to loan from", camcorderList);
		ResourceCentre.addCamcorder(camcorderList, cc1);
		
		//normal
		Boolean valid = ResourceCentre.doLoanCamcorder(camcorderList,  "CC0011", "8-8-2020");
		assertTrue("Test if an item is available to loan", valid);
		
		//error condition 
		valid = ResourceCentre.doLoanCamcorder(camcorderList,  "CC0011", "8-8-2020");
		assertFalse("Test if an same item is NOT available for loan", valid);
		
		//error condition 
		ResourceCentre.addCamcorder(camcorderList, cc2);
		cc2.setIsAvailable(false);
		valid = ResourceCentre.doLoanCamcorder(camcorderList, "CC0012", "8-8-2020");
		assertFalse("Test that item is unavailable for loan", valid);
		
		//error condition 
		valid = ResourceCentre.doLoanCamcorder(camcorderList, "CC0013", "8-8-2020");
		assertFalse("Test that item does not exist and is unavailable for loan", valid);
		
		
		
	}

	@Test
	public void testDoLoanChromebook() {
		// fail("Not yet implemented");
		// write your code here
		//Kidson
				assertNotNull("Test if there is valid ChromeBook arrayList to load From", chromebookList);
				ResourceCentre.addChromebook(chromebookList, cb1);
				
				Boolean valid = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020");
				assertTrue("Test if an item is available to loan", valid);
				
				valid = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020");
				assertFalse("Test if an item is NOT available for load", valid);
				
				ResourceCentre.addChromebook(chromebookList, cb2);
				cb2.setIsAvailable(false);
				valid = ResourceCentre.doLoanChromebook(chromebookList, "CB0012", "8-8-2020");
				assertFalse("Test that item is unavailable for loan", valid);
				
				//error condition 
				valid = ResourceCentre.doLoanChromebook(chromebookList, "CB0012", "8-8-2020");
				assertFalse("Test that item does not exist and is unavailable for loan", valid);
		
	}

	@Test
	public void testDoReturnCamcorder() {
		// fail("Not yet implemented");
		// write your code here
		//yt
		
		//boundary
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		ResourceCentre.addCamcorder(camcorderList, cc1);
		
		//error
		Boolean isFound = ResourceCentre.doReturnCamcorder(camcorderList, "CC0011");
		assertFalse("Test if available camcorder CC0011 is returned", isFound);
		
		//normal 
		ResourceCentre.addCamcorder(camcorderList, cc2);
		cc2.setIsAvailable(false);
		isFound = ResourceCentre.doReturnCamcorder(camcorderList, "CC0012");
		assertTrue("Test if loaned out camcorder CC0012 is returned" , isFound);
		
		//error
		isFound = ResourceCentre.doReturnCamcorder(camcorderList, "CC0013");
		assertFalse("Test if non-existing camcorder CC0013 is returned", isFound);

	}

	@Test
	public void testDoReturnChromebook() {
		// fail("Not yet implemented");
				// write your code here
				//Hannah
				
				//boundary
				assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
				ResourceCentre.addChromebook(chromebookList, cb1);
				
				//error
				Boolean isFound = ResourceCentre.doReturnChromebook(chromebookList, "CB0011");
				assertFalse("Test if available chromebook CB0011 is returned", isFound);
				
				//normal 
				ResourceCentre.addChromebook(chromebookList, cb2);
				cc2.setIsAvailable(false);
				isFound = ResourceCentre.doReturnChromebook(chromebookList, "CB0012");
				assertFalse("Test if loaned out chromebook CB0012 is returned" , isFound);
				
				//error
				isFound = ResourceCentre.doReturnChromebook(chromebookList, "CB0013");
				assertFalse("Test if non-existing chromebook CB0013 is returned", isFound);

}

	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
