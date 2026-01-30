import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.EmployeeService;

import java.io.IOException;

@WebServlet("/delete")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = (String)session.getAttribute("user");

        EmployeeService service = new EmployeeService();

        if(user != null) {
            int res = service.delete(user);
            if (res != 0) {
                resp.sendRedirect("home.jsp");
            } else {
                resp.getWriter().print("<h1>DATA NOT DELETED</h1>");
            }
        }
        else{
            resp.getWriter().print("<h1>DATA </h1>");
        }
    }
}
