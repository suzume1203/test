package tw.suzume.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.suzume.util.Printer;

import java.io.IOException;


public class TestCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Cookie cookieToClient = new Cookie("name","suzume");
		cookieToClient.setMaxAge(30*24*60*60);
		cookieToClient.setHttpOnly(true);
//		cookieToClient.setVersion(1);
		response.addCookie(cookieToClient);
		Cookie cookieToClient2 = new Cookie("name2","hanako");
		cookieToClient2.setMaxAge(30*24*60*60);
		cookieToClient2.setHttpOnly(true);
//		cookieToClient2.setVersion(1);
		response.addCookie(cookieToClient2);
		Printer out = new Printer(response);
		out.write("done");
		out.close();
	}

}
