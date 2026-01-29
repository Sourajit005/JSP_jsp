import entity.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.EmployeeService;

import java.io.IOException;


@WebServlet("/register") //post
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setAge(age);

        EmployeeService service = new EmployeeService();
        int res = service.save(employee);

        if(res != 0){
            RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.forward(req, resp);
        }else{
            resp.getWriter().print("<h1>DATA NOT SAVED</h1>");
        }
    }
}
