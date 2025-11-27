package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assets.Booking;
import assets.Car;

@WebServlet("/delete-booking")
public class DeleteBooking extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("cars");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		int cid=Integer.parseInt(req.getParameter("cid"));
		int bid=Integer.parseInt(req.getParameter("bid"));
		
		entityTransaction.begin();
		Car c =entityManager.find(Car.class, cid);
		c.setStatus("avilable");
		entityManager.merge(c);
		Booking b=entityManager.find(Booking.class,bid);
		entityManager.remove(b);		
		entityTransaction.commit();
		PrintWriter printWriter=resp.getWriter();
		printWriter.write("succesfully returned and now availabe to book");
	}

}
