

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AddressBookDetailsHelper;
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
		
		//start a new helper
		AddressBookDetailsHelper dao = new AddressBookDetailsHelper();
		
		//set name
		String name = request.getParameter("listName");
		String userName = request.getParameter("userName");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		
		AddressBookDetails itemToUpdate = dao.searchForListDetailsById(tempId);
		
		// set List Name
		itemToUpdate.setListName(name);
		
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
