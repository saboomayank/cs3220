package lab6;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GameBean;


@WebServlet(urlPatterns="/GameController", loadOnStartup=1)
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GameBean gb = new GameBean();
		
		if(request.getSession().getAttribute("ticTac") == null) {
			request.getSession().setAttribute("ticTac", gb);
		}
		request.getRequestDispatcher("WEB-INF/mvc/GameView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
