<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:mainLayout title="Main">
    <h1>Товары</h1>

<#list merchs as merch>
<fieldset>
    <legend>${merch.name}</legend>
    <div>Артикул: ${merch.articul}</div>
    <div>Наименование: ${merch.name}</div>
    <div>Цена: ${merch.price}</div>
    <div>
        <form method="post" action="/manicure/selectmerch">
            <input type="hidden" name="merchid" value="${merch.id}">
            <input type="submit" value="Выбрать">
        </form>
    </div>
</fieldset>
</#list>
</t:mainLayout>