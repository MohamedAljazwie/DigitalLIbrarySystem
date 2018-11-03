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
        <link href="default.css" rel="stylesheet" type="text/css"/>
        
        <c:remove var="book" scope="session"/>
 <link rel="stylesheet" href="resources/jquery-ui.css" />
  <script src="resources/jquery-1.8.3.js"></script>
  <script src="resources/jquery-ui.js"></script>
  <script>
$(function() {
    $( "#datepicker" ).datepicker();
});
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
              if (document.addbook.title.value == "" || 
              document.addbook.author.value == "" || 
              document.addbook.publisher.value==""||
             document.addbook.subject.value==""||
             document.addbook.copies.value==""||
             document.addbook.publishDate.value==""||        
              document.addbook.price.value == "" ||
              document.addbook.isbn.value==""  ||
              document.addbook.category.value=="") {
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
                            <h2 class="title">Book</h2>
                        </blockquote>
                    </blockquote>
                </div>
                <form action="bookForword.jsp" name="addbook" method="post" onsubmit="return fun()">
                    <table border="0" align="left" width="100%">
                    <jsp:include page="/book.jsp" flush="true"/>
                         
                        <tr>
                            <td colspan="2" align="left">
                                <input type="submit" name ="addBook" value="Add Book" style="width: 200px;"/>
                            </td>
                            <td align="left">
                                <input type="reset" value="Reset Data" style="width: 200px;"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <!-- end #sidebar -->
        </div>
        <br/><br/>
         <br/>
        <br/><br/><!-- end #page -->
        <div id="footer">
            <p>&nbsp;</p>
        </div>
        <%--<c:if test="${ ! empty param.addBook}">
        <jsp:useBean id="book" class="org.sun.Library.Controler.Book.Book" scope="session">
       
    
       <jsp:useBean id="bookSpec" class="org.sun.Library.Bean.BookSpec" scope="page">
      
      <jsp:useBean id="author" class="org.sun.Library.Controler.Member.Author" scope="page">
       <jsp:useBean id="authorInfo" class="org.sun.Library.Bean.PersonInfo" scope="page">
       <jsp:setProperty name="authorInfo" property="name" value="${param.author}"/>
       <jsp:setProperty name="authorInfo" property="id" value="$[authorView[param.author]}"/>
       </jsp:useBean>
       
       <jsp:setProperty name="author" property="info" value="${pageScope.authorInfo}"/>
       </jsp:useBean>
      
       <jsp:useBean id="publisher" class="org.sun.Library.Controler.Member.Publisher" scope="page">
       <jsp:useBean id="publishInfo" class="org.sun.Library.Bean.PersonInfo" scope="page">
       <jsp:setProperty name="publishInfo" property="name" value="${param.publisher}"/>
       <jsp:setProperty name="publishInfo" property="id" value="${publisherView[param.publisher]}"/>
       </jsp:useBean>
      
       <jsp:setProperty name="publisher" property="info" value="${pageScope.publishInfo}"/>
       </jsp:useBean>
   
       <jsp:setProperty name="bookSpec" property="isbn" />
       <jsp:setProperty name="bookSpec" property="title"/>
       <jsp:setProperty name="bookSpec" property="subject"/>
       <jsp:setProperty name="bookSpec" property="price"/>
       <jsp:setProperty name="bookSpec" property="publishDate"/>
       <jsp:setProperty name="bookSpec" property="author" value="${pageScope.author}"/>
       <jsp:setProperty name="bookSpec" property="publisher" value="${pageScope.publisher}"/>
      </jsp:useBean>
   
       <jsp:useBean id="category" class="org.sun.Library.Controler.Book.Category" scope="page">
       <jsp:setProperty name="category" property="name" value="${param.category}"/>
       <jsp:setProperty name="category" property="id" value="${categoryView[param.category]}"/>
       </jsp:useBean>
     
     <jsp:setProperty name="book" property="copies" />
       <jsp:setProperty name="book" property="bookSpec" value="${pageScope.bookSpec}"/>
       <jsp:setProperty name="book" property="category" value="${pageScope.category}"/>
    
        </jsp:useBean>
       <c:redirect url="/addBook"/>
        </c:if>--%>
    </body>
</html>