<%@ page contentType="text/html;charset=windows-1256" isErrorPage="true" %>

<%@ taglib prefix="library" uri="https://java.sun.com/jsp/library/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256"/>
    </head>
    <body>
     <c:out value="${pageContext.exception}"/>
    </body>
</html>