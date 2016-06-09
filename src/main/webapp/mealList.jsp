<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Meal List</title>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Meal list</h2>

<table style="border: 1px solid; width: 500px; text-align:center">
    <thead style="background:#fcf">
    <tr>
        <th>Description</th>
        <th>Calories</th>
        <th>Date Time</th>
        <th>Exceed</th>
        <th colspan="4"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userMeals}" var="meal">
            <tr bgcolor="red">
            <td><c:out value="${meal.description}" /></td>
            <td><c:out value="${meal.calories}" /></td>
            <td><c:out value="${meal.dateTime}" /></td>
            <td><c:out value="${meal.exceed}" /></td>
        </tr>

    </c:forEach>
    </tbody>
</table>
</body>
</html>
