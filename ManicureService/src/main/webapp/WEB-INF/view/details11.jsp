<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:avtorizLayout title="details">
    <div class="container" style="display: flex;align-items: center;justify-content: center;}">
        <div style="flex: 1;" class="photo">
            <img style="width: 700px;height: 550px" src="/manicure/images/ph4.jpg" alt="Фотография">
        </div>
        <div style="flex: 1; text-align: center"class="text">
            <h2> European men's manicure offers a classic approach to men's nail care. It includes nail treatment, cuticle removal and creating a neat and professional look. This is suitable for those who prefer a natural and neat expression of the grooming of their nails.</h2>        </div>
    </div>
    <div id="record" class="buttonRecord">
        <a href="/manicure/login"><button type="submit">Sign up for a manicure</button></a>
    </div>
</t:avtorizLayout>