package admin;

import java.io.IOException;
import java.lang.module.ModuleDescriptor.Requires;
import java.util.List;

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

import assets.Car;

@WebServlet("/seeallcars")
public class SeeAllCars extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("cars");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		String query="Select c from Car c";
		List<Car> allcars= entityManager.createQuery(query).getResultList();
		entityTransaction.commit();
		
		req.setAttribute("carlist", allcars);
		
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("seeallcars.jsp");
		requestDispatcher.forward(req, resp);
		}

}
