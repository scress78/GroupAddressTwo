import java.time.LocalDate;
import java.util.List;

import controller.AddressBookDetailsHelper;
import controller.AddressBookUserHelper;
import model.AddressBookDetails;
import model.AddressBookUser;

/**
 * ajwinters@dmacc.edu - ajwinters
 * CIS175 - Spring 2022
 * Mar 2, 2022
 */

/**
 * @author winte
 *
 */
public class AddressBookDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//test user creation
		AddressBookUser aaron = new AddressBookUser("Aaron");
		System.out.println("Show Address Book User: " + aaron.toString());
		
		
		// ** IMPORTANT NOTE HERE.. the lines containing insertAddressBookUser or insertNewListDetails CANNOT BE DUPLICATED! (lines 35 and 50!)
		//  Comment one or the other out. Can't exactly visualize why but having both lines active generates a primary key error!
		
		// ALL LINES BELOW beginning with AddressBookUserHelper and ending in showAllAddressBookUsers are tested and working!
		//AddressBookUserHelper sh = new AddressBookUserHelper();
		//sh.insertAddressBookUser(aaron);
		//System.out.println("Show All Address Book Users in Helper");
		//System.out.println(sh.showAllAddressBookUsers());
		
		AddressBookDetailsHelper ldh = new AddressBookDetailsHelper();
		
		// testing below to see whether issue is simply with datestamp
		// issue is not with timestamp.. duplicate primary key error   <--- can delete this, explained above.
		
		//Both of below now tested and working! comment out one of following two lines or the other. both constructors should now work!
		AddressBookDetails aaronList = new AddressBookDetails("Aaron's List",aaron, LocalDate.now());
		//AddressBookDetails aaronList = new AddressBookDetails("Aaron's List", aaron);
		System.out.println("Show Address Book Details for Aaron's List: " + aaronList.toString());

		
		ldh.insertNewListDetails(aaronList);
		List<AddressBookDetails> allLists = ldh.getLists();
		System.out.println("Print all Address Book Groups (ie BookName, User and Datestamp)");	
		for (AddressBookDetails a : allLists) {
			System.out.println(a.toString());
		}
	}

}
