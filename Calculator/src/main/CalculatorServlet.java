import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String expression = request.getParameter("expression");
        try {
            double result = evaluateExpression(expression);
            response.getWriter().write(Double.toString(result));
        } catch (Exception e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }

    private double evaluateExpression(String expression) throws Exception {
        return Calculator.evaluate(expression);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String expression = request.getParameter("expression");
        try {
            double result = evaluateExpression(expression);
            response.setContentType("text/plain");
            response.getWriter().write(Double.toString(result));
        } catch (Exception e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}
