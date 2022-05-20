<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- taglib JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- taglib SPRING-FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%--<jsp:include page="/WEB-INF/base/base.jsp"></jsp:include>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<form action="/classes/filter/amount" method="GET">
    <input type="text" id="getMoreThan" name="getMoreThan" path="getMoreThan">
    <input type="text" id="getLessThan" name="getLessThan" path="getLessThan">
    <button type="submit">Filter</button>
</form>

<form action="/classes" method="get" modelAttribute="classes">
    <table>
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Amount</th>
            <th>Monitor</th>
        </tr>
        <c:forEach var="aClass" items="${classes}">
            <tr>
                <td>${aClass.id}</td>
                <td>${aClass.name}</td>
                <td>${aClass.amount}</td>
                <td>${aClass.monitor}</td>
                <td>
                    <a type="button" href="/classes/edit/${aClass.id}">Edit</a>
                    <a type="button" href="/classes/delete/${aClass.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>

</html>