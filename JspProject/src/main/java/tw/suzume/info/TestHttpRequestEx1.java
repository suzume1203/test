package tw.suzume.info;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


public class TestHttpRequestEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestURL = request.getRequestURL().toString();
		String serverName = request.getServerName();
		int localPort = request.getLocalPort();
		String contextPath = request.getContextPath();
		String method = request.getMethod();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Enumeration<String> e1 = request.getHeaderNames();
		while (e1.hasMoreElements()) {
			String headerName = e1.nextElement();
			out.write(headerName+" : "+request.getHeader(headerName)+"<br/>");
			
		}
		
		out.write("<hr/>");
		out.write("requestURL : "+requestURL+"<br/>"+
				"serverName : "+serverName+"<br/>"+
				"localPort : "+localPort+"<br/>"+
				"contextPath : "+contextPath+"<br/>"+
				"method : "+method+"<br/>");
		
		
		out.close();
		
	}
}
