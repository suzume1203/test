package tw.suzume.upload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collection;


public class TestUploadEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		singleUpload(request, response);
		multiUpload(request, response);
		
	}

	private void multiUpload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;utf-8");
		PrintWriter out = response.getWriter();
		
		File file = new File("c:/temp/test");
		if (!file.exists()) {
			file.mkdirs();
		}
		
		
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			String fileName = part.getSubmittedFileName();
			if(!"".equals(fileName)&&part.getContentType()!=null) {
				out.write(fileName+"<br/>");
				part.write(fileName);
			}
			
		}
		out.write("Mutiple File Uploaded Successfully<br/>");
		

		out.close();
		
	}

	private void singleUpload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;utf-8");
		PrintWriter out = response.getWriter();
		
		File file = new File("c:/temp/test");
		if (!file.exists()) {
			file.mkdirs();
		}
		
		
		Part part = request.getPart("multimedia");
		String fileName = part.getSubmittedFileName();
		if(!fileName.equals("")&&part.getContentType()!=null) {
			part.write(fileName);
			out.write("Single File Uploaded Successfully<br/>");
		}
		

		out.close();
	}

}
