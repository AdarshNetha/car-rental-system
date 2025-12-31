package customer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@WebServlet("/customerservice")
public class CustomerService extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String> props = new HashMap<String, String>();

		props.put("javax.persistence.jdbc.password",
		          System.getenv("DB_PASSWORD"));

		EntityManagerFactory emf =
		    Persistence.createEntityManagerFactory("cars", props);

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("cars");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		String query="Select c from Car c where c.status='avilable'";
		List<Car> availabeCarlist=entityManager.createQuery(query).getResultList();
		
		req.setAttribute("AvailabeCarList", availabeCarlist);
		
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("SeeAllAvailabeCars.jsp");
		requestDispatcher.forward(req, resp);
		}
}
