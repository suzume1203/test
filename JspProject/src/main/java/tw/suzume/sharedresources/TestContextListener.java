package tw.suzume.sharedresources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class TestContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("Server Shutdown");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("Server Initialized");
		ServletContext context = event.getServletContext();
		String resourceFile = context.getInitParameter("resourceFile");
		System.out.println("resourceFile: " + resourceFile);

//		InputStream is = context.getResourceAsStream(resourceFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(context.getResourceAsStream(resourceFile)));
		String data;
		try {
			while ((data = br.readLine()) != null) {
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
