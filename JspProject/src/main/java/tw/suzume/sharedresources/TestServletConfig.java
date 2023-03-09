package tw.suzume.sharedresources;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = { "/myInitialSet.play" }, initParams = {
		@WebInitParam(name = "contentType", value = "text/html;charset=UTF-8"),
		@WebInitParam(name = "bgColor", value = "green") })
public class TestServletConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String contentType;
	private String bgColor;

	@Override
	public void init() throws ServletException {
		contentType = getInitParameter("contentType");
		bgColor = getInitParameter("bgColor");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);

	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType(contentType);
		PrintWriter out = response.getWriter();
//		out.write("<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset=\"UTF-8\">" + "<title>initial</title>"
//				+ "</head>" + "<body style='background-color:" + bgColor + "'>" + "My Sweet Home !!" + "</body>\r\n"
//				+ "</html>");
		out.write("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>TestResource</title>\r\n"
				+ "</head>\r\n"
				+ "<body style='background-color:" + bgColor + "'>\r\n"
				+ "<form action=\"myInitialSet.play\" method=\"get\">\r\n"
				+ "	<p>\r\n"
				+ "		<label for=\"name\">Name:</label>\r\n"
				+ "		<input type=\"text\" id=\"name\" name=\"name\" value=\"suzume\"/>\r\n"
				+ "		<label for=\"age\">Age:</label>\r\n"
				+ "		<input type=\"text\" id=\"age\" name=\"age\" value=\"18\"/>\r\n"
				+ "	</p>\r\n"
				+ "	<button type=\"submit\" value=\"submit\">Submit</button>\r\n"
				+ "</form>\r\n"
				+ "</body>\r\n"
				+ "</html>");

		out.close();
	}

}
