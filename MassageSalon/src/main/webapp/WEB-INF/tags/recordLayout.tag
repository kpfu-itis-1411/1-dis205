<%@tag description="Default Layout Tag" pageEncoding="UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@attribute name="title"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>

    <link rel="stylesheet" href="<c:url value="/style/record.css"/>"/>
</head>
<body>

<div class="container">
    <jsp:doBody/>
</div>
</body>
</html>