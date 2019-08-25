package lab4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/lab4/Members" })
public class Members extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set the content type to HTML
		response.setContentType("text/html");

		// Get a reference to the output stream
		PrintWriter out = response.getWriter();
		Cookie cookie = null;
		Cookie cookies[] = request.getCookies();

		if(cookies!= null) {
			for(int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if(cookie.getName().equals("email")){
					out.println("<h3 class=\"text-info, font-italic\">" + cookie.getValue() + "</h3>");
					request.getRequestDispatcher("Members.html").include(request, response);
					return;
				}

				else {
					request.getRequestDispatcher("login.html").include(request, response);
				}
			}
		}

		else {
			request.getRequestDispatcher("login.html").include(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
