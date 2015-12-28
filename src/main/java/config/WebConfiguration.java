package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import myservlet.ServletTest;

public class WebConfiguration implements WebApplicationInitializer{
	public void onStartup(ServletContext arg0) throws ServletException {
		ServletTest st = new ServletTest();	
		ServletRegistration.Dynamic servletTest = 
						arg0.addServlet("servletTest", st);
		servletTest.addMapping("*.test");
		
		AnnotationConfigWebApplicationContext ctx =
				new AnnotationConfigWebApplicationContext();
		ctx.register(SpringMvcConfiguration.class);
		
		DispatcherServlet ds = new DispatcherServlet(ctx);
		ServletRegistration.Dynamic dispatcher =
						arg0.addServlet("dispatcher", ds);
		dispatcher.addMapping("*.spring");
	}
}




