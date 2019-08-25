package photoAlbum;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Album;

@WebServlet(name = "albums", urlPatterns = { "/photos/albums" }, loadOnStartup=1)

public class PhotoAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ArrayList<Album> photoAlbum = new ArrayList<Album>();
		// Add the array list to the application scope (Servlet Context)
		getServletContext().setAttribute("photoAlbum", photoAlbum);

	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get the array list of guest book entries from the application scope
		ArrayList<Album> photoAlbum = (ArrayList<Album>) getServletContext().getAttribute("photoAlbum");
		// Set the content type to HTML
		response.setContentType("text/html");

		// Get a reference to the output stream
		PrintWriter out = response.getWriter();

		// Generate our HTML
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("	 <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("	 <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("    <title>Photo Album</title>");
		out.println("</head>");
		// Page-Specific Content Goes Here...
		out.println("<body>");
		out.println("<header>");
		out.println("	<div class=\"navbar navbar-dark bg-dark shadow-sm\">");
		out.println(" 		<div class=\"container d-flex justify-content-between\">");
		out.println("			<strong> <a href=\"http://cs3.calstatela.edu:8080/cs3220stu79/photos/albums\"> Album </a> </strong>");
		out.println("		</div>");
		out.println("	</div>");
		out.println("</header>");
		out.println("<div class=\"container\">");
		out.println("	<h1 class=\"jumbotron-heading\">Album</h1>");
		out.println(" 	<p class=\"lead text-muted\">"
					+ "It's a pleasure to share one's memories. Everything remembered is dear, endearing, touching, precious. "
					+ "At least the past is safe --though we didn't know it at the time. We know it now. "
					+ "Because it's in the past; because we have survived. "
					+ 	"</p>");
		
		out.println("	<a class=\"btn btn-outline-primary\" href=\"AddAlbum\">Add album</a>");
		out.println("</div>");
		
		// Iterate over all album entries, and display one row per entry in card

		for(Album album: photoAlbum ) {

			out.println("<div class=\"album py-5 bg-light\">");
			out.println("	<div class=\"container\">");
			out.println("		<div class=\"row\">");
			out.println("			<div class=\"col-md-4\">");
			out.println("				<div class=\"card mb-4 shadow-sm\">");
			out.println("					<div class=\"card-body\">");
			out.println(" 						<p class=\"card-text\"> <strong>" + album.getAlbumName() + "</strong></p>");
			out.println(" 						<p class=\"card-text\">" + album.getDescription() + "</p>");
			out.println(" 						<p align=\"right\" class=\"card-text\">" + album.getPhotoct() + "</p>");
			out.println("      					<a class=\"btn btn-outline-dark btn-sm\" href=\"ViewAlbum?albumID=" + album.getAlbumID() + "\">View album</a>");
			out.println("      					<a class=\"btn btn-outline-dark btn-sm\" href=\"DeleteAlbum?albumID=" + album.getAlbumID() + "\">Delete album</a>");
			out.println("      					<a class=\"btn btn-outline-dark btn-sm\" href=\"Upload\"> Uplaod Photo</a>");
			out.println("					</div>");
			out.println("				</div>");
			out.println("			</div>");
			out.println("		</div>");
			out.println("	</div>");
			out.println("</div>");


			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
