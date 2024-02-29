package by.tms.lesson25.calculator;

import by.tms.lesson25.calculator.model.Operation;
import by.tms.lesson25.calculator.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       double num1 = Double.parseDouble(req.getParameter("num1"));
       double num2 = Double.parseDouble(req.getParameter("num2"));
       String type = req.getParameter("type");

       Operation operation = new Operation(num1, num2, type);
       OperationService.calculate(operation);
       double result = operation.getResult();

       resp.getWriter().println("Result = " + result);
    }
}
