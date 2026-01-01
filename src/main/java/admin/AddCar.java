package admin;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assets.Car;
import util.JPAUtil;

@WebServlet("/addcar")
public class AddCar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        EntityManager entityManager = JPAUtil.getEMF().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            String cname = req.getParameter("name");
            String cmodel = req.getParameter("model");
            double cprice = Double.parseDouble(req.getParameter("price"));
            String cnumber = req.getParameter("number");
            String cowner = req.getParameter("owner");
            String cfuel = req.getParameter("fuel");

            Car car = new Car(cname, cmodel, cprice, cnumber, cowner, cfuel);

            transaction.begin();
            entityManager.persist(car);
            transaction.commit();

            // ✅ PRG pattern
            resp.sendRedirect("CarAdded.html");

        } catch (Exception e) {

            if (transaction.isActive()) {
                transaction.rollback(); // ✅ VERY IMPORTANT
            }

            throw new ServletException(e);

        } finally {
            entityManager.close(); // ✅ VERY IMPORTANT
        }
    }
}
