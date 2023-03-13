<%--
  Created by IntelliJ IDEA.
  User: magnu
  Date: 13/03/2023
  Time: 10.38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<head>
  <title>Login</title>
</head>
<header>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Navbar</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
          <a class="nav-link active" aria-current="page" href="WelcomePage.jsp">Home</a>
          <a class="nav-link" href="index.jsp">Features</a>
          <c:choose>
            <c:when test="${sessionScope.loggedIn == true}">
              <a class="nav-link" href="ServletLogout">Logout</a>
            </c:when>
            <c:otherwise>
              <a class="nav-link" href="ServletLogin">Login</a>
            </c:otherwise>
          </c:choose>
          <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
        </div>
      </div>
    </div>
  </nav>
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
</html>