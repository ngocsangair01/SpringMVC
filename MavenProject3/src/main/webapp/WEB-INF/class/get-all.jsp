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
    <table>
        <tr>
            <th>ID</th>
            <th>Hang San Xuat</th>
            <th>Bien so xe</th>
            <th> Han kiem dinh</th>
            <th> Loai xe</th>
            <th> Nha xe</th>
        </tr>
        <c:forEach var="item" items="${xes}">
            <tr>
                <td>${item.maXe}</td>
                <td>${item.hangSanXuat}</td>
                <td>${item.bienSo}</td>
                <td>${item.hanKiemDinh}</td>
                <td>${item.loaiXe.moTaLoaiXe}</td>
                <td>${item.nhaXe.tenNhaXe}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>