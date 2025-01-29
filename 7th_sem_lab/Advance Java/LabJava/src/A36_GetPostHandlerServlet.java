// File: A36_GetPostHandlerServlet.java
// Package: servlet_example

package servlet_example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetPostHandler")
public class A36_GetPostHandlerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h3>GET Request Received</h3>");
        response.getWriter().println("<p>Query Parameters:</p>");
        request.getParameterMap().forEach((key, values) -> {
            try {
                response.getWriter().println("<p>" + key + " : " + String.join(", ", values) + "</p>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        response.getWriter().println("</body></html>");
    }

    // Handle POST requests
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h3>POST Request Received</h3>");
        response.getWriter().println("<p>Form Data:</p>");
        request.getParameterMap().forEach((key, values) -> {
            try {
                response.getWriter().println("<p>" + key + " : " + String.join(", ", values) + "</p>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        response.getWriter().println("</body></html>");
    }
}
