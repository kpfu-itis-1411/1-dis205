<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Home page">
        <%@include file="/WEB-INF/view/parts/_nav.jsp"%>
        <h1>Добро пожаловать на наш ресурс!</h1>
        Вот наши основные страницы:
        <ul>
                <li><a href="movies">Список фильмов</a></li>
                <li><a href="viewer/list/">Зрители</a></li>
        </ul>

</t:mainLayout>