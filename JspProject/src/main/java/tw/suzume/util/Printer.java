package tw.suzume.util;import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletResponse;

public class Printer {

	private PrintWriter out;
	public Printer(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		this.out = response.getWriter();
	}

	public void write(String str){
		out.write(str);
	}
	public void close() {
		out.close();
	}
}
