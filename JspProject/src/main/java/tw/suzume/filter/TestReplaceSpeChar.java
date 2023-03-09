package tw.suzume.filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.suzume.util.Printer;

import java.io.IOException;
import java.io.PrintWriter;
//import tw.suzume.util.DAO;

public class TestReplaceSpeChar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Printer out = new Printer(response);
		String userName = replaceSpeChar(request.getParameter("userName"));
		out.write(userName);
		out.close();
		
		
	}

	private String replaceSpeChar(String str) {
		str = str.replaceAll("<", "&lt");
		str = str.replaceAll(">", "&gt");
		return str;
	}

}