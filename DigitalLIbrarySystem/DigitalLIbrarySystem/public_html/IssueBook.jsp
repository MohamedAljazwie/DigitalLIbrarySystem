<%@ page contentType="text/html;charset=windows-1256"%>
<%@ page import="java.lang.System"%>
<%@ taglib prefix="library" uri="https://java.sun.com/jsp/library/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256"/>
        <title>Digital Library System</title>
        <meta name="keywords" content=""/>
        <meta name="description" content=""/>
          <link href="default.css" rel="stylesheet" type="text/css"/>
               <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
   <script>
  $( function() {
    $( "#datepicker1" ).datepicker();
  } );
  </script>
        <style type="text/css">
<!--                .style1 {
                    color: #FF0000;
                    font-weight: bold;
                    font-size: 14px;
                }
-->
            </style>
        <script language="javascript">
          function fun() {
              if (document.issueBook.studentID.value == "" || document.issueBook.nationalID.value == "" || document.issueBook.bookID.value == "" || document.issueBook.isbn.value == "" || document.issueBook.issueDate.value == "" || document.issueBook.returnDate.value == ""
              {
                  alert("All fields are Manditary");
                  return false;
              }

              return true;
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
                <jsp:include page="adminoptions.html"/>
            </div>
        </div>
        <div id="page">
            <!-- end #content -->
            <div id="sidebar">
                <div id="news" class="boxed1">
                    <blockquote>
                        <blockquote>
                            <h2 class="title">Issue Book</h2>
                        </blockquote>
                    </blockquote>
                </div>
                <form action="" method="post" name="login">
                    <div align="center" class="style1">
                        <c:if test="${! empty param.status}">
                            <c:out value="${param.status}"/>
                        </c:if>
                    </div>
                </form>
                 
                <br/>
                 
                <br/>
                 
                <form action="#" name="search" method="post" onsubmit="return fun()">
                    <table border="0" align="left" width="100%">
                        <tr>
                            <td width="231">
                                <span class="style5">Studient National ID</span>
                            </td>
                            <td width="360" height="20">
                                <input type="text" name="nationalID" maxlength="50" size="30" id="nationalID"
                                       align="middle" style="width:inherit; height:inherit;"
                                       value="${param.nationalID}"/>
                            </td>
                            <td align="center" width="332" class="style1">
                                <strong>
                                    <c:choose>
                                        <c:when test="${! empty sessionScope.errorNationalID}">
                                            <c:out value="${sessionScope.errorValue}"/>
                                        </c:when>
                                        <c:otherwise>
                                            <strong>Required</strong>
                                        </c:otherwise>
                                    </c:choose></strong>
                            </td>
                        </tr>
                         
                        <tr>
                            <td colspan="3">
                                <br/>
                            </td>
                        </tr>
                         
                        <tr>
                            <td colspan="2" align="left">
                                <input type="submit" name="Search" id="Search" value="Check Student"
                                       style="width: 250px;"/>
                            </td>
                            <td align="left">
                                <input type="reset" value="Reset Data" style="width: 250px;"/>
                            </td>
                        </tr>
                    </table>
                </form>
                 
                <br/><br/>
                 
                <c:if test="${! empty param.Search}">
                    <form action="#" name="student" method="post">
                        <table border="0" align="left" width="100%">
                            <tr>
                                <td width="111" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Student ID</div>
                                </td>
                                <td width="140" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Student National id</div>
                                </td>
                                <td width="160" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Student Name</div>
                                </td>
                                <td width="111" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Student Email</div>
                                </td>
                            </tr>
                             
                            <library:students type="nationalID" value="${param.nationalID}">
                                <c:remove var="type" scope="session"/>
                                <c:forEach items="${students}" var="student">
                                    <tr>
                                        <td width="111" height="28" bgcolor="#DDD5B1" class="style1">
                                            ${student.key}
                                        </td>
                                        <c:set var="studentID" value="${student.key}" scope="page"/>
                                        <td width="140" height="28" bgcolor="#DDD5B1" class="style1">
                                            ${student.value.nationalID}
                                        </td>
                                        <td width="160" height="28" bgcolor="#DDD5B1" class="style1">
                                            ${student.value.info.name}
                                        </td>
                                        <td width="111" height="28" bgcolor="#DDD5B1" class="style1">
                                            ${student.value.info.email}
                                        </td>
                                    </tr>
                                </c:forEach>
                            </library:students>
                        </table>
                    </form>
                    <br/>
                    <br/>
                    <div class="issueBook" id="issueBook">
                    <form action="#" name="issueBook" method="post" onsubmit="return fun()">
                        <table border="0" align="left" width="100%">
                            <tr>
                                <td width="231">
                                    <span class="style5">Studient ID</span>
                                </td>
                                <td width="360" height="20">
                                    <input type="text" name="studentID" maxlength="50" size="30" id="studentID"
                                           align="middle" style="width:inherit; height:inherit;"
                                           value="${pageScope.studentID}" readonly="readonly"/>
                                </td>
                                <td align="center" width="332" class="style2">
                                    <strong>
                                        <c:choose>
                                            <c:when test="${! empty sessionScope.errorNationalID}">
                                                <c:out value="${sessionScope.errorValue}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <strong>Required</strong>
                                            </c:otherwise>
                                        </c:choose></strong>
                                </td>
                            </tr>
                             
                            <tr>
                                <td colspan="3">
                                    <br/>
                                </td>
                            </tr>
                             
                            <tr></tr><tr>
                                <td width="240" height="20" align="left">
                                    <span class="style4">Studient National ID</span>
                                </td>
                                <td width="360" height="20">
                                    <input type="text" name="nationalID" maxlength="50" size="30" id="nationalID"
                                           align="middle" style="width:inherit; height:inherit;"
                                           value="${param.nationalID}" readonly="readonly"/>
                                </td>
                                <td align="center" width="332" class="style2">
                                    <strong>
                                        <c:choose>
                                            <c:when test="${! empty sessionScope.errorNationalID}">
                                                <c:out value="${sessionScope.errorValue}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <strong>Required</strong>
                                            </c:otherwise>
                                        </c:choose></strong>
                                </td>
                            </tr>
                             
                            <tr>
                                <td colspan="3">
                                    <br/>
                                </td>
                            </tr>
                             
                            <tr>
                                <td width="231">
                                    <span class="style5">Book ID</span>
                                </td>
                                <td width="360" height="20">
                                    <input type="text" name="bookID" maxlength="50" size="30" id="bookID" align="middle"
                                           style="width:inherit; height:inherit;" value="${param.bookID}"
                                           readonly="readonly"/>
                                </td>
                                <td align="center" width="332" class="style2">
                                    <strong>
                                        <c:choose>
                                            <c:when test="${! empty sessionScope.errorbookID}">
                                                <c:out value="${sessionScope.errorbookID}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <strong>Required</strong>
                                            </c:otherwise>
                                        </c:choose></strong>
                                </td>
                            </tr>
                             
                            <tr>
                                <td colspan="3">
                                    <br/>
                                </td>
                            </tr>
                             
                            <tr>
                                <td width="231">
                                    <span class="style5">Book ISBN</span>
                                </td>
                                <c:set var="bookIsbn" value="${param.bookIsbn}" scope="session"/> 
                                <td width="360" height="20">
                                    <input type="text" name="isbn" maxlength="50" size="30" id="isbn" align="middle"
                                           style="width:inherit; height:inherit;" value="${param.bookIsbn}"
                                           readonly="readonly"/>
                                </td>
                                <td align="center" width="332" class="style2">
                                    <strong>
                                        <c:choose>
                                            <c:when test="${! empty sessionScope.errorbookIsbn}">
                                                <c:out value="${sessionScope.errorbookIsbn}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <strong>Required</strong>
                                            </c:otherwise>
                                        </c:choose></strong>
                                </td>
                            </tr>
                             
                            <tr>
                                <td colspan="3">
                                    <br/>
                                </td>
                            </tr>
                             
                            <tr>
                                <td width="231">
                                    <span class="style5">Issue Date</span>
                                </td>
                                <td width="360" height="20">
                                    <input type="text" name="issueDate" maxlength="50" size="30" id="datepicker"
                                           align="middle" style="width:inherit; height:inherit;"/>
                                </td>
                                <td align="center" width="332" class="style2">
                                    <strong>
                                        <c:choose>
                                            <c:when test="${! empty sessionScope.errorissueDate}">
                                                <c:out value="${sessionScope.errorissueDate}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <strong>Required</strong>
                                            </c:otherwise>
                                        </c:choose></strong>
                                </td>
                            </tr>
                             
                            <tr>
                                <td colspan="3">
                                    <br/>
                                </td>
                            </tr>
                             
                            <tr>
                                <td width="231">
                                    <span class="style5">Return Date</span>
                                </td>
                                <td width="360" height="20">
                                    <input type="text" name="returnDate" maxlength="50" size="30" id="datepicker1"
                                           align="middle" style="width:inherit; height:inherit;"/>
                                </td>
                                <td align="center" width="332" class="style2">
                                    <strong>
                                        <c:choose>
                                            <c:when test="${! empty sessionScope.errorreturnDate}">
                                                <c:out value="${sessionScope.errorreturnDate}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <strong>Required</strong>
                                            </c:otherwise>
                                        </c:choose></strong>
                                </td>
                            </tr>
                             
                            <tr>
                                <td colspan="3">
                                    <br/>
                                </td>
                            </tr>
                             
                            <tr>
                                <td width="231">
                                    <span class="style5">Nots</span>
                                </td>
                                <td colspan="2" width="360" height="30">
                                    <textarea name="nots" id="nots" cols="50" rows="10"
                                              value="${sessionScope.nots}">
                                   </textarea>
                                </td>
                            </tr>
                             
                            <tr>
                                <td colspan="3">
                                    <br/>
                                </td>
                            </tr>
                             
                            <tr>
                                <td colspan="2" align="left">
                                    <input type="submit" name="IssueBook" id="IssueBook" value="Issue  Book"
                                           style="width: 250px;"/>
                                </td>
                                <td align="left">
                                    <input type="reset" value="Reset Data" style="width: 250px;"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                    </div>
                </c:if>
                <br/><br/>
                <c:if test="${! empty param.IssueBook}">
                <c:out value="You in IssueBook"/>
                <jsp:useBean id="issue" class="org.sun.Library.Controler.Book.IssueBook" scope="session">
              
                                <jsp:useBean id="student" class="org.sun.Library.Controler.Member.Student" scope="page">
                                                    <jsp:useBean  id="info" class="org.sun.Library.Bean.PersonInfo" scope="page">
                                                           <jsp:setProperty name="info" property="id" param="studentID"/>
                                                    </jsp:useBean> <!--  end info bean-->
                                       <jsp:setProperty name="student" property="info" value="${pageScope.info}"/>
                                       <jsp:setProperty name="student" property="nationalID"/>
                                </jsp:useBean> <!-- end student bean-->
                                <jsp:useBean id="book" class="org.sun.Library.Controler.Book.Book" scope="page">
                                                     <jsp:useBean id="bookSpec" class="org.sun.Library.Bean.BookSpec" scope="page">    
                                                             <jsp:setProperty name="bookSpec" property="isbn" />
                                                       </jsp:useBean> <!-- end spec bean-->
                                        <jsp:setProperty name="book" property="bookSpec" value="${pageScope.bookSpec}"/>
                                        <jsp:setProperty name="book" property="id" param="bookID"/>
                                </jsp:useBean> <!-- end book bean-->
                         <jsp:setProperty name="issue" property="book" value="${pageScope.book}"/>
                         <jsp:setProperty name="issue" property="student" value="${pageScope.student}"/>
                         <jsp:setProperty name="issue" property="issueDate"/>
                         <jsp:setProperty name="issue" property="returnDate"/>
                         <jsp:setProperty name="issue" property="nots"/>
                </jsp:useBean> <!--  end issue bean-->
                <c:redirect url="issuebook?isbn=${pageScope.bookSpec.isbn}"/>
                </c:if>
            </div>
            <!-- end #sidebar -->
        </div>
        <!-- end #page -->
        <br/><br/>
         
        <br/><br/>
         
        <br/><br/>
        <div id="footer">
            <p>&nbsp;</p>
        </div>
    </body>
</html>