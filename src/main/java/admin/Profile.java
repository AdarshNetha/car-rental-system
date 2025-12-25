package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/profile")
public class Profile extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession=req.getSession(false);
		if(httpSession!=null)
		{
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("admin.html");
			requestDispatcher.forward(req, resp);
		}
		else
		{
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("Login.html");
			requestDispatcher.forward(req, resp);
		}
	}
	

}
