package tw.suzume.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tw.suzume.util.Printer;

import java.io.IOException;

public class TestGetSessionEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);

	}


	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String info = "";
		Printer out = new Printer(response);
		if (session.isNew()) {
			info += "Your session was created!<br/>SID : ";
			info += session.getId();
//			session.setMaxInactiveInterval(3);
			session.setAttribute("userName", "Suzume");
		}else {
//			session.invalidate();
			info += "Hi! Dear ";
			info += session.getAttribute("userName");
			info += ".";
		}
		
		out.write(info);
		out.close();
	}

}
