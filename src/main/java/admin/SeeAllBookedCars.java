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

import assets.Booking;
import util.JPAUtil;

@WebServlet("/seeallbookedcars")
public class SeeAllBookedCars extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        EntityManager entityManager = JPAUtil.getEMF().createEntityManager();

        try {
            String query = "SELECT b FROM Booking b";
            List<Booking> bookingList =
                    entityManager.createQuery(query, Booking.class).getResultList();

            req.setAttribute("bookinglist", bookingList);

            RequestDispatcher rd =
                    req.getRequestDispatcher("SeeAllBookedCars.jsp");
            rd.forward(req, resp);

        } finally {
            entityManager.close(); // ✅ VERY IMPORTANT
        }
    }
}
