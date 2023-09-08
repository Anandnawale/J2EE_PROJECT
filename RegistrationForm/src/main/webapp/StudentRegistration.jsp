<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>
</head>
<body>

 <%
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String address = request.getParameter("address");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/weja2", "root", "root");

            String sql = "INSERT INTO studentReg (name, email, contact, address) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, contact);
            preparedStatement.setString(4, address);

            int rowsInserted = preparedStatement.executeUpdate();
        
            if (rowsInserted > 0) {
                out.println("<h2>Registration Successful</h2>");
            } else {
                out.println("<h2>Registration Failed</h2>");
            }

            connection.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

</body>
</html>