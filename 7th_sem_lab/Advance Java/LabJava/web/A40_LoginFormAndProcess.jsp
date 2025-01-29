<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form and Processing</title>
</head>
<body>
    <%
        // Check if the request is POST (when the form is submitted)
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            // Retrieve form data
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // Simple hardcoded validation (In real applications, validate against a database)
            if ("admin".equals(username) && "password123".equals(password)) {
    %>
                <h2>Welcome, <%= username %>!</h2>
                <p>Login Successful.</p>
    <%
            } else {
    %>
                <h2>Login Failed</h2>
                <p>Invalid username or password. Please try again.</p>
                <form action="A40_LoginFormAndProcess.jsp" method="POST">
                    <button type="submit">Go Back to Login</button>
                </form>
    <%
            }
        } else {
    %>
        <h2>Login Form</h2>
        <form action="A40_LoginFormAndProcess.jsp" method="POST">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br><br>
            <button type="submit">Login</button>
        </form>
    <%
        }
    %>
</body>
</html>
