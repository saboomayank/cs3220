package lab4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "login", urlPatterns = { "/lab4/login" }, loadOnStartup=1)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean loginError = false; 

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
					request.setAttribute("email", cookie.getValue());
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if(email.equals("acervan5@calstatela.edu") && password.equals("abcd")) {
			Cookie cookie = new Cookie("email", email);
			response.addCookie(cookie);
			response.sendRedirect("./Members");
			return;

		}
		else {
			loginError = true;
			out.println("<div class=\"form-group\">\n" + "<p class=\"leads, text-danger\">Email and Password do not match.</p>\n" + "</div>");
			request.getRequestDispatcher("login.html").include(request, response);
		}

		out.close();

	}

}
