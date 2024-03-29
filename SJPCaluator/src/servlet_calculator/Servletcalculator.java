package servlet_calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet-calculator",urlPatterns = "/calculator")
public class Servletcalculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     float firstOperator=Float.parseFloat(request.getParameter("first-operand"));
     float secondOperator=Float.parseFloat(request.getParameter("second-operand"));
     char operator=request.getParameter("operator").charAt(0);
        PrintWriter writer=response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result:</h1>");
        try {
            float result=calculator.calculate(firstOperator,secondOperator,operator);
            writer.println(firstOperator+" "+operator+" "+secondOperator+" = "+result);
        }catch (Exception ex){
            writer.println("Error: "+ex.getMessage());
        }
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
