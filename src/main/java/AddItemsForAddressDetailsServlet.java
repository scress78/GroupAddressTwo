package deletearchive;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AddressBookDetailsHelper;

/**
 * Servlet implementation class addItemsForAddressDetailsServlet
 */
@WebServlet("/addItemsForAddressDetailsServlet")
public class AddItemsForAddressDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemsForAddressDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		AddressBookDetailsHelper dao = new AddressBookDetailsHelper();
    		request.setAttribute("allItems", dao.getLists());
    		if(dao.getLists().isEmpty()){
    			request.setAttribute("allItems", " ");
    		}
    		
    		getServletContext().getRequestDispatcher("/new-address-book.jsp").forward(request, response);
    		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
