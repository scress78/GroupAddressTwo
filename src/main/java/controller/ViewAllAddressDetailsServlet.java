package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddressBookDetails;

/**
 * Servlet implementation class ViewAllAddressDetailsServlet
 */
@WebServlet("/viewAllAddressDetailsServlet")
public class ViewAllAddressDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllAddressDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddressBookDetailsHelper slh = new AddressBookDetailsHelper();
		List<AddressBookDetails> abc = slh.getLists();
		
		System.out.println("In ViewAllAddressDetailsServlet");
		System.out.println("Address Book Details: " + slh.getLists());
		
		request.setAttribute("allLists", abc);
		if(abc.isEmpty()){
			request.setAttribute("allLists", " ");
		}
		
		getServletContext().getRequestDispatcher("/view-address-book-details.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
