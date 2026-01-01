package customer;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assets.Booking;
import assets.Car;
import util.JPAUtil;

@WebServlet("/bookcar")
public class BookCar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        EntityManager entityManager = JPAUtil.getEMF().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String cname = req.getParameter("username");
            long cphone = Long.parseLong(req.getParameter("contactno"));
            String fromDate = req.getParameter("from");
            String toDate = req.getParameter("to");

            transaction.begin();

            Car car = entityManager.find(Car.class, id);

            if (car == null || !"avilable".equals(car.getStatus())) {
                transaction.rollback();
                resp.sendError(HttpServletResponse.SC_CONFLICT,
                        "Car is not available");
                return;
            }

            car.setStatus("booked");
            entityManager.merge(car);

            Booking booking =
                    new Booking(id, cname, cphone, fromDate, toDate);
            entityManager.persist(booking);

            transaction.commit();

            req.setAttribute("bookingData", booking);
            req.setAttribute("car", car);

            RequestDispatcher rd =
                    req.getRequestDispatcher("BookingCarData.jsp");
            rd.forward(req, resp);

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
