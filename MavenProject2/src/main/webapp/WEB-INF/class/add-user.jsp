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
<%--Dang bug--%>
<sf:form action="createUser/2" method="POST" modelAttribute="userDTO">
    <label>Id</label>
    <sf:input type="text" path="id" Placeholder="id"/>
    <br>

    <label>Name</label>
    <sf:input type="text" path="name" Placeholder="name"/>
    <br>
    <label>address</label>
    <sf:input type="text" path="address" Placeholder=" address"/>
    <br>

    <label>phoneNumber</label>
    <sf:input type="text" path="phoneNumber" Placeholder=" phoneNumber"/>
    <br>
<%--    <a type="" href="createUser/2">Add new</a>--%>
    <button type="submit">submit</button>
</sf:form>


</body>
</html>