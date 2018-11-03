<%@ page contentType="text/html;charset=windows-1256"%>
<%@ taglib prefix="library" uri="https://java.sun.com/jsp/library/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256"/>
    </head>
    <body>
    
      <%--       <c:set var="stat" value="false" scope="session"/>--%>
            <c:choose>
                <c:when test="${sessionScope.Role eq 'Publisher' || 'Author'}">
                    <jsp:useBean id="info" class="org.sun.Library.Bean.PersonInfo" scope="session">
                        <jsp:setProperty name="info" property="*"/>
                    </jsp:useBean>
                    <c:redirect url="addPerson"/>
                </c:when>
                <c:when test="${sessionScope.Role eq 'Student'} ">
                    <jsp:useBean id="student" class="org.sun.Library.Controler.Member.Student" scope="session">
                        <jsp:setProperty name="student" property="*"/>
                        <jsp:useBean id="info" class="org.sun.Library.Bean.PersonInfo" scope="session">
                            <jsp:setProperty name="info" property="*"/>
                        </jsp:useBean>
                        <jsp:useBean id="access" class="org.sun.Library.Bean.Access" scope="session">
                            <jsp:setProperty name="access" property="*"/>
                        </jsp:useBean>
                        <jsp:setProperty name="student" property="info" value="${sessionScope.info}"/>
                        <jsp:setProperty name="student" property="access" value="${sessionScope.access}"/>
                    </jsp:useBean>
                    <c:redirect url="addPerson"/>
                </c:when>
            </c:choose>
        
    </body>
</html>