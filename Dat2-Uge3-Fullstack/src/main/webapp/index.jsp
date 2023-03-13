<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<header>
    <jsp:include page="MasterHeader.jsp"/>
</header>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
<footer>
    <jsp:include page="MasterFooter.jsp"/>
</footer>
</html>