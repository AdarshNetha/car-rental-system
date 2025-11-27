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

import assets.Car;
@WebServlet("/addcar")
public class AddCar extends HttpServlet{
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("cars");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cname=req.getParameter("name");
		String cmodel=req.getParameter("model");
		double cprice=Double.parseDouble(req.getParameter("price"));
		String cnumber=req.getParameter("number");
		String cowner=req.getParameter("owner");
		String cfuel=req.getParameter("fuel");
		
		Car c=new Car(cname, cmodel, cprice, cnumber, cowner, cfuel);
		
		entityTransaction.begin();
		entityManager.persist(c);
		entityTransaction.commit();
		
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("added succesful");
		
		
	}
}
