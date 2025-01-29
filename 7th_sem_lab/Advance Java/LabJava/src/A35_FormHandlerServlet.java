// Task 35: Single servlet that serves the form and processes the form submission.

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formHandler")
public class A35_FormHandlerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Serve the HTML form
        response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html lang='en'>");
        response.getWriter().println("<head><title>Form Submission</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Submit Your Details</h1>");
        response.getWriter().println("<form action='formHandler' method='post'>");
        response.getWriter().println("<label for='name'>Name:</label>");
        response.getWriter().println("<input type='text' id='name' name='name' required>");
        response.getWriter().println("<br><br>");
        response.getWriter().println("<label for='email'>Email:</label>");
        response.getWriter().println("<input type='email' id='email' name='email' required>");
        response.getWriter().println("<br><br>");
        response.getWriter().println("<button type='submit'>Submit</button>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Process the form submission
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Display the submitted data
        response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html lang='en'>");
        response.getWriter().println("<head><title>Form Submission</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Form Submission</h1>");
        response.getWriter().println("<p>Name: " + name + "</p>");
        response.getWriter().println("<p>Email: " + email + "</p>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
