

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AddressBookDetailsHelper;
import model.AddressBookDetails;




/**
 * Servlet implementation class BookNavigationServlet
 */
@WebServlet("/BookNavigationServlet")
public class BookNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub

		
      		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		AddressBookDetailsHelper dao = new AddressBookDetailsHelper();
		
		String act = request.getParameter("doThisToBook");
		System.out.println(act);
		
		if (act == null) {
			// no button has been selected working
			getServletContext().getRequestDispatcher("/viewAllAddressDetailsServlet").forward(request, response);
		} else if (act.equals("delete")) {
			// delete working!
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AddressBookDetails listToDelete = dao.searchForListDetailsById(tempId);
				dao.deleteList(listToDelete);
				
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllAddressDetailsServlet").forward(request, response);
			}
			
		} else if (act.equals("edit")) {
			try {
				//need edit-address-book-details
				
				// from to-do-list-by-user.jsp
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AddressBookDetails listToEdit = dao.searchForListDetailsById(tempId);
				
				// need methods from ToDoListDetailsHelper
				request.setAttribute("listToEdit", listToEdit);
				
				// sets attributes in edit-address-book-details.jsp
				
				request.setAttribute("listName", listToEdit.getListName());
				
				//might not be correct yet
				request.setAttribute("userName", listToEdit.getAddressBookUser().getUserName());
				
				AddressBookDetailsHelper daoForItems = new AddressBookDetailsHelper();
				
				// below is get lists??
				/*
				request.setAttribute("allItems", daoForItems.showAllItems());
				if(daoForItems.showAllItems().isEmpty()){
					request.setAttribute("allItems", " ");
				}
				
				*/

				// need one final .jsp if this is going to work
				getServletContext().getRequestDispatcher("/edit-address-book-details.jsp").forward(request, response);
				
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllAddressDetailsServlet").forward(request, response);
			}
			
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-address-book.jsp").forward(request, response);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		
	}

}
