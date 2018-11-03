<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1256"%>

<%@ taglib prefix="library" uri="https://java.sun.com/jsp/library/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256"/>
    </head>
    <body>
    
  <jsp:useBean id="book" class="org.sun.Library.Controler.Book.Book" scope="session">
       
    
       <jsp:useBean id="bookSpec" class="org.sun.Library.Bean.BookSpec" scope="page">
      
      <jsp:useBean id="author" class="org.sun.Library.Controler.Member.Author" scope="page">
       <jsp:useBean id="authorInfo" class="org.sun.Library.Bean.PersonInfo" scope="page">
       <jsp:setProperty name="authorInfo" property="name" value="${param.author}"/>
       <jsp:setProperty name="authorInfo" property="id" value="${authorView[param.author]}"/>
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
       <c:redirect url="addBook"/>
    </body>
</html>