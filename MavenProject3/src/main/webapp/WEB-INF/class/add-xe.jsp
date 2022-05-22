<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- taglib JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- taglib SPRING-FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <sf:form action="/createXe" method="post" modelAttribute="xeDTO">
        <label>Id</label>
        <sf:input path="maXe" placeholder = "maXe" ></sf:input>
        <br>
        <label>Hang San Xuat</label>
        <sf:input path="hangSanXuat" placeholder="Hang San Xuat"></sf:input>
        <br>
        <label>Hang San Xuat</label>
        <sf:input path="bienSo" placeholder="Bien So Xe"></sf:input>
        <br>
        <label>Hang San Xuat</label>
        <sf:input path="hanKiemDinh" placeholder="Han Kiem Dinh"></sf:input>
        <br>
        <sf:select path="maNhaXe" >
            <c:forEach var="item" items="${nhaXes}">
                <option value="${item.maNhaXe}">${item.tenNhaXe}</option>
            </c:forEach>
        </sf:select>
        <sf:select path="maLoaiXe" >
            <c:forEach var="item" items="${loaiXes}">
                <option value="${item.maLoaiXe}">${item.moTaLoaiXe}</option>
            </c:forEach>
        </sf:select>
        <button type="submit">submit</button>
    </sf:form>
</body>
<script>

</script>
</html>