package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.notesClass;

/**
 * Servlet implementation class NotesServlet
 */
@WebServlet(urlPatterns= {"/Notes"}, loadOnStartup=1)
public class NotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private notesClass getNotes(int id) {

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

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		// Created a local, empty array list of type Guest Book Entry
		ArrayList<notesClass> noteEntries = new ArrayList<notesClass>();

		// Add the array list to the application scope (Servlet Context)
		getServletContext().setAttribute("notes", noteEntries);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get reference to the arraylist of notes

		ArrayList<notesClass> noteEntries = (ArrayList<notesClass>)getServletContext().getAttribute("notes");

		// Check to see if the search form was submitted
		if (request.getParameter("searchBtn") != null) {
			String searchQuery = request.getParameter("searchQuery");

			// search all text fields

			String allText = searchQuery;
			allText = allText.toLowerCase(); 

			ArrayList<notesClass> searchResults = new ArrayList<notesClass>();
			for(notesClass note : noteEntries) {
				if (note.getName().toLowerCase().matches("(.*)"+allText+"(.*)") || note.getNote().toLowerCase().matches("(.*)"+allText+"(.*)")) {
					searchResults.add(note);
				}

				else if(note.getName().toLowerCase().matches("(.*)"+allText+"(.*)") && note.getNote().toLowerCase().matches("(.*)"+allText+"(.*)")) {
					searchResults.add(note);
				}
			}

			noteEntries = searchResults;
		}


		// set content of the page
		response.setContentType("text/html");

		//get the print writer

		PrintWriter out = response.getWriter();
		out.println("");

		// Generate our HTML
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("	 <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("	 <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("    <title>Notes</title>");
		//style sheet
		out.println("<style>");
		//left boxes
		out.println(" .leftBox{");
		out.println("	min-width: 250px;");
		out.println("	max-width: 350px;");
		out.println("	position: relative; top: 30px; left: 30px;");
		out.println("}"); //end

		//right boxes
		out.println("	.rightBox{");
		out.println("		float: right;");
		out.println("		position: relative; top: 30px; left: 30px;");
		out.println("}"); //end

		//list items
		out.println(".listGroupItem{");
		out.println("	border: 2px solid black;");
		out.println("}"); //end

		//span
		out.println("	span{");
		out.println("	min-width: 200px;");
		out.println("	max-width: 500px;");
		out.println("	min-height: 400px;");
		out.println("	max-height: 550px;");
		out.println("	display: block;");
		out.println("	}"); //end

		out.println("</style>"); //end

		out.println("</head>");
		out.println("<body>");

		out.println("<div class=\"container\">");
		out.println("<div class=\"form-group\">");
		out.println("<form action=\"Notes\" method=\"get\">");
		String searchText = request.getParameter("searchQuery");
		if (searchText == null) {
			searchText = "";
		}

		out.println("  <input type=\"text\" placeholder = \"Enter search query\" value=\"" + searchText + "\" name=\"searchQuery\">");
		out.println("  <input type=\"submit\" class=\"btn btn-outline-primary btn-sm\" name=\"searchBtn\" value=\"Search\">");
		out.println("</form>");
		out.println("</div>"); //form

		// Page-Specific Content Goes Here...
		out.println("<div>");
		
		out.println("<a href=\"Notes\" style=\"font-size: 4em\">My Notes</a>");

		out.println("<div class=\"float-right\">");
		out.println("<a class=\"btn btn-secondary\" href=\"Notes/MakeNote\">Create a Note </a>");
		out.println("</div>");

		out.println("</div>");//whole title & btn


		//printing the note name on the left side

		out.println("<div class=\"leftBox border border-dark\">");
		out.println("<div class=\"list-group\">");
		for(notesClass note: noteEntries) {
			if(note != null) {
				out.println("<a class =\"list-group-item\" href =\"Notes?id=" + note.getId() + "\">"+ note.getName() + "</a>");
			}
		}
		out.println("</div>");
		out.println("</div>");


		//printing the note on the right side

		out.println("<div class =\"rightBox\">");
		out.println("<div>");
		if(request.getParameter("id") == null) {
			out.println("<span> Select a note from the list, or create a new note </span>");
		}

		else{
			int ID = Integer.parseInt(request.getParameter("id"));
			notesClass note = getNotes(ID);
			out.println("<span>");
			out.println(note.getName());
			out.println("<hr style = \"width:75%\">");
			out.println(note.getNote());
			out.println("</span>");

			out.println("<div class=\"float-left\">");
			out.println("<a class=\"btn btn-outline-info bth-sm\" href =\"Notes/EditNote?id=" + note.getId() + "\"> Edit note </a>");
			out.println("</div>"); //left btn

			out.println("<div class=\"float-right\">");
			out.println("<a class=\"btn btn-outline-danger bth-sm\" href =\"Notes/DeleteNote?id=" + note.getId() + "\"> Delete note </a>");
			out.println("</div>"); //right btn


		}

		out.println("</div>");
		out.println("</div>");


		out.println("</div>");
		out.println("</body>");
		out.println("</html>");



	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
