package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;
import models.notesClass;

/**
 * Servlet implementation class EditNote
 */
@WebServlet("/Notes/EditNote")
public class EditNote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public notesClass getNotes(int id) {

		// get reference to the note class
		ArrayList<notesClass> noteEntries = (ArrayList<notesClass>)getServletContext().getAttribute("notes");

		for(notesClass note: noteEntries) {
			if(note.getId() == id) {
				return note;
			}
		}

		// if no note found return null
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the ID of the entry we are editing
		int id = Integer.parseInt( request.getParameter("id") );

		// Get a reference to the entry matching the specified ID
		notesClass note = getNotes(id);

		// If we can't find the entry, there's nothing to do. Go back to the main page.
		if (note == null) {
			response.sendRedirect("../Notes");;
			return;
		}

		// Set the content type to HTML
		response.setContentType("text/html");

		// Get a reference to the output stream
		PrintWriter out = response.getWriter();

		// Generate our HTML
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("	 <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("	 <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("    <title>Edit note</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		out.println("<h1>Edit note</h1>");
		out.println("<form action=\"EditNote\" method=\"post\">");
		out.println("	Title: <input type=\"text\" name=\"title\" value=\"" + note.getName() + "\"><br>");
		out.println("	Note: <br>");
		out.println("	<textarea name=\"note\">" + note.getNote() + "</textarea><br>");
		out.println("   <input type=\"hidden\" name=\"id\" value=\"" + note.getId() + "\">");
		out.println("	<input type=\"submit\" name=\"submitBtn\" value=\"Save note\">");
		out.println("</form>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String note_description = request.getParameter("note");
		
		// Get the ID of the post being saved
		int id = Integer.parseInt( request.getParameter("id") );
		
		// Get a reference to the entry matching the specified ID
		notesClass note = getNotes(id);
		
		
		// Save the changes
		note.setName(title);
		note.setNote(note_description);
		
		// Redirect back to Guest Book
		response.sendRedirect("../Notes");

	}

}
