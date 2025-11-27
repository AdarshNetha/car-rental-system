package customer;

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
@WebServlet("/bookcar")
public class BookCar extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("cars");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		int id=Integer.parseInt(req.getParameter("id"));
		String cname=req.getParameter("username");
		long cphone=Long.parseLong(req.getParameter("contactno"));
		String fromDate=req.getParameter("from");
		String toDate=req.getParameter("to");
		
		entityTransaction.begin();
		
		Car c =entityManager.find(Car.class,id);
		if(c!=null)
		{
			c.setStatus("booked");
		}
		entityManager.merge(c);
		
		Booking booking= new Booking(id, cname, cphone, fromDate, toDate);
		
		entityManager.persist(booking);
		
		entityTransaction.commit();
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("booked succesful");
		
	}

}
