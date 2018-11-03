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
                            <h2 class="title">Issues Books</h2>
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
                 
                <form name="type" id="type" action="#" method="post">
                    <table border="0" align="left" width="100%">
                        <tr>
                            <td width="231">
                                <span class="style5">Select Type</span>
                            </td>
                            <td width="77">
                                <select name="type" style="width: 300px;" onchange="this.form.submit()">
                                    <option value="">select Type</option>
                                    <option value="isbn">isbn</option>
                                    <option value="title">title</option>
                                    <option value="Author">Author</option>
                                </select>
                            </td>
                            <td align="center" width="332" class="style2">
                                <strong>
                                    <c:choose>
                                        <c:when test="${!empty param.type}">
                                            Current Type IS
                                            <c:out value="${param.type}"/>
                                        </c:when>
                                        <c:otherwise>
                                            <strong>Required</strong>
                                        </c:otherwise>
                                    </c:choose></strong>
                            </td>
                        </tr>
                    </table>
                </form>
                 
                <br/><br/>
                 
                <c:if test="${! empty param.type}">
                  
                    <form action="#" name="search" method="post" onsubmit="return fun()">
                      <c:set var="type" value="${param.type}" scope="session"/>
                      <table border="0" align="left" width="100%">
                            <tr>
                                <td width="231">
                                    <span class="style5">Type Value</span>
                                </td>
                                <td width="360" height="20">
                                    <input type="text" name="valueSearched" maxlength="50" size="30" id="valueSearched"
                                           align="middle" style="width:inherit; height:inherit;"
                                           value="${sessionScope.valueSearched}"/>
                                </td>
                                <td align="center" width="332" class="style1">
                                    <strong>
                                        <c:choose>
                                            <c:when test="${! empty sessionScope.errorValue}">
                                                <c:out value="${sessionScope.errorValue}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <strong>Required</strong>
                                            </c:otherwise>
                                        </c:choose></strong>
                                </td>
                            </tr>
                             
                            <tr>
                                <td colspan="2" align="left">
                                    <input type="submit" name="Search" id="Search" value="Book Search"
                                           style="width: 200px;"/>
                                </td>
                                <td align="left">
                                    <input type="reset" value="Reset Data" style="width: 200px;"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                </c:if>
                 
                <br/><br/>
                 
                <c:if test="${! empty param.Search}">
                    <form action="#" name="search" method="post" onsubmit="return fun()">
                        <table border="0" align="left" width="810">
                            <tr>
                                <td width="111" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Book ID</div>
                                </td>
                                <td width="140" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">ISBN No</div>
                                </td>
                                <td width="180" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Book Title</div>
                                </td>
                                <td width="111" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Price</div>
                                </td>
                                <td width="142" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Publish Date</div>
                                </td>
                                <td width="119" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">issue</div>
                                </td>
                            </tr>
                            <library:books type="${sessionScope.type}" value="${param.valueSearched}">
                            <c:remove var="type" scope="session"/>
                            <c:forEach items="${books}" var="book">
                            <tr>
                             <td width="111" height="28" bgcolor="#DDD5B1" class="style1">
                             <div align="center">${book.key}</div>
                             </td>
                            <td width="140" height="28" bgcolor="#DDD5B1" class="style1">
                            <div align="center">${book.value.isbn}</div>
                            </td>
                           <td width="180" height="28" bgcolor="#DDD5B1" class="style1">
                           <div align="center">${book.value.title}</div>
                           </td>
                           <td width="111" height="28" bgcolor="#DDD5B1" class="style1">
                           <div align="center">${book.value.price}</div>
                           </td>
                           <td width="142" height="28" bgcolor="#DDD5B1" class="style1">
                           <div align="center">${book.value.publishDate}</div>
                           </td>
                            <td width="119" height="28" bgcolor="#DDD5B1" class="style1">
                            <div align="center"><a href="<c:out value="IssueBook.jsp?bookID=${book.key}&bookIsbn=${book.value.isbn}"/>">Issue</a></div>
                            </td>
                                
                           </tr>
                          
                           </c:forEach>
                           
                            </library:books>
                        </table>
                    </form>
                </c:if>
            </div>
            <!-- end #sidebar -->
         </div>
        <!-- end #page -->
 
       
        <div id="footer">
            <p>&nbsp;</p>
        </div>
    </body>
</html>