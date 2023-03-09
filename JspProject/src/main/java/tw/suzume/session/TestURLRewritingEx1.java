package tw.suzume.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tw.suzume.util.Printer;

import java.io.IOException;

public class TestURLRewritingEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();

		if(session.getAttribute("number")==null) {
			session.setAttribute("number", 0);
		}
		
		session.setAttribute("number", (Integer)session.getAttribute("number")+1);
		Printer out = new Printer(response);
		out.write(session.getAttribute("number").toString());
		out.close();
		
	}

}
