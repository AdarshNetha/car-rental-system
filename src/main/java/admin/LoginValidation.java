package admin;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import assets.Login;
import util.JPAUtil;

@WebServlet("/login")
public class LoginValidation extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        EntityManager entityManager = JPAUtil.getEMF().createEntityManager();

        try {
            long user = Long.parseLong(req.getParameter("username"));
            String password = req.getParameter("password");

            Login login = entityManager.find(Login.class, user);

            if (login != null && password.equals(login.getPassword())) {

                HttpSession session = req.getSession(true);
                session.setAttribute("admin", user); // ✅ MATCHES Profile servlet

                // ✅ PRG pattern
                resp.sendRedirect("admin.html");

            } else {
                resp.sendRedirect("invalidLogin.html");
            }

        } catch (Exception e) {
            throw new ServletException(e);

        } finally {
            entityManager.close(); // ✅ VERY IMPORTANT
        }
    }
}
