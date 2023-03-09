package tw.suzume.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.suzume.util.Printer;

import java.io.IOException;

public class TestCookiesRetrieveEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Cookie[] cookies = request.getCookies();
		Printer out = new Printer(response);
		String info = "";
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				info += "Name : "
						+ cookie.getName()
						+",Value : "
						+ cookie.getValue()
						+ "<br/>"
						+ cookie
						+ "<br/>";
			}
			out.write(info+"Done.");
		}else {
			out.write("You do not have cookies.");
		}
		out.close();
	}

}
