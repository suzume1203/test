package tw.suzume.rd;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TestResourceDispatcherEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processDispatcherInclude(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processDispatcherInclude(request, response);
	}

	private void processDispatcherInclude(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("code", "thunder");
		request.setAttribute("reply", "flash");
		rd=request.getRequestDispatcher("TestResourceInclude.do");
		rd.include(request, response);
	}
}
