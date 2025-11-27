package admin;

import java.io.IOException;
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

import assets.Booking;
@WebServlet("/seeallbookedcars")
public class SeeAllBookedCars extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("cars");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		String query="Select b from Booking b";
		List<Booking> bookinglist =entityManager.createQuery(query).getResultList();
		
		req.setAttribute("bookinglist", bookinglist);
		
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("SeeAllBookedCars.jsp");
		requestDispatcher.forward(req, resp);
	}
	

}
