<%@ page contentType="text/html;charset=windows-1256"%>
<%@ page import="java.lang.System"%>
<%@ taglib prefix="library" uri="https://java.sun.com/jsp/library/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=windows-1256"/>
        <meta NAME='Author' CONTENT='Vamsi'/>
        <LINK REL='stylesheet' TYPE='text/css' HREF='styles.css'/>
        <title>Digital Library System</title>
        <meta name="keywords" content=""/>
        <meta name="description" content=""/>
        <link href="default.css" rel="stylesheet" type="text/css"/>
        <SCRIPT LANGUAGE='javascript' TYPE='text/javascript'  SRC='Scripts/script.js'></SCRIPT>
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
              if (document.type.type.value == "" 
              || document.saerch.valueSearched.value == "" {
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
                            <h2 class="title">Returns Books</h2>
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
                <br/><br/>
                                    <form action="#" name="search" method="post" onsubmit="return fun()">
                      <c:set var="type" value="${param.type}" scope="session"/>
                      <table border="0" align="left" width="100%">
                            <tr>
                                <td width="231">
                                    <span class="style5">Student National ID</span>
                                </td>
                                <td width="360" height="20">
                                    <input type="text" name="nationalID" maxlength="50" size="30" id="nationalID"
                                           align="middle" style="width:inherit; height:inherit;"
                                           value="${sessionScope.nationalID}"/>
                                </td>
                                <td align="center" width="332" class="style2">
                                    <strong>
                                        <c:choose>
                                            <c:when test="${! empty sessionScope.errorNationalID}">
                                                <c:out value="${sessionScope.errorNationalID}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <strong>Required</strong>
                                            </c:otherwise>
                                        </c:choose></strong>
                                </td>
                            </tr>
                            <tr>
                            <td colspan="3"><br/><br/></td>
                            </tr>
                             <tr>
                                <td width="231">
                                    <span class="style5">Book ISBN</span>
                                </td>
                                <td width="360" height="20">
                                    <input type="text" name="isbn" maxlength="50" size="30" id="isbn"
                                           align="middle" style="width:inherit; height:inherit;"
                                           value="${sessionScope.isbn}"/>
                                </td>
                                <td align="center" width="332" class="style2">
                                    <strong>
                                        <c:choose>
                                            <c:when test="${! empty sessionScope.errorIsbn}">
                                                <c:out value="${sessionScope.errorIsbn}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <strong>Required</strong>
                                            </c:otherwise>
                                        </c:choose></strong>
                                </td>
                            </tr>
                             
                            <tr>
                                <td colspan="2" align="left">
                                    <input type="submit" name="Search" id="Search" value="Show Issues Book"
                                           style="width: 200px;"/>
                                </td>
                                <td align="left">
                                    <input type="reset" value="Reset Data" style="width: 200px;"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                                 <br/><br/>
                 
                <c:if test="${! empty param.Search}">
                    <form action="#" name="Issues Books" method="post" >
                          <DIV id=common_div ALIGN=center>
				<TABLE width="1500" ALIGN=left CELLSPACING=1 CELLPADDING=1 BORDER=0>
				  
                            <tr>
                               <td width="111" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Issue ID</div>
                                </td>
                                <td width="111" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Student ID</div>
                                </td>
                                <td width="150" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Student National ID</div>
                                </td>
                                <td width="150" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Student Name</div>
                                </td>
                                <td width="111" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Book ID</div>
                                </td>
                                <td width="140" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">ISBN No</div>
                                </td>
                                <td width="180" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Book Title</div>
                                </td>
                                <td width="115" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Issue Date</div>
                                </td>
                                <td width="115" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Return Date</div>
                                </td>
                                <td width="119" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Return</div>
                                </td>
                            </tr>
                            <library:issueBooks isbn="${param.isbn}" nationalID="${param.nationalID}">
                            <c:remove var="type" scope="session"/>
                            <c:forEach items="${books}" var="book">
                            <tr>
                             <td width="111" height="28" bgcolor="#DDD5B1" class="style1">
                              <div align="center">${book.key}</div>
                              </td>
                              <td width="111" height="28" bgcolor="#DDD5B1" class="style1">
                            <div align="center">${book.value.student.info.id}</div>
                            </td>
                            <td width="150" height="28" bgcolor="#DDD5B1" class="style1">
                            <div align="center">${book.value.student.nationalID}</div>
                            </td>
                           <td width="150" height="28" bgcolor="#DDD5B1" class="style1">
                           <div align="center">${book.value.student.info.name}</div>
                           </td>
                           <td width="111" height="28" bgcolor="#DDD5B1" class="style1">
                           <div align="center">${book.value.book.id}</div>
                           </td>
                           <td width="140" height="28" bgcolor="#DDD5B1" class="style1">
                           <div align="center">${book.value.book.bookSpec.isbn}</div></td>
                           
                           <td width="180" height="28" bgcolor="#DDD5B1" class="style1">
                           <div align="center">${book.value.book.bookSpec.title}</div>
                           </td>
                           <td width="115" height="28" bgcolor="#DDD5B1" class="style1">
                           <div align="center">${book.value.issueDate}</div></td>
                           <td width="115" height="28" bgcolor="#DDD5B1" class="style1">
                           <div align="center">${book.value.returnDate}</div>
                           </td>
                            <td width="119" height="28" bgcolor="#DDD5B1" class="style1">
                            <div align="center">
                            <a href= "<c:url value="ReturnBook.jsp?">
                                           <c:param name="studentID" value="${book.value.student.info.id}"/>
                                            <c:param name="nationalID" value="${book.value.student.nationalID}"/>
                                           <c:param name="bookIsbn" value="${book.value.book.bookSpec.isbn}"/>
                                           <c:param name="bookTitle" value="${book.value.book.bookSpec.title}"/>
                                           <c:param  name="issueDate" value="${book.value.issueDate}"/>
                                           <c:param name="returnDate" value="${book.value.returnDate}"/>
                                         <c:param name="bookID" value="${book.value.book.id}"/>
                                           </c:url>">return</a></div>
                           
                            </td>
                               
                           </tr>
                          
                           </c:forEach>
                           
                            </library:issueBooks>
                      </TABLE></DIV><BR>
                    </form>
                </c:if>
             