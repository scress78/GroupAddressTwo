

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AddressBookDetailsHelper;
import controller.AddressHelper;
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
		AddressHelper ah = new AddressHelper();
		
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
				System.out.println("InBookNavigationServlet/edit");
				// from to-do-list-by-user.jsp
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				// specific book returned here
				AddressBookDetails listToEdit = dao.searchForListDetailsById(tempId);
				
				
				// sets attributes in edit-address-book-details.jsp
				// need methods from ToDoListDetailsHelper
				// SO SO IMPORTANT TO DO BELOW FIRST
				request.setAttribute("listToEdit", listToEdit);
				
				request.setAttribute("listName", listToEdit.getListName());
				
				request.setAttribute("userName", listToEdit.getAddressBookUser().getUserName());
				
				request.setAttribute("dateStamp", listToEdit.getDateStamp());

				/*
				 * No longer used but took so long to figure out, couldn't bare deleting
				System.out.println("List of Addresses in Current Book: " + listToEdit.getListOfAddresses());
				request.setAttribute("allItemsToAdd", listToEdit.getListOfAddresses());
				if(listToEdit.getListOfAddresses().isEmpty()) {
					request.setAttribute("allItemsToAdd", "");
				}
				*/
				
				//rather than above.. FINALLY set edit addresses to have ALL available addresses
				System.out.println("List of ALL AVAILABLE Addresses: " + ah.showAllItems());
				request.setAttribute("allItems", ah.showAllItems());
				System.out.println("In AddItemsForAddressBookServlet");
				System.out.println(ah.showAllItems());
				if(ah.showAllItems().isEmpty()){
					request.setAttribute("allItems", " ");
				}
			
				
				
				AddressBookDetailsHelper daoForItems = new AddressBookDetailsHelper();
				
				//System.out.println("Address Details Lists: " + daoForItems.getLists());
				
				// below is get lists??
				
				// showAllItems previously
				/*
				request.setAttribute("allItems", daoForItems.getLists());
				if(daoForItems.getLists().isEmpty()){
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
