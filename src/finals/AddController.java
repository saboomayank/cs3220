package finals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/final/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/finals/Addquote.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String author = request.getParameter("author");
		String quote = request.getParameter("quote");

		boolean isValidAuthor = author != null && author.trim().length() > 0;
		boolean isValidQuote = quote != null && quote.trim().length() > 0;

		if (isValidAuthor && isValidQuote) {
			Connection c = null;
			try {
				String url ="jdbc:mysql://cs3.calstatela.edu/cs3220stu79";
				String user = "cs3220stu79";
				String password = "k!w*O*Qv";

				c = DriverManager.getConnection(url, user, password);

				Statement stmt = c.createStatement();
				String query = "INSERT INTO quotedb (id, quote, author) VALUES (NULL, ?, ?)";
				PreparedStatement pstmt = c.prepareStatement(query);
				pstmt.setString(1, quote);
				pstmt.setString(2, author);

				pstmt.executeUpdate();
			}catch (SQLException e) {
				throw new ServletException(e);
			}
			finally {
				try {
					if (c != null) c.close();
				}
				catch(SQLException e) {
					throw new ServletException( e );
				}
			}
			response.sendRedirect("admin");
		}
		else {
			if(!isValidQuote) {
				request.setAttribute("quoteError", "Please enter a quote");
			}
			if(!isValidAuthor) {
				request.setAttribute("authorError", "Please enter the name of the author");
			}
			doGet(request, response);
			return;
		}
	}
}
