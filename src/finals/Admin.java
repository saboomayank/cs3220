package finals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/final/admin"}, loadOnStartup=1)
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<quoteBook> entries = new ArrayList<quoteBook>();
		Connection c = null;
		try {
			String url ="jdbc:mysql://cs3.calstatela.edu/cs3220stu79";
			String user = "cs3220stu79";
			String password = "k!w*O*Qv";
			c = DriverManager.getConnection(url, user, password);
			Statement stmt = c.createStatement();

			ResultSet r = stmt.executeQuery("SELECT * FROM quotedb");
			ArrayList<quoteBook> quoteBookEntries = new ArrayList<quoteBook>();

			while(r.next()) {
				int id = r.getInt("id");
				String quote = r.getString("quote");
				String author = r.getString("author");
				quoteBookEntries.add(new quoteBook(id, quote, author));
			}

			request.setAttribute("quoteBookEntries", quoteBookEntries);
		}
		catch(SQLException e) {
			throw new ServletException(e);
		}
		finally {
			try {
				if(c!=null) {
					c.close();
				}
			}
			catch(SQLException e) {
				throw new ServletException(e);
			}
		}
		request.getRequestDispatcher("/WEB-INF/finals/adminView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
