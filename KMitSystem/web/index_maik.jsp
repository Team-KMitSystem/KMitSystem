<%-- 
    Document   : index
    Created on : 07.11.2013, 18:38:37
    Author     : Maik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% String text = String.valueOf(request.getSession().getAttribute("text")); %>
        
    </head>
    <body>
        <h1>Hello World!</h1>
        sdfsfrasgsdgsdgsdgsdgsdgadg
        <form action="CreateTeamServlet" method="post">
            <input type="text" name="text" required>
            <input type="submit" name="submit">
        </form>
        <% out.print(text.equals("") ? "" : (text + " " + text.length())); %>
    </body>
</html>