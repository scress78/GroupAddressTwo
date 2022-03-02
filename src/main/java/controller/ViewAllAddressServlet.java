package controller;


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
@WebServlet("/viewAllAddressServlet")
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
		AddressHelper lih = new AddressHelper();
		
		request.setAttribute("allItems", lih.showAllItems());
		
		// below should be address-list.jsp
		String path = "/address-list.jsp";
		
		// previous
		//if(lih.showAllItems().isEmpty()){path = "/index.html";}
		//try
		if(lih.showAllItems().isEmpty()){path = "/index.html";}
		
		getServletContext().getRequestDispatcher(path).forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
