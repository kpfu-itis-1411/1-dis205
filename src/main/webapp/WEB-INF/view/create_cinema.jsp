<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Home page">
    <%@include file="/WEB-INF/view/parts/_nav.jsp"%>
    <form action="<c:url value="/cinema/new"/>" method="post">
    <label for="title">Название фильма:</label><br>
    <input type="text" id="title" name="title"><br><br>

    <label for="director">Имя режиссера:</label><br>
    <input type="text" id="director" name="director"><br><br>

    <label for="year">Год выпуска:</label><br>
    <input type="number" id="year" name="year"><br><br>

    <label for="description">Описание фильма:</label><br>
    <textarea id="description" name="description"></textarea><br><br>

    <input type="submit" value="Добавить">
</t:mainLayout>
