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
import models.GuestBookEntry;

@WebServlet(urlPatterns= {"/practicemidterm/email"}, loadOnStartup=1)
public class email extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Create local ArrayList of emails  
		ArrayList<Email> emails = new ArrayList<Email>();
		// Add the array list to the application scope (Servlet Context)
		getServletContext().setAttribute("email", emails);
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
		out.println("<h1>NewsLetter Sign-Up</h1>");
		out.println("<form action=\"email\" method=\"post\">");
		out.println("	<div class= \"form-group\">");
		out.println("		<lable for=\"email\"> Email address </lable>");
		out.println("		<input type = \"email\" class = \"form-control\" id=\"email\" placeholder =\"Enter email\">");
		out.println("	</div>");
		out.println("	<button type=\"submit\" class=\"btn btn-primary\"> Sign-Up </button>");
		out.println("</form>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Was the form submitted?
		if ( request.getParameter("submitBtn") != null) {
			// Yes, it was submitted

			// Read the email
			String name = request.getParameter("email");
			//get reference to emails
			ArrayList<Email> emails = (ArrayList<Email>) getServletContext().getAttribute("email");
			// Adding a new entry to the emails
			emails.add(new Email(name));

		}
		
		doGet(request, response);

	}
}
