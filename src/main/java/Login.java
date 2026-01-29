import entity.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.EmployeeService;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String user = req.getParameter("user");
        EmployeeService service = new EmployeeService();

        if(service.isUserValid(user)) {
            HttpSession session = req.getSession(true); // 'true' ensures a session is created
            session.setAttribute("user", user);

            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } else {
            resp.setContentType("text/html");
            resp.getWriter().print("<h1>Invalid Username. Please try again.</h1>");
        }
    }
}