import java.time.LocalDate;



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
		AddressBookUser aaron = new AddressBookUser("Aaron");
		AddressBookUserHelper sh = new AddressBookUserHelper();
		sh.insertAddressBookUser(aaron);
		AddressBookDetailsHelper ldh = new AddressBookDetailsHelper();

		AddressBookDetails aaronList = new AddressBookDetails("Aaron's List",aaron, LocalDate.now());
		ldh.insertNewListDetails(aaronList);
		List<AddressBookDetails> allLists = ldh.getLists();
		for (AddressBookDetails a : allLists) {
		System.out.println(a.toString());
		}
	}

}
