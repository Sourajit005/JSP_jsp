<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<% String name = request.getParameter("name"); %>
<h1>WELCOME</h1>
<form action="login" method="get">
  USERNAME: <input type="text" name="user">
  PASSWORD: <input type="text" name="pswd">
  <input type="submit" value="LOGIN">
</form>
</body>
</html>