

import java.io.IOException;
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
 * Servlet implementation class EditAddressBookDetailsServlet
 */
@WebServlet("/EditAddressBookDetailsServlet")
public class EditAddressBookDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAddressBookDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// can currently change the book name. Not able to preform other maintenance items. It's a start.
		System.out.println("In EditAddressBookDetailsServlet");
		//start a new helper
		AddressBookDetailsHelper dao = new AddressBookDetailsHelper();
		AddressHelper lih = new AddressHelper();
		
		//set name
		String name = request.getParameter("listName");
		String userName = request.getParameter("userName");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		String[] selectedAddresses =request.getParameterValues("allItems");
		List<Address> selectedAddressesInList = new ArrayList<Address>();
		System.out.println("New Selected Addresses: " + selectedAddresses);
		System.out.println("Array List Addresses: " + selectedAddressesInList);
		
		
		//make sure something was selected – otherwise we get a nullpointer exception
		// set array list
		if (selectedAddresses != null && selectedAddresses.length > 0){
			for(int i = 0; i<selectedAddresses.length; i++) {
				System.out.println(selectedAddresses[i]);
				// you now have the list of all ints of addresses, almost almost almost there.. below was commented out
				// this SHOULD now be working. HFS
				Address c = lih.searchForItemById(Integer.parseInt(selectedAddresses[i]));
				selectedAddressesInList.add(c);
				}
		}
		
		AddressBookDetails itemToUpdate = dao.searchForListDetailsById(tempId);
		
		// set List Name
		itemToUpdate.setListName(name);
		itemToUpdate.setListOfAddresses(selectedAddressesInList);
		
		//set AddressBook UserName
		// worried this could throw off one to many relationships.. might not implement. Seems to not be working.
		// decent idea. not going to troubleshoot before clean-up and styling. Will see if feel like more effort
		AddressBookUser nbu = new AddressBookUser();
		nbu = itemToUpdate.getAddressBookUser();
		nbu.setUserName(userName);
		itemToUpdate.setAddressBookUser(nbu);

		dao.updateList(itemToUpdate);
		
		//navigate back to view all Address Books
		getServletContext().getRequestDispatcher("/viewAllAddressDetailsServlet").forward(request, response);
	}

}
