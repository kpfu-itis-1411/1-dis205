<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Cinema list">
    <%@include file="/WEB-INF/view/parts/_nav.jsp"%>
    <div class="text-info"> Movies count: ${movies.size()}</div>
    <div class="cinema-list">
        <c:forEach items="${movies}" var="movie">
        <div class="cinema-card">
            <div class="cinema-header">
                <h3 class="cinema-name"><a href= "<c:url value="/movie/${movie.id}"/>">${movie.getTitle()}</a></h3>
<%--                <span class="description">${movie.getDescription()}</span>--%>
<%--                <div class="book-action-icon"><a href="/book/delete/1" class="text-danger"><i class="glyphicon glyphicon-remove"></i></a></div>--%>
<%--                <div class="book-action-icon"><a href="/book/edit/1" class="text-success"><i class="glyphicon glyphicon-edit"></i></a></div>--%>
                <div class="clearfix"></div>
            </div>
<%--            <div class="description">${movie.getDescription()}</div>--%>
        </div>
        </c:forEach>

    </div>
</t:mainLayout>