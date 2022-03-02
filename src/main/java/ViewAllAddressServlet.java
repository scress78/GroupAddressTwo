

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AddressHelper;

/**
 * Servlet implementation class ViewAllAddressServlet
 * This servlet helps to view all possible addresses
 */
@WebServlet("/ViewAllAddressServlet")
public class ViewAllAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In ViewAllAddressServlet");
		AddressHelper dao = new AddressHelper();
		request.setAttribute("allItems", dao.showAllItems());
		
		String path = "/address-list.jsp";

		if(dao.showAllItems().isEmpty()){
			path = "/address-list.jsp"; //previously index.html can change back for troubleshooting
			request.setAttribute("allItems", " ");
		}
		
		//possible to change back to path
		getServletContext().getRequestDispatcher("/address-list.jsp").forward(request, response);
		//getServletContext().getRequestDispatcher(path).forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
