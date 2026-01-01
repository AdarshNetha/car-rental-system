package admin;

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

@WebServlet("/seeallcars")
public class SeeAllCars extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        EntityManager entityManager = JPAUtil.getEMF().createEntityManager();

        try {
            String query = "SELECT c FROM Car c";
            List<Car> allCars =
                    entityManager.createQuery(query, Car.class).getResultList();

            req.setAttribute("carlist", allCars);

            RequestDispatcher rd =
                    req.getRequestDispatcher("seeallcars.jsp");
            rd.forward(req, resp);

        } finally {
            entityManager.close(); // ✅ VERY IMPORTANT
        }
    }
}
