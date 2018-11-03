<%@ page contentType="text/html;charset=windows-1256"%>
<%@ page import="java.lang.System"%>
<%@ taglib prefix="library" uri="https://java.sun.com/jsp/library/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
    <c:remove var="info" scope="session"/>
    <c:remove var="infoError" scope="session"/>
    <c:remove var="student" scope="session"/>
    <c:remove var="access" scope="session"/>
    <c:remove var="studentError" scope="session"/>
    <c:remove var="author" scope="session"/>
    <c:remove var="authorError" scope="session"/>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256"/>
        <title>Digital Library System</title>
        <meta name="keywords" content=""/>
        <meta name="description" content=""/>
        <link href="default.css" rel="stylesheet" type="text/css"/>
        <script language="javascript" type="text/javascript" src="scripts/datetimepicker.js">
          //Date Time Picker script- by TengYong Ng of http://www.rainforestnet.com
          //Script featured on JavaScript Kit (http://www.javascriptkit.com)
          //For this script, visit http://www.javascriptkit.com 
        </script>
        <style type="text/css">
<!--                .style5 {
                    color: #000000;
                    font-weight: bold;
                    font-size: 14px;
                }
-->
            </style>
        <script language="javascript">
          function fun() {
              if (document.register.regid.value == "" || document.register.name.value == "" || document.register.address.value == "" || document.register.phno.value == "" || document.register.fee.value == "" || document.register.pass.value == "" || document.register.cpass.value == "") {
                  alert("All fields are Manditary");
                  return false;
              }

              return true;
          }
        </script>
        <style type="text/css">
<!--                .style1 {
                    color: #000000;
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
                <jsp:include page="adminoptions.html"/>
            </div>
        </div>
        <div id="page">
            <!-- end #content -->
            <div id="sidebar">
                <div id="news" class="boxed1">
                    <blockquote>
                        <blockquote>
                            <h2 class="title">Add Person</h2>
                        </blockquote>
                    </blockquote>
                </div>
                <form name="person" action="#" method="post">
                    <table border="0" align="left" width="100%">
                        <tr>
                            <td width="231">
                                <span class="style5">Select Person</span>
                            </td>
                            <td width="77">
                                <select name="person" style="width: 300px;" onchange="this.form.submit()">
                                    <option value="">select Person</option>
                                    <option value="Publisher">Publisher</option>
                                    <option value="Student">Student</option>
                                    <option value="Author">Author</option>
                                </select>
                            </td>
                            <td align="center" width="332" class="style2">
                                <strong>
                                    <c:choose>
                                        <c:when test="${!empty param.person}">
                                            Current Person IS
                                            <c:out value="${param.person}"/>
                                        </c:when>
                                        <c:otherwise>
                                            <strong>Required</strong>
                                        </c:otherwise>
                                    </c:choose></strong>
                            </td>
                        </tr>
                    </table>
                </form>
                 
                <c:if test="${! empty param.person}">
                    <form name="register" action="addPerson" onsubmit="return fun()" method="post">
                        <c:set var="Role" value="${param.person}" scope="session"/>
                        
                        <table border="0" align="left">
                            <c:choose>
                                <c:when test="${param.person eq 'Student'}">
                                    <jsp:include page="/student.jsp" flush="true"/>
                                </c:when>
                                <c:when test="${param.person eq 'Publisher'}">
                                    <jsp:include page="/publisher.jsp" flush="true"/>
                                </c:when>
                                <c:when test="${param.person eq 'Author'}">
                                    <jsp:include page="/author.jsp" flush="true"/>
                                </c:when>
                            </c:choose>
                             
                            <tr>
                                <td colspan="2" align="left">
                                    <input type="submit" name="Registeration" value="Registeration"
                                           style="width: 200px;"/>
                                     &nbsp;
                                </td>
                                <td align="left">
                                    <input type="reset" value="Reset All" style="width: 200px;"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                </c:if>
            </div>
            <!-- end #sidebar -->
        </div>
        <c:choose>
            <c:when test="${param.person eq 'Student'}">
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
            </c:when>
            <c:when test="${param.person eq 'Author'}">
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                </c:when>
            <c:otherwise>
                <br/>
                <br/>
                <br/>
            </c:otherwise>
        </c:choose>
         
        <br/><br/><!-- end #page -->
        <div id="footer">
            <p>&nbsp;</p>
        </div>
        <c:if test="${! empty param.Registeration}">
            <jsp:useBean id="info" class="org.sun.Library.Bean.PersonInfo" scope="session">
                <jsp:setProperty name="info" property="*"/>
            </jsp:useBean>
            <c:choose>
                <c:when test="${sessionScope.Role eq 'Publisher' || sessionScope.Role eq 'Author'}">
                   
                    <c:redirect url="addPerson"/>
                </c:when>
                <c:when test="${sessionScope.Role eq 'Student'} ">
                    <jsp:useBean id="student" class="org.sun.Library.Controler.Member.Student" scope="session">
                        <jsp:useBean id="access" class="org.sun.Library.Bean.Access" scope="page">
                            <jsp:setProperty name="access" property="*"/>
                        </jsp:useBean>
                        <jsp:setProperty name="student" property="info" value="${sessionScope.info}"/>
                        <jsp:setProperty name="student" property="access" value="${pageScope.access}"/>
                        <jsp:setProperty name="student" property="nationalID"/>
                        <jsp:setProperty name="student" property="question"/>
                        <jsp:setProperty name="student" property="answer"/>
                    </jsp:useBean>
                    <c:redirect url="addPerson"/>
                </c:when>
            </c:choose>
        </c:if>
    </body>
</html>