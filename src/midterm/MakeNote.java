package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.notesClass;

/**
 * Servlet implementation class MakeNote
 */
@WebServlet("/Notes/MakeNote")
public class MakeNote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
		out.println("    <title>Make a note</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		out.println("<h1>Create a note</h1>");
		out.println("<form action=\"MakeNote\" method=\"post\">");

		String title = request.getParameter("title");
		if (title == null)
			title = "";


		out.println("	Title: <input type=\"text\" name=\"title\" value=\"" + title + "\"><br>");

		if (request.getAttribute("titleError") != null)
			out.println("  <p class=\"text-danger\">Please enter a title</p>");

		out.println("	Note: <br>");

		String note = request.getParameter("note");
		note = note == null ? "" : note;

		out.println("	<textarea name=\"note\">" + note + "</textarea><br>");

		if (request.getAttribute("messageError") != null)
			out.println("  <p class=\"text-danger\">Please enter a note</p>");

		out.println("	<input type=\"submit\" name=\"submitBtn\" value=\"Add Note\">");
		out.println("</form>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Was the form submitted?
		if ( request.getParameter("submitBtn") != null) {
			// Yes, it was submitted

			// Read the name and message from the request
			String title = request.getParameter("title");
			String note = request.getParameter("note");

			boolean isValidTitle = title != null && title.trim().length() > 0;
			boolean isValidNote = note != null && note.trim().length() > 0;

			if (isValidTitle && isValidNote) {
				// Get a reference to the guest book
				ArrayList<notesClass> noteEntries = (ArrayList<notesClass>) getServletContext().getAttribute("notes");

				// Adding a new entry to the guest book
				noteEntries.add(new notesClass(title, note));	
			}
			else {

				// Introduce a new scope: REQUEST scope
				if (!isValidTitle)
					request.setAttribute("titleError", true);

				if (!isValidNote)
					request.setAttribute("noteError", true);


				doGet(request, response);
				return;
			}

		}

		// Send the user (redirect) back to the main page
		response.sendRedirect("../Notes");


	}

}
