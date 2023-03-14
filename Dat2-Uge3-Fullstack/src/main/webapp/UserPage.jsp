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
        <div class="col-sm-3">
            <div class="row">
                <div class="row text-left form-row mt-4">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-7">
                        <h4>Change username</h4>
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
            <br>
            <br>
            <br>
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-2">
                    <form action="ServletDeleteUser" method="get">
                        <input type="submit" value="Delete account" class="btn btn-secondary">
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm-9">
            <div class="row">
                <div class="col-sm-6">
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>List</th>
                            </tr>
                        </thead>
                        <c:set var="listlength" value="${sessionScope.user.getList().size()-1}"/>
                        <c:if test="${listlength < 0}">
                            <c:set var="listlength" value="0"/>
                        </c:if>
                            <tr>
                                <th>
                                    <label class="form-control" style="display: inline-flex;min-width: 88%;min-height: 34px;">List is empty</label>
                                </th>
                            </tr>
                        <c:forEach var="item" begin="0" end="${listlength}">
                            <tr>
                                <th>
                                    <c:if test="${listlength != 0}">
                                        <form action="ServletDeleteValue" method="get">
                                            <input type="hidden" readonly="readonly" name="delValue" id="delValue" value="${sessionScope.user.getList().get(listlength)}" class="form-control">
                                            <label class="form-control" style="display: inline-flex;min-width: 88%;min-height: 34px;">${sessionScope.user.getList().indexOf(listlength)}</label>
                                            <input type="submit" value="Delete" class="btn btn-primary mb-2" style="float: right;">
                                        </form>
                                    </c:if>
                                </th>
                            </tr>
                        </c:forEach>
                        <th>
                            <form action="ServletAddValue" method="get">
                                <input type="text" name="value" id="value" placeholder="Value" class="form-control" style="display: inline-flex;min-width: 88%;min-height: 34px;">
                                <input type="submit" value="Add" class="btn btn-primary mb-2" style="float: right;">
                            </form>
                        </th>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<footer>
    <jsp:include page="MasterFooter.jsp"/>
</footer>
</html>
