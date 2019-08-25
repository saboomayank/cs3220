package photoAlbum;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Album;
import models.Photo;

/**
 * Servlet implementation class ViewAlbum
 */
@WebServlet("/photos/ViewAlbum")
public class ViewAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get album ID to which to upload file to
		int albumID = Integer.parseInt(request.getParameter("albumID"));

		// Get a reference to the album
		ArrayList<Album> photoAlbum = (ArrayList<Album>) getServletContext().getAttribute("photoAlbum");


		Album a = null;
		for(Album entry: photoAlbum) {
			if (entry.getAlbumID() == albumID) {
				a=entry;
				break;
			}
		}

		// Set the response headers. File.length() returns the size of the file
		// as a long, which we need to convert to a String.
//		response.setContentType( "image/jpg" );

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");

		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <title>View Album</title>");
		out.println("     <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		out.println("<h1>Album name: " + a.getAlbumName() + " </h1>");
		out.println("<h6>descrition: " + a.getDescription() + " </h6>");

		for(Photo entry: a.getPhotoAlbum()) {
			// Get the path to the file and create a java.io.File object
			System.out.println(entry.getAdress());
			String path = entry.getAdress();
//			File file = new File( path );

			out.println("<img src=" + path + ">" );
//			response.setHeader( "Content-Length", "" + file.length() );
//			response.setHeader( "Content-Disposition",
//					"inline; filename=FlockOf.jpg" );
//			// Binary files need to read/written in bytes.
//			out.println("<img src='"+path+"' />");
//			FileInputStream in = new FileInputStream( file );
//			OutputStream out1 = response.getOutputStream();
//			byte buffer[] = new byte[2048];
//			int bytesRead;
//			while( (bytesRead = in.read( buffer )) > 0 )
//				out1.write( buffer, 0, bytesRead );
//			in.close();

		}
		out.println("</div>");
		out.println("</body>");        
		out.println("</html>");




	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
