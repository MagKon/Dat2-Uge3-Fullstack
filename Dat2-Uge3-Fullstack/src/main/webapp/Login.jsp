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

<jsp:include page="MasterHeader.jsp"/>

<body>
<div class="container-fluid">
<%--  Create login form with bootstrap--%>
  <div class="row">
    <div class="row text-left form-row">
      <div class="col-sm-4"></div>
      <div class="col-sm-3" style="font-size: 21px;">
        <h2>Log-in</h2>
        <div class="border border-dark rounded">
          <label>${requestScope.message}</label>
          <form action="ServletLogin" method="get" class="form-group m-2">
            <label for="name">Name</label> <br>
            <input type="text" name="name" id="name" placeholder="John" class="form-control" required> <br>
            <label for="password">Password</label> <br>
            <input type="password" name="password" id="password" placeholder="password" class="form-control" required> <br>
            <input type="submit" value="Login">
          </form>
        </div>
      </div>
      <div class="col-sm-4"></div>
    </div>
    <br>
    <div class="row text-left form-row mt-4">
      <div class="col-sm-4"></div>
      <div class="col-sm-3" style="font-size: 21px;">
        <h2>Create new user</h2>
        <div class="border border-dark rounded">
          <label>${requestScope.message2}</label>
          <form action="ServletCreateUser" method="get" class="form-group m-2">
            <label for="newname">Name</label> <br>
            <input type="text" name="newname" id="newname" placeholder="John" class="form-control" required> <br>
            <label for="newpassword">Password</label> <br>
            <input type="password" name="newpassword" id="newpassword" placeholder="password" class="form-control" required> <br>
            <input type="submit" value="Create">
          </form>
        </div>
      </div>
      <div class="col-sm-4"></div>
    </div>
  </div>
</div>
</body>

<jsp:include page="MasterFooter.jsp"/>

</html>
