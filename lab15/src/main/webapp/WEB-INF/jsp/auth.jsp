<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
<form action="hello" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="username"/></td>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"/></td>
        <tr>
            <td></td>
            <td><input type="submit" value="login"/></td>
        </tr>
    </table>
</form>
</body>
</html>
