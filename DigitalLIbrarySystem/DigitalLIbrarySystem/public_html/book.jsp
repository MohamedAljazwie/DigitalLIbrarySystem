<%@ page contentType="text/html;charset=windows-1256"%>
<%@ taglib prefix="library" uri="https://java.sun.com/jsp/library/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page autoFlush="true" buffer="128kb" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256"/>
        <title>Digital Library System</title>
        <meta name="keywords" content=""/>
        <meta name="description" content=""/>
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
  <!--<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
  
  <script>
  $(document).ready(function() {
    $("#datepicker").datepicker();
  });
  </script>-->
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
              if (document.addbook.title.value == "" || document.addbook.author.value == "" || document.addbook.bookprice.value == "") {
                  alert("All fields are Manditary");
                  return false;
              }
              return true;
          }
        </script>
    </head>
    <body>
                        <tr>
                            <td width="231">
                                <span class="style5">Category</span>
                            </td>
                            <td width="77">
                                <c:set var="category" value="Category" scope="page"/>
                                 
                                <c:set var="publisher" value="Publisher" scope="page"/>
                                 
                                <c:set var="author" value="Author" scope="page"/>
                                 
                                <select name="category" style="width: 300px;" value="">
                                    <option value="">select Category</option>
                                    <library:view role="${category}">
                                        <c:forEach items="${display}" var="cat">
                                            <option value="${cat.value}">
                                                ${cat.value}
                                            </option>
                                        </c:forEach>
                                    </library:view>
                                </select>
                            </td>
                            <td align="center" width="332" class="style2">
                                <strong>
                                    <c:choose>
                                        <c:when test="${!empty param.category}">
                                            <c:out value="${param.category}"/>
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
                            <td width="360" height="20">
                                <input type="text" name="isbn" maxlength="50" size="30" id="isbn" align="middle"
                                       style="width:inherit; height:inherit;"/>
                            </td>
                            <td align="center" width="332" class="style2">
                                <strong>
                                    <c:choose>
                                        <c:when test="${! empty sessionScope.book.bookSpec.isbn}">
                                            <c:out value="${sessionScope.book.bookSpec.isbn}"/>
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
                                <span class="style5">Book Title</span>
                            </td>
                            <td width="360" height="20">
                                <input type="text" name="title" maxlength="50" size="30" id="title" align="middle"
                                       style="width:inherit; height:inherit;"/>
                            </td>
                            <td align="center" width="332" class="style2">
                                <strong>
                                    <c:choose>
                                        <c:when test="${! empty sessionScope.book.bookSpec.title}">
                                            <c:out value="${sessionScope.book.bookSpec.title}"/>
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
                                <span class="style5">Book Subject</span>
                            </td>
                            <td width="360" height="20">
                                <input type="text" name="subject" maxlength="50" size="30" id="subject" align="middle"
                                       style="width:inherit; height:inherit;"/>
                            </td>
                            <td align="center" width="332" class="style2">
                                <strong>
                                    <c:choose>
                                        <c:when test="${!empty param.subject}">
                                            <c:out value="${param.subject}"/>
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
                                <span class="style5">Book Price</span>
                            </td>
                            <td width="360" height="20">
                                <input type="text" name="price" size="20" id="price" align="middle"
                                       style="width:inherit; height:inherit;"/>
                            </td>
                            <td align="center" width="332" class="style2">
                                <strong>
                                    <c:choose>
                                        <c:when test="${!empty param.price}">
                                            <c:out value="${param.price}"/>
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
                                <span class="style5">Quantity(Copies)</span>
                            </td>
                            <td width="360" height="20">
                                <input type="text" name="copies" size="20" id="copies" align="middle"
                                       style="width:inherit; height:inherit;"/>
                            </td>
                            <td align="center" width="332" class="style2">
                                <strong>
                                    <c:choose>
                                        <c:when test="${!empty param.copies}">
                                            <c:out value="${param.copies}"/>
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
                                <span class="style5">Book Author</span>
                            </td>
                            <td width="77">
                                    <select name="author" style="width: 300px;">
                                    <option value="">select Author</option>
                                    <library:view role="${author}">
                                        <c:forEach items="${display}" var="auth">
                                            <option value="${auth.value}">
                                                ${auth.value}
                                            </option>
                                        </c:forEach>
                                    </library:view>
                                </select>
                            </td>
                            <td align="center" width="332" class="style2">
                                <strong>
                                    <c:choose>
                                        <c:when test="${!empty param.author}">
                                            <c:out value="${param.author}"/>
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
                                <span class="style5">Book Publisher</span>
                            </td>
                            <td width="77">
                                    <select name="publisher" style="width: 300px;">
                                    <option value="">select Publisher</option>
                                    <library:view role="${publisher}">
                                        <c:forEach items="${display}" var="publish">
                                            <option value="${publish.value}">
                                                ${publish.value}
                                            </option>
                                        </c:forEach>
                                    </library:view>
                                </select>
                            </td>
                            <td align="center" width="332" class="style2">
                                <strong>
                                    <c:choose>
                                        <c:when test="${!empty param.publisher}">
                                            <c:out value="${param.publisher}"/>
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
                                <span class="style5">Book Publisher Date</span>
                            </td>
                            <td width="300" height="20">
                                <input type="text" name="publishDate" size="30" id="datepicker" align="middle"
                                       style="width:inherit; height:inherit;"/>
                                  </td>
                            <td align="center" width="332" class="style2">
                                <strong>
                                    <c:choose>
                                        <c:when test="${!empty param.publishDate}">
                                            <c:out value="${param.publishDate}"/>
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
                     
    </body>
</html>