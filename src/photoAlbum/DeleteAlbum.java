package photoAlbum;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Album;
import models.GuestBookEntry;

/**
 * Servlet implementation class DeleteAlbum
 */
@WebServlet("/photos/DeleteAlbum")
public class DeleteAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("ALBUM ID: " + request.getParameter("albumID"));

		int albumID = Integer.parseInt(request.getParameter("albumID"));
		
		// Get a reference to the album
		ArrayList<Album> photoAlbum = (ArrayList<Album>) getServletContext().getAttribute("photoAlbum");
//		System.out.println("PHOTO ALBUM " + photoAlbum);
		for(Album album: photoAlbum) {
			if(album!=null) {
				if(album.getAlbumID() == albumID) {
					photoAlbum.remove(album);
					break;
				}
			}
		}
		
		response.sendRedirect("albums");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
