package customer;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assets.Car;
import util.JPAUtil;

@WebServlet("/customerservice")
public class CustomerService extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        EntityManager entityManager = JPAUtil.getEMF().createEntityManager();

        try {
            String query = "SELECT c FROM Car c WHERE c.status = 'avilable'";
            List<Car> availableCarList =
                    entityManager.createQuery(query, Car.class).getResultList();

            req.setAttribute("AvailabeCarList", availableCarList);

            RequestDispatcher rd =
                    req.getRequestDispatcher("SeeAllAvailabeCars.jsp");
            rd.forward(req, resp);

        } finally {
            entityManager.close(); // ✅ VERY IMPORTANT
        }
    }
}
