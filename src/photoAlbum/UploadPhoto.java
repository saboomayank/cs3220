package photoAlbum;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import models.Album;

@WebServlet("/photos/Upload")
public class UploadPhoto extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet( HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException{

		// Redirect the user to the upload form
		response.sendRedirect( "../Upload.html" );
	}

	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

		// get album ID to which to upload file to
//		int albumID = Integer.parseInt(request.getParameter("albumID"));

		// Get a reference to the album
		ArrayList<Album> photoAlbum = (ArrayList<Album>) getServletContext().getAttribute("photoAlbum");

		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig()
				.getServletContext();
		File repository = (File) servletContext
				.getAttribute( "javax.servlet.context.tempdir" );
		factory.setRepository( repository );

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload( factory );

		// Count how many files are uploaded
		int count = 0;
		// The directory we want to save the uploaded files to.
		String fileDir = getServletContext().getRealPath( "/WEB-INF/uploads" );

		// Parse the request
		try
		{
			List<FileItem> items = upload.parseRequest( request );
			for( FileItem item : items )
			{
				// If the item is not a form field - meaning it's an uploaded
				// file, we save it to the target dir
				if( !item.isFormField() )
				{
					// item.getName() will return the full path of the uploaded
					// file, e.g. "C:/My Documents/files/test.txt", but we only
					// want the file name part, which is why we first create a
					// File object, then use File.getName() to get the file
					// name.
					String fileName = (new File( item.getName() )).getName();
					File file = new File( fileDir, fileName );
					item.write( file );

					for(Album album: photoAlbum) {
						if(album!=null) {
//							if(album.getAlbumID() == albumID) {
								album.addPhoto(fileName, fileDir + "/" + fileName);
								break;
//							}
						}
					}

					++count;
				}
			}

		}
		catch( Exception e )
		{
			throw new IOException( e );
		}

		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();
		out.println( "<html><head><title>Upload</title></head><body>" );
		out.println( "<p>" + count + " file(s) uploaded to " + fileDir );
		out.println( "</body></html>" );
	}

}