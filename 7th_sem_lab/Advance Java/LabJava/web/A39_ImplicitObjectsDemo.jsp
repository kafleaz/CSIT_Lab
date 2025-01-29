<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Implicit Objects Demo</title>
</head>
<body>
    <h2>Implicit Objects Demonstration</h2>
    <% 
        // Using request object to get client information
        String clientIP = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");

        // Using session object to store a value
        session.setAttribute("username", "JohnDoe");

        // Using response object to set content type
        response.setContentType("text/html");
    %>

    <h3>Using Request Object</h3>
    <p>Client IP Address: <%= clientIP %></p>
    <p>User-Agent: <%= userAgent %></p>

    <h3>Using Session Object</h3>
    <p>Stored Session Attribute (username): <%= session.getAttribute("username") %></p>

    <h3>Using Response Object</h3>
    <p>The content type for this page is set to: <%= response.getContentType() %></p>
</body>
</html>
