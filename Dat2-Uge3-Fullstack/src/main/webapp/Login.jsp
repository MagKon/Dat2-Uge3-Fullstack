<%--
  Created by IntelliJ IDEA.
  User: magnu
  Date: 13/03/2023
  Time: 10.38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Login</title>
</head>
<header>
  <jsp:include page="MasterHeader.jsp"/>
</header>
<body>
<div class="container-fluid">
<%--  Create login form with bootstrap--%>
  <div class="row">
    <label>${requestScope.message}</label>
    <form action="ServletLogin" method="get">
      <label for="name">Name</label> <br>
      <input type="text" name="name" id="name" placeholder="John"> <br>
      <label for="password">Password</label> <br>
      <input type="password" name="password" id="password" placeholder="password"> <br> <br>
      <input type="submit" value="Login">
    </form>
  </div>
</div>
</body>
<footer>
  <jsp:include page="MasterFooter.jsp"/>
</footer>
</html>
