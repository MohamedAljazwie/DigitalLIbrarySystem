<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" import="java.util.*,java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
        <title>Digital Library System</title>
        <meta name="keywords" content=""/>
        <meta name="description" content=""/>
        <link href="default.css" rel="stylesheet" type="text/css"/>
        <style type="text/css">
<!--                .style4 {
                    color: #000000;
                    font-weight: bold;
                }
-->
            </style>
        <script language="javascript">
          function fun() {
              if (document.addcat.category.value == "") {
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
                            <h2 class="title">Category</h2>
                        </blockquote>
                    </blockquote>
                </div>
                <form action="addcategory" name="addcat" method="post" onSubmit="return fun()">
                    <table border="0" width="782" align="center" height="236">
                        <tr>
                            <td height="34" width="129">
                                <span class="style4">Category Name</span>
                            </td>
                            <td width="342">
                                <input type="text" name="name" size="50"/>
                            </td>
                            <td align="center" width="303" class="style2">
                                <strong>
                                    <c:choose>
                                        <c:when test="${!empty param.name}">
                                            <c:out value="${param.name}"/>
                                        </c:when>
                                        <c:otherwise>
                                            <strong>Required</strong>
                                        </c:otherwise>
                                    </c:choose></strong>
                            </td>
                        </tr>
                         
                        <tr>
                            <td colspan="2" align="left">
                                <input type="submit" value="Add Categhory"/>&nbsp;
                            </td>
                            <td align="center" width="303">
                                &nbsp; 
                                <input type="reset" value="Reset Data"/>
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