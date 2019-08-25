package midterm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.notesClass;

/**
 * Servlet implementation class DeleteNote
 */
@WebServlet("/Notes/DeleteNote")
public class DeleteNote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the id of the entry we want to delete
		int id = Integer.parseInt( request.getParameter("id") );

		// Get a reference to the guest book
		ArrayList<notesClass> noteEntries = (ArrayList<notesClass>) getServletContext().getAttribute("notes");

		// Remove the entry with the specified id
		for(notesClass note : noteEntries) {
			if (note.getId() == id) {
				noteEntries.remove(note);
				break;
			}				
		}

		// Redirect the User back to Guest Book
		response.sendRedirect("../Notes");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
