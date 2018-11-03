<%@ page contentType="text/html;charset=windows-1256"%>
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
<!--                .style1 {
                    color: #FF0000;
                    font-weight: bold;
                    font-size: 14px;
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
                            <h2 class="title">Search</h2>
                        </blockquote>
                    </blockquote>
                </div>
                <form action="" method="post" name="status">
                    <div align="center" class="style1">
                        <c:if test="${! empty param.status}">
                            <c:out value="${param.status}"/>
                          </c:if>
                    </div>
                </form>
                 
                <br/>
                 
                <br/>
    <br/>
                 
                <br/>
                <form name="SearchFor" id="SearchFor" action="Search.jsp" method="post">
                    <table  align="left" width="100%">
                        <tr>
                            <td width="231">
                                <span class="style5">Search For</span>
                            </td>
                            <td width="77">
                                <select name="type" style="width: 400px;"  onchange="this.form.submit()">
                                    <option value="" selected="selected">Search For</option>
                                    <option <c:if test="${sessionScope.searchFor eq 'Person'}">  selected="selected"</c:if> value="Person">Person</option>
                                    <option <c:if test="${sessionScope.searchFor eq 'Book'}">  selected="selected"</c:if>    value="Book"  >Book</option>
                                </select>
                            </td>
                            <td align="center" width="332" class="style2">
                                <strong>
                                    <c:choose>
                                        <c:when test="${!empty sessionScope.searchFor}">
                                            Current Search For 
                                            <c:out value="${sessionScope.searchFor}"/>
                                        </c:when>
                                        <c:otherwise>
                                            <strong>Required</strong>
                                        </c:otherwise>
                                    </c:choose></strong>
                            </td>
                        </tr>
                    </table>
                </form>
                
                <br/><br/><br/>
     <form name="PersonSearch" id="PersonSearch" action="personSearch.jsp" method="post">
                    <table border="0" align="left" width="100%">
                        <tr>
                            <td width="231">
                                <span class="style5">Slect Person</span>
                            </td>
                            <td width="77">
                                <select name="personSearch" style="width: 400px;" onchange="this.form.submit()">
                                    <option selected="selected" value="">Slect    Person</option>
                                    <option value="Student">Student</option>
                                    <option value="Author">Author</option>
                                     <option value="Publisher">Publisher</option>
                                </select>
                            </td>
                            <td align="center" width="332" class="style2">
                                <strong>
                                    <c:choose>
                                        <c:when test="${!empty param.personSearch}">
                                            Current Search For 
                                            <c:out value="${param.personSearch}"/>
                                        </c:when>
                                        <c:otherwise>
                                            <strong>Required</strong>
                                        </c:otherwise>
                                    </c:choose></strong>
                            </td>
                        </tr>
                    </table>
                </form>
                
                <br/><br/><br/>
                 
                <c:if test="${! empty param.personSearch}">
                  
                    <form action="#" name="search" method="post" onsubmit="return fun()">
                      <c:set var="type" value="${param.personSearch}" scope="session"/>
                      <table border="0" align="left" width="100%">
                            <tr>
                                <td width="231">
                                    <span class="style5">Search For</span>
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
  </div>
<!-- end #sidebar -->
</div>
<!-- end #page -->
<div id="footer">
	<p>&nbsp;</p>
</div>
    </body>
</html>