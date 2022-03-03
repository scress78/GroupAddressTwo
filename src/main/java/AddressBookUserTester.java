import java.util.List;

import controller.AddressBookUserHelper;
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
public class AddressBookUserTester {
	
	public static void main(String[] args) {
		AddressBookUser spencer = new AddressBookUser("Spencer");
		AddressBookUserHelper sh = new AddressBookUserHelper();
		sh.insertAddressBookUser(spencer);
		List<AddressBookUser> allAddressBookUsers = sh.showAllAddressBookUsers();
		for(AddressBookUser a: allAddressBookUsers) {
		System.out.println(a.toString());
		}
	}

}
