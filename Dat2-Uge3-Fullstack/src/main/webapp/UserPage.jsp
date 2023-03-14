<%--
  Created by IntelliJ IDEA.
  User: magnu
  Date: 14/03/2023
  Time: 15.29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Your page</title>
</head>
<header>
    <jsp:include page="MasterHeader.jsp"/>
</header>
<body>
<c:if test="${empty sessionScope.user || sessionScope.loggedIn == false}">
    <c:redirect url="Login.jsp"/>
</c:if>
<div class="container-fluid">
    <h1>Welcome ${sessionScope.user.getName()}</h1>
    <div class="row">
        <div class="row text-left form-row mt-4">
            <div class="col-sm-4"></div>
            <div class="col-sm-3" style="font-size: 21px;">
                <h2>Change username</h2>
                <div class="border border-dark rounded">
                    <label>${requestScope.message}</label>
                    <form action="ServletChangeName" method="get" class="form-group m-2">
                        <label for="newname">Name</label> <br>
                        <input type="text" name="newname" id="newname" placeholder="John" class="form-control" required> <br>
                        <input type="submit" value="Change">
                    </form>
                </div>
            </div>
            <div class="col-sm-4"></div>
        </div>
    </div>
</div>
</body>
<footer>
    <jsp:include page="MasterFooter.jsp"/>
</footer>
</html>
