package lab6;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GameBean;

@WebServlet("/PlayerController")
public class PlayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GameBean ticTac = (GameBean) request.getSession().getAttribute("ticTac");
		int loc = Integer.parseInt(request.getParameter("loc"));
		if(ticTac.isValid(loc)) {
			ticTac.setMove(loc);
			ticTac.setPlayer();
			ticTac.setPlayerTurn();
		}
		
		response.sendRedirect("GameController");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
