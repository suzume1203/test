package tw.suzume.javabean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.suzume.util.Printer;

import java.io.IOException;

public class TestOperateBean extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {

		TestOrderSystem data1 = new TestOrderSystem("john", "moon", "rabbits", "N/A");
		Printer out = new Printer(response);
		out.write(data1.toString());
		out.close();
	}

}
