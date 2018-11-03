<%@ page contentType="text/html;charset=windows-1256"%>
<%@ page import="java.lang.System"%>
<%@ taglib prefix="library" uri="https://java.sun.com/jsp/library/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256"/>
    </head>
    <body>
     <jsp:useBean id="returnBook" class="org.sun.Library.Controler.Book.ReturnBook" scope="session">
              
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
                                                             <jsp:setProperty name="bookSpec" property="title" value="${sessionScope.bookTitile}"/>
                                                       </jsp:useBean> <!-- end spec bean-->
                                        <jsp:setProperty name="book" property="bookSpec" value="${pageScope.bookSpec}"/>
                                        <jsp:setProperty name="book" property="id" param="bookID"/>
                                        <c:remove var="bookTitile" scope="session"/>
                                </jsp:useBean> <!-- end book bean-->
                         <jsp:setProperty name="returnBook" property="book" value="${pageScope.book}"/>
                         <jsp:setProperty name="returnBook" property="student" value="${pageScope.student}"/>
                         <jsp:setProperty name="returnBook" property="issueDate"/>
                         <jsp:setProperty name="returnBook" property="returnDate"/>
                         <jsp:setProperty name="returnBook" property="returnedDate"/>
                         <jsp:setProperty name="returnBook" property="nots"/>
                </jsp:useBean> <!--  end issue bean-->
                
                <c:redirect url="returnbook?isbn=${pageScope.bookSpec.isbn}"/>
    
    </body>
</html>