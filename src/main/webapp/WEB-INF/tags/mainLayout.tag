<%@tag description="Default Layout Tag" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@attribute name="title" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>

    <script src="<c:url value="/js/bootstrap.bundle.min.js"/>"> </script>

    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/min.css"/>">

</head>

<div class="container">
    <jsp:doBody/>
</div>
</body>
</html>