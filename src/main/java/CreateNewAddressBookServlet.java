

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AddressBookDetailsHelper;
import controller.AddressHelper;
import model.Address;
import model.AddressBookDetails;
import model.AddressBookUser;

/**
 * Servlet implementation class CreateNewAddressBookServlet
 */
@WebServlet("/CreateNewAddressBookServlet")
public class CreateNewAddressBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewAddressBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		AddressHelper lih = new AddressHelper();
		
		// matches input field in new-address-book.jsp
		String addressBookName = request.getParameter("addressBookName");
		System.out.println("Address Book Name: "+ addressBookName);
		
		//match with parameter in new-address-book.jsp
		String userName = request.getParameter("userName");
		System.out.println("Username: "+ userName);
		
		// get all selected items from new-address-book.jsp
		String[] selectedAddresses =request.getParameterValues("allItemsToAdd");
		List<Address> selectedAddressesInList = new ArrayList<Address>();
		
		//make sure something was selected – otherwise we get a nullpointer exception
		if (selectedAddresses != null && selectedAddresses.length > 0){
			for(int i = 0; i<selectedAddresses.length; i++) {
				System.out.println(selectedAddresses[i]);
				Address c = lih.searchForItemById(Integer.parseInt(selectedAddresses[i]));
				selectedAddressesInList.add(c);
				}
		}
		
		//addresses being added
		System.out.println(selectedAddressesInList);
		
		// make a new user, assign that user a username
		AddressBookUser user = new AddressBookUser(userName);
		
		//AddressBookDetails, initialize with the name of the AddressBook, and the username? add addresses below
		AddressBookDetails sld = new AddressBookDetails(addressBookName, user, LocalDate.now());
		
		//set the Addresses, with AddressBookDetails method
		//sld.setListOfAddresses(selectedAddressesInList);
		
		System.out.println(sld.toString());
		
		AddressBookDetailsHelper slh = new AddressBookDetailsHelper();
		
		// issue here (insert trying to two parameters and doesn't have ID)
		slh.insertNewListDetails(sld);
		
		System.out.println("Success!");
		System.out.println(sld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllAddressDetailsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
