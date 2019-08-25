package lab2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lab2/RequestParameters")
public class RequestParameters extends HttpServlet {
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
		out.println("	 <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("    <title>Request Parameters - lab 2</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		// Page-Specific Content Goes Here...
		out.println("<h1>Request Parameters</h1>");
		out.println("<h2>Current Date &amp; Time</h2>");
		out.println("<p class=\"lead\">The current date and time is: " + new Date() + "</p>");
		out.println("<h3> Rquest Method: " + request.getMethod() + "</h3>");
		
		out.println("<table class=\"table table-border table-stripped table-hover\">");
		out.println(" <thead>");
		out.println(" <tr>");
		out.println(" <th scope=\"col\">Parameter Names</th>");
		out.println("<th scope=\"col\">Parameters Values</th>");
		out.println(" </tr>");
		out.println("</thead>");

		out.println(" <tbody>");
		Enumeration<String> parameterNames = request.getParameterNames(); 
		while(parameterNames.hasMoreElements()) {
			String parameterName = (String) parameterNames.nextElement();
			String[] parameterValues = request.getParameterValues(parameterName);
			out.println(" <tr>");
			out.println("<td scope=\"row\">" + parameterName + "</td>");
			out.println("<td scope=\"row\">");
			for(int i  = 0; i < parameterValues.length; i++) {
				String values = parameterValues[i];
				out.println("<span class= \"badge badge-pill badge-primary\">" + values + "</span>");
			}
			
			out.println("</td>");
			out.println(" </tr>");

		}


		out.println("</tbody>");
		out.println("</table>");

		out.println("<table class=\"table table-border table-stripped table-hover\">");
		out.println(" <thead>");
		out.println(" <tr>");
		out.println(" <th scope=\"col\">Header Names</th>");
		out.println("<th scope=\"col\">Header Values</th>");
		out.println(" </tr>");
		out.println("</thead>");

		out.println(" <tbody>");
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			out.println(" <tr>");
			out.println(" <td scope=\"row\">" + headerName + "</td>");
			out.println(" <td scope=\"row\"> <span class= \"badge badge-pill badge-primary\">" + request.getHeader(headerName) + "</span> </td>");

			out.println(" </tr>");

		}


		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
