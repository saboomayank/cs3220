package practiceMidterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Email;
import models.ToDoClass;

/**
 * Servlet implementation class ToDoServlet
 */
@WebServlet("/practicemidterm/ToDoServlet")
public class ToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		// get reference
		ArrayList<ToDoClass> toDoList = new ArrayList<ToDoClass>();

		// Add the array list to the application scope (Servlet Context)
		getServletContext().setAttribute("toDo", toDoList);
	}

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
		out.println("	 <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("    <title>NewsLetter Sign-Up</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		// Page-Specific Content Goes Here...

		out.println("<h1>NewsLetter To-Do List</h1>");
		out.println("<form action=\"ToDoServlet\" method=\"post\">");
		out.println("	<div class= \"form-group\">");
		out.println("		<lable for=\"task\"> Task </lable>");
		out.println("		<input type = \"text\" class = \"form-control\" name=\"todo\" placeholder =\"Enter a task\">");
		out.println("	</div>");
		out.println("	<button type=\"submit\" class=\"btn btn-primary\" name=\"searchBtn\"> Add task </button>");
		out.println("</form>");

		ArrayList<ToDoClass> todoList = (ArrayList<ToDoClass>) getServletContext().getAttribute("toDoList");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Was the form submitted?
		if ( request.getParameter("submitBtn") != null) {
			// Yes, it was submitted
			String task = request.getParameter("todo");
			ArrayList<ToDoClass> todoList = (ArrayList<ToDoClass>) getServletContext().getAttribute("toDoList");			
			todoList.add(new ToDoClass(task));
		}

		doGet(request, response);

	}
}
