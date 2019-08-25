package finals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/final/inspire")
public class Inspire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
		try {
			String url ="jdbc:mysql://cs3.calstatela.edu/cs3220stu79";
			String user = "cs3220stu79";
			String password = 	/**/																																"k!w*O*Qv";
			c = DriverManager.getConnection(url, user, password);
			Statement stmt = c.createStatement();
			ResultSet r = stmt.executeQuery("SELECT * FROM quotedb ORDER BY RAND() LIMIT 1");
			quoteBook quoteEntry = null;
			
			while(r.next()) {
				int id = r.getInt("id");
				String quote = r.getString("quote");
				String author = r.getString("author");
				quoteEntry = new quoteBook(id, quote, author);
			}
			request.setAttribute("quoteEntry", quoteEntry);
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
		
		request.getRequestDispatcher("/WEB-INF/finals/quoteView.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
