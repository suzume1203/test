package tw.suzume.rd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestResourceInclude extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRDInclude(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRDInclude(request, response);
	}


	private void processRDInclude(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/hyml;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("code : "+request.getAttribute("code")+"<br/>");
		out.write("reply : "+request.getAttribute("reply")+"<br/>");
		out.write("userName : "+request.getParameter("name")+"<br/>");
		out.write("userAge : "+request.getParameter("address")+"<br/>");
		out.close();
		
	}

}
