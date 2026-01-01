package admin;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assets.Booking;
import assets.Car;
import util.JPAUtil;

@WebServlet("/delete-booking")
public class DeleteBooking extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        EntityManager entityManager = JPAUtil.getEMF().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            int cid = Integer.parseInt(req.getParameter("cid"));
            int bid = Integer.parseInt(req.getParameter("bid"));

            transaction.begin();

            Car car = entityManager.find(Car.class, cid);
            Booking booking = entityManager.find(Booking.class, bid);

            if (car != null) {
                car.setStatus("avilable");
                entityManager.merge(car);
            }

            if (booking != null) {
                entityManager.remove(booking);
            }

            transaction.commit();

            // ✅ PRG pattern
            resp.sendRedirect("Returned.html");

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
