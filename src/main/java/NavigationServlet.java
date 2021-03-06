import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AddressHelper;
import model.Address;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		String act = request.getParameter("doThisToItem");
		
		//
		AddressHelper dao = new AddressHelper();
		
		String path = "/ViewAllAddressServlet";
		if (act.equals("delete")) {
			try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					System.out.println("Temp ID: " + tempId);
					
					Address itemToDelete = dao.searchForItemById(tempId);
					dao.deleteItem(itemToDelete);
				} 
			catch (NumberFormatException e) {
					System.out.println("Forgot to select an address");
				} 
			}
		
		else if (act.equals("edit")) {
			// note null int exception currently if no radio button selected! 
			// low priority 3/2/22 (can be resolved with proper routing to try/catch in EditAddressServlet)
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Address itemToEdit = dao.searchForItemById(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			path = "/edit-address.jsp";
			}

		
		else if (act.equals("add")) {
		path = "/new-address.jsp";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
		}

}


