<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<p><a href="/topjava/editmeal?action=add">Add meal</a></p>
<table border="1" bordercolor="black" rules="all" cellpadding="5">
    <thead>
    <tr>
        <th hidden>ID</th>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="meal" items="${meals}">
        <tr style="color: ${meal.excess?"red":"green"}">
        <td hidden>${meal.id}</td>
        <td><fmt:parseDate value="${meal.dateTime}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both"/>
            <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${parsedDateTime}"/></td>
        <td>${meal.description}</td>
        <td>${meal.calories}</td>
        <td><a href="/topjava/editmeal?action=update&id=<c:out value="${meal.id}"/>">Update</a></td>
        <td><a href="/topjava/meals?action=delete&id=<c:out value="${meal.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>