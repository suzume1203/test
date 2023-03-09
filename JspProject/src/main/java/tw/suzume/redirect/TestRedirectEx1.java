package tw.suzume.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class TestRedirectEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int countDown = 3;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRedirect(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRedirect(request, response);
	}


	private void processRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setHeader("Refresh", countDown+";URL=home.html");

		if(countDown>0) {
			out.write("Wait for "+ countDown +" sec");		
		}
		out.close();
	}

}
