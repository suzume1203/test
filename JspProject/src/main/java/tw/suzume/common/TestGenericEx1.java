package tw.suzume.common;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
		name="TestGenericEx1",
		urlPatterns="/TestGenericEx1.do")
public class TestGenericEx1 extends GenericServlet {
	private static final long serialVersionUID = 1L;


	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("Hello <br/> From the other side");
		
		out.close();
	}

}
