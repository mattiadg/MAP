package commerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/ora")
public class ServizioProva extends HttpServlet {


	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		String s=req.getParameter("nome");
		
		
		PrintWriter w = res.getWriter();
		
		w.println("Ciao "+s+" sono le ore :"+new Date());
		w.flush();
		w.close();
	}
	
	
	
	
	
	

}
