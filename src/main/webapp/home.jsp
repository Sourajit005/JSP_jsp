<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>
<h1>WELCOME, <%= session.getAttribute("user") %></h1>
    <br>

    <form action="profile" method="get">
        <input type="submit" value="VIEW PROFILE">
    </form>
    <br>

    <form action="update.jsp" method="get">
        <input type="submit" value="UPDATE PROFILE">
    </form>
    <br>

    <form action="delete" method="post">
        <input type="hidden" name="id" value="${sessionId}"> <input type="submit" value="DELETE ACCOUNT" onclick="return confirm('Are you sure?')">
    </form>
    <br>

    <form action="logout" method="post">
        <input type="submit" value="LOGOUT">
    </form>

</body>
</html>