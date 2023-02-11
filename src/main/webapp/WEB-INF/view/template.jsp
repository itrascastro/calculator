<%--
  Created by IntelliJ IDEA.
  User: itrascastro
  Date: 11/2/23
  Time: 00:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= (String) request.getAttribute("title") %></title>
</head>
<body>
    <header>
        <nav>
            <a href="#">Home</a>
            <a href="#">About</a>
            <a href="#">Contact</a>
        </nav>
    </header>

    <div id="content">
        <jsp:include page="<%= (String) request.getAttribute(\"contentPage\") %>" />
    </div>

    <footer>
        <p>Copyright © 2023</p>
    </footer>
</body>
</html>
