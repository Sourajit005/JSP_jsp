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

@WebServlet("/update")
public class Update extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userInSession = (String) session.getAttribute("user");

        // Get data from the form
        String formName = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        int id = Integer.parseInt(req.getParameter("id"));

        // Basic Security Check: Is the user updating their own record?
        if (userInSession != null && userInSession.equals(formName)) {
            Employee emp = new Employee();
            emp.setId(id);
            emp.setName(formName);
            emp.setAge(age);

            EmployeeService service = new EmployeeService();
            // You will need to create an 'update' method in EmployeeService
            int result = service.update(emp);

            if (result > 0) {
                resp.getWriter().print("<h1>Profile Updated Successfully!</h1>");
                resp.sendRedirect("home.jsp");
            }else{
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
                requestDispatcher.forward(req, resp);
            }
        } else {
            resp.sendRedirect("login.jsp");
        }
    }
}