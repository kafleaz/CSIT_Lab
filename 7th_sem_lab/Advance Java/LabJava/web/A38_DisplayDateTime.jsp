<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Display Current Date and Time</title>
</head>
<body>
<h2>Current Date and Time</h2>
<%
  // Declaration: Define a java.util.Date object to get the current date and time
  java.util.Date currentDate = new java.util.Date();
%>
<p>
  <!-- Expression: Display the current date and time -->
  Current Date and Time: <%= currentDate %>
</p>
</body>
</html>
