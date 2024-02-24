<%@ page import="ru.kpfu.itis.models.Cinema" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.kpfu.itis.service.CinemaService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Movies page">
    <%@include file="/WEB-INF/view/parts/_nav.jsp"%>
    <h2>Details</h2>
    <div class="cinema-card">
        <div class="cinema-header">
            <div class="item">

                <h3>Title: ${title} </h3>
                <p>
                    Year: ${issue},
                    Director: ${director}
                </p>
            </div>

                <span class="description">${desc}</span>
                <%--                <div class="book-action-icon"><a href="/book/delete/1" class="text-danger"><i class="glyphicon glyphicon-remove"></i></a></div>--%>
                <%--                <div class="book-action-icon"><a href="/book/edit/1" class="text-success"><i class="glyphicon glyphicon-edit"></i></a></div>--%>
            <div class="clearfix"></div>
        </div>
            <%--            <div class="description">${movie.getDescription()}</div>--%>
    </div>
</t:mainLayout>