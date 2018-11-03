<%@ page contentType="text/html;charset=windows-1256"%>
<%@ taglib prefix="library" uri="https://java.sun.com/jsp/library/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page autoFlush="true" buffer="128kb"%>
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
    <script language="javascript">
      function change() {
          var isbn = "";
          var stuid = document.renewbook.stuid.value;
          location.href = "getbooks?isbn=" + isbn + "&page=/Changepassword.jsp&prefix=issue&bookid=&stuid=" + stuid;
      }

      function change1() {
          var isbn = "";
          var stuid = document.renewbook.stuid.value;
          var bookid = document.renewbook.bookid.value;
          location.href = "getbooks?isbn=" + isbn + "&page=/Changepassword.jsp&prefix=issue&stuid=" + stuid + "&bookid=" + bookid;
      }

      function calculate() {
          var str1 = new Date(document.renewbook.issuedate.value);
          var str2 = new Date(document.renewbook.returndate.value);
          var bookid = document.renewbook.bookid.value;
          var stuid = document.renewbook.stuid.value;
          location.href = "calculatefine?page=/Changepassword.jsp&isbn=&prefix=&bookid=" + bookid + "&stuid=" + stuid;

      }
    </script>
</head>
<body>
    <div id="header">
        <div id="logo">
            <h1>
                <jsp:include page="header.html"/>
            </h1>
        </div>
        <div id="menu">
            <c:choose>
                <c:when test="${sessionScope.roleAccess eq 'Admin'}">
                    <jsp:include page="/adminoptions.html"/>
                </c:when>
                <c:when test="${sessionScope.roleAccess eq 'Student'}">
                    <jsp:include page="/studentoptions.html"/>
                </c:when>
            </c:choose>
        </div>
    </div>
    <div id="page">
        <div id="content">
            <div id="welcome" class="boxed2">
                <h1 class="title">Change Password</h1>
            </div>
        </div>
        <div class="content" style="width:819px;">
            <p align="left" class="style2">
                <strong>
                    <c:choose>
                        <c:when test="${!empty param.status}">
                            <c:out value="${param.status}"/>
                        </c:when>
                    </c:choose></strong>
            </p>
        </div>
        <br/>
         
        <form name="ChangePassword" id="ChangePassword" action="changePassword" method="post">
            <table border="0" width="100%">
                <tr>
                    <td width="100" height="34">
                        <strong>User Name</strong>
                    </td>
                    <td width="275" height="30">
                        <label>
                            <input name="userName" type="text" id="userName" size="50" value="${sessionScope.userName}" readonly="readonly"/>
                        </label>
                    </td>
                    <td align="center" width="320" class="style2">
                        <strong>
                            <c:choose>
                                <c:when test="${!empty param.errorUserName}">
                                    <c:out value="${param.errorUserName}"/>
                                </c:when>
                                <c:otherwise>
                                    <strong>Required</strong>
                                </c:otherwise>
                            </c:choose></strong>
                    </td>
                </tr>
                 
                <tr>
                    <td height="80" width="100">
                        <strong>Old Password</strong>
                    </td>
                    <td width="275" height="30">
                        <input name="oldPassword" type="password" id="oldPassword" size="50" value="${requestScope.oldPassword}"/>
                    </td>
                    <td align="center" width="320" class="style2">
                        <strong>
                            <c:choose>
                                <c:when test="${!empty param.errorOldPassword}">
                                <c:out value="${param.errorOldPassword}"/>
                                </c:when>
                                <c:otherwise>
                                    <strong>Required</strong>
                                </c:otherwise>
                            </c:choose></strong>
                    </td>
                </tr>
                 
                <tr>
                    <td height="80" width="100">
                        <strong>New Password</strong>
                    </td>
                    <td width="275" height="30">
                        <input name="newPassword" type="password" id="newPassword" size="50"/>
                    </td>
                    <td align="center" width="320" class="style2">
                        <strong>
                            <c:choose>
                                <c:when test="${!empty param.errorNewPassword}">
                                 <c:out value="${param.errorNewPassword}"/>
                                </c:when>
                                <c:otherwise>
                                    <strong>Required</strong>
                                </c:otherwise>
                            </c:choose></strong>
                    </td>
                </tr>
                 
                <tr>
                    <td height="34" width="100" colspan="2">
                        <div align="center">
                            <input type="submit" size="70" name="button" id="button" value="Change Password "/>
                        </div>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <!-- end #sidebar -->
    <!-- end #page -->
    <div id="footer">
        <p>&nbsp;</p>
    </div>
</body>
</html>