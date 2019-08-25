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

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/final/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
		try {
			String url ="jdbc:mysql://cs3.calstatela.edu/cs3220stu79";
			String user = "cs3220stu79";
			String password = 	/**/																																"k!w*O*Qv";
			c = DriverManager.getConnection(url, user, password);
			Statement stmt = c.createStatement();
			int id = Integer.parseInt(request.getParameter("id"));
			String query = "DELETE FROM quotedb WHERE id = " + id;
			PreparedStatement pstmt = c.prepareStatement(query);
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			throw new ServletException(e);
		}
		finally {
			try {
				if(c!= null) {
					c.close();
				}
			}catch(SQLException e) {
				throw new ServletException(e);
			}
		}
		response.sendRedirect("admin");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
