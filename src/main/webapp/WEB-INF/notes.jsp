<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Заметки</title>
    <style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #D3D3D3;
    text-align: left;
    padding: 8px;
}

tr:nth-child(1) {
    background-color: #87CEEB;
}

tr:nth-child(2n+3) {
    background-color: #E0FFFF;
}
    </style>

</head>

<body>
<h1>Мои заметки</h1>
<form action="/" method="GET" accept-charset="UTF-8">
    <input type="text" name="substring" value="${searchString}" style="width: 60%;">
    <input type="submit" value="Искать"></p>
</form>
<table>
    <tr>
        <th style="width: 70%">Заметка</th>
        <th>Действие</th>
    </tr>
    <c:forEach var="note" items="${notesList}">
        <tr>
            <c:choose>
                <c:when test="${note.title == ''}">
                    <td>${note.text}</td>
                </c:when>
                <c:otherwise>
                    <td>${note.title}</td>
                </c:otherwise>
            </c:choose>
            <td><a href="/delete/${note.id}">Удалить эту заметку</a>&nbsp;<a href="/view/${note.id}">Просмотреть</a></td>
        </tr>
    </c:forEach>
</table>
<p><a href="/add-new-note">Добавить новую заметку</a></p>
</body>
</html>
