

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AddressHelper;
import model.Address;

/**
 * Servlet implementation class EditAddressServlet
 */
@WebServlet("/editAddressServlet")
public class EditAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAddressServlet() {
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
		AddressHelper dao = new AddressHelper();
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Address itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setName(name);
		itemToUpdate.setAddress(address);
		dao.updateItem(itemToUpdate);
		getServletContext().getRequestDispatcher("/ViewAllAddressServlet").forward(request, response);
	}

}
