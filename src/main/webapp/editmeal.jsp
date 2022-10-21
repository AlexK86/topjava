<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ru">
<head>
    <title>Edit meal</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>${action} meal</h2>

<form method="POST" action="meals"
      var="editMealBack" items="${editMealBack}">
    <table cellpadding="5">
        <tr hidden>
            <td>Action:</td>
            <td><input type="text" readonly="readonly" name="actionForm"
                       value="${action}"/> <br/></td>
        </tr>
        <tr hidden>
            <td>Meal ID:</td>
            <td><input type="text" readonly="readonly" name="mealId"
                       value="${editMealBack.id}"/> <br/></td>
        </tr>
        <tr>
            <td>DateTime:</td>
            <td><input type="datetime-local" name="datetime-local"
                       value="${editMealBack.dateTime}" required/> <br/></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><input type="text" name="description" size="50"
                       value="${editMealBack.description}" required/> <br/></td>
        </tr>
        <tr>
            <td>Calories:</td>
            <td><input type="number" name="calories" size="15"
                       value="${editMealBack.calories}" required/><br/></td>
        <tr>
            <td><input type="submit" value="Save"/>
                <input type="button" value="Cancel" onClick='location.href="/topjava/meals"'/></td>
        </tr>
    </table>
</form>
</body>
</html>