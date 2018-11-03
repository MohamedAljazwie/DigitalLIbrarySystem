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
                          <form name="SearchFor" id="SearchFor" action="Search.jsp" method="post">
                    
                                 <iframe src="SearchFrameSet.jsp"  draggable="false" dropzone="false"  frameborder="0" style="width:900px;height:500px"></iframe>
                         
                </form>
             
  </div>
<!-- end #sidebar -->
</div>
<!-- end #page -->

</body>
</html>
