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
<hr>
<table border="1" bordercolor="black" rules="all" cellpadding="5">
    <thead>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="meal" items="${meals}">
    <c:set var="colorForExcess"/>
    <c:choose>
        <c:when test="${meal.excess == true}">
            <${colorForExcess="red"}/>
        </c:when>
        <c:otherwise>
            <${colorForExcess="green"}/>
        </c:otherwise>
    </c:choose>
    <tr style="color: ${colorForExcess}"/>
        <td><fmt:parseDate value="${meal.dateTime}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both"/>
            <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${parsedDateTime}"/></td>
        <td><c:out value="${meal.description}"/></td>
        <td><c:out value="${meal.calories}"/></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>