package admin;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import assets.Login;

@WebServlet("/login")
public class LoginValidation extends HttpServlet{
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("cars");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long userr=Long.parseLong( req.getParameter("username"));
		String password=req.getParameter("password");
		
		Login login=entityManager.find(Login.class, userr);
		
		if(login!= null)
		{
			if(userr==login.getMobileNo() && password.equals( login.getPassword()))
			{
				HttpSession httpSession=req.getSession();
				httpSession.setAttribute("passkey",userr);
				
				RequestDispatcher dispatcher=req.getRequestDispatcher("admin.html");
				dispatcher.forward(req, resp);
				
			}
			else
			{
				RequestDispatcher dispatcher=req.getRequestDispatcher("invalidLogin.html");
				dispatcher.forward(req, resp);
			}
		}
		else
		{
			RequestDispatcher dispatcher=req.getRequestDispatcher("invalidLogin.html");
			dispatcher.forward(req, resp);
		}
		
	}

}
