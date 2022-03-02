import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AddressHelper;
import model.Address;


/**
 * Servlet implementation class CreateNewAddressServlet
 */
@WebServlet("/CreateNewAddressServlet")
public class CreateNewAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddressHelper lih = new AddressHelper();
		
		// matches input field in new-list.jsp
		String Name = request.getParameter("name");
		String Address = request.getParameter("address");
		
		System.out.println("Contact Name: "+ Name);
		System.out.println("Street Address: "+ Address);

		
		Address ad = new Address(Name, Address);
		
		AddressHelper adh = new AddressHelper();
		
		adh.insertItem(ad);
		
		//returns a list of all addresses, does not print
		System.out.println(adh.showAllItems());
		//adh.showAllItems();
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
