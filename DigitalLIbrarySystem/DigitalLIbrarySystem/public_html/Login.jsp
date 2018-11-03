<%@ page contentType="text/html;charset=windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
        <title>Digital Library System</title>
        <meta name="keywords" content=""/>
        <meta name="description" content=""/>
        <link href="default.css" rel="stylesheet" type="text/css"/>
        <style type="text/css">
<!--                .style1 {
                    color: #333333;
                    font-weight: bold;
                }

                .style2 {
                    color: #FF0000;
                    font-weight: bold;
                }
-->
            </style>
    </head>
    <body>
        <div id="header">
            <div id="logo">
                <h1>
                    <jsp:include page="header.html"/>
                </h1>
            </div>
            <div id="menu">
                <jsp:include page="generaloptions.html"/>
            </div>
        </div>
        <div id="page">
            <div id="content">
                <div id="welcome" class="boxed2">
                    <h1 class="title">Welcome to Library!</h1>
                </div>
            </div>
            <!-- end #content -->
            <div id="sidebar1">
                <div id="news" class="boxed1">
                    <blockquote>
                        <blockquote>
                            <h2 class="title">Login</h2>
                        </blockquote>
                    </blockquote>
                </div>
                <br/>
                <div class="content" style="width:819px;">
                
                    <p align="left" class="style2">
                  
                                <strong>
                                <c:choose>
                                    <c:when  test="${!empty param.status}">
                                        <c:out value="${param.status}"/>
                                        </c:when>
                                    </c:choose></strong>
                           
                    </p>
                    
                </div>
                <br/>
                <form name="login" id="f1" action="login" method="post" >
                    
                    <table border="0" width="806">
                        <tr>
                            <td width="88" height="34">
                                <strong>User name</strong>
                            </td>
                            <td width="378" height="20">
                                <label>
                                    <input name="userName" type="text" id="userName" size="50" value="${requestScope.userName}"/>
                                </label>
                            </td>
                             <td align="center" width="332" class="style2">
                                <strong>
                                <c:choose>
                                    <c:when  test="${!empty param.errorUserName}">
                                        <c:out value="${param.errorUserName}"/>
                                        </c:when>
                                    <c:otherwise><strong>Required</strong></c:otherwise>
                                    </c:choose></strong>
                            </td>
                        </tr>
                         
                        <tr>
                            <td height="50" width="88">
                                <strong>Password</strong>
                            </td>
                            <td width="378" height="20">
                                <input name="password" type="password" id="password" size="50"/>
                            </td>
                            <td align="center" width="332" class="style2">
                                <strong>
                                <c:choose>
                                    <c:when  test="${!empty param.errorPassword}">
                                        <c:out value="${param.errorPassword}"/>
                                        </c:when>
                                    <c:otherwise><strong>Required</strong></c:otherwise>
                                    </c:choose></strong>
                            </td>
                            
                        </tr>
                         
                        <tr>
                            <td width="88">&nbsp;</td>
                            <td width="378">&nbsp;</td>
                        </tr>
                         
                        <tr>
                            <td colspan="3">
                                <div align="center">
                                    <input type="submit" size="22"  name="button" id="button" value="Sign In"/>
                                </div>
                            </td>
                        </tr>
                         
                        <tr>
                            <td colspan="3" >
                                <div align="left" class="style2">
                                    <p>
                                        <label>
                                            <strong>if You Forget Password Please
                                                <a href="Login.jsp">Click Heare</a></strong>
                                        </label>
                                    </p>
                                </div>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <!-- end #sidebar -->
        </div>
        <!-- end #page -->
        <div id="footer">
            <p>&nbsp;</p>
        </div>
    </body>
</html>