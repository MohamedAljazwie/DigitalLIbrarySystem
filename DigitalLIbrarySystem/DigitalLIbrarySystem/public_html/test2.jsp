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
        <script type="text/javascript">
          checked = false;

          function checkedAll() {
              var aa = document.getElementById(book_1);
              if (checked == false) {
                  checked = true
              }
              //              else {
              //                  checked = false
              //              }
              for (var i = 0;i < aa.elements.length;i++) {
                  if (aa.elements[i].type == 'checkbox') {
                      aa.elements[i].checked = checked;
                  }
              }
          }
        </script>
        <script language="JavaScript">
        function CheckData(chkAll,chk) {
            var checed=chkAll.checked;
            if(checed==true)
            CheckAll(chk);
            else
            UnCheckAll(chk);
        }
  function CheckAll(chk) {
              for (i = 0;i < chk.length;i++)
              chk[i].checked = true;
          }

          function UnCheckAll(chk) {
              for (i = 0;i < chk.length;i++)
              chk[i].checked = false;
          }
          
          function submitEditForm(theForm,theList) {
	var sel = false;
	var len = theList.length;
	if(typeof(len) != 'undefined') {
		for(var i=0;i<len;i++) {
			if(theList[i].checked) {
				sel = true;
				break;
			}
		}
	}
	else sel = theList.checked;
	if(sel)	{
		theForm.action = "test2.jsp";
		theForm.submit();
	}
	else alert("Select the records that you want to edit.");
}
          //  End -->
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
           
                             <input  type="checkbox" name="Check_All" value="Check All"
                            onclick="CheckData(this,document.myform.check_list)"/>
                       
                 
                <form name="myform" action="test2.jsp" method="post">
                    <b>Scripts for Web design and programming</b>
                    <br/>
                    <input type="checkbox" name="check_list" value="1"/>
                    ASP
                    <br/>
                    <input type="checkbox" name="check_list" value="2"/>
                    PHP
                    <br/>
                    <input type="checkbox" name="check_list" value="3"/>
                    JavaScript
                    <br/>
                    <input type="checkbox" name="check_list" value="4"/>
                    HTML
                    <br/>
                    <input type="checkbox" name="check_list" value="5"/>
                    MySQL
                    <br/>
                    <input type="button" name="Check_All" value="Check All"
                           onclick="CheckAll(document.myform.check_list)"/>
                    <input type="button" name="Un_CheckAll" value="Uncheck All"
                           onclick="submitEditForm(myform,document.myform.check_list)"/>
                <input type="submit"  name="Sub"/>                     
                </form>
                  The Check List   
                <c:forEach  items="${paramValues.check_list}" var="list">
               <!--<div><strong>${paramValues.check_list}</strong></div>-->
                <div><strong>${list}</strong></div>
                </c:forEach>
                
            </div>
            <!-- end #sidebar -->
        </div>
        <!-- end #page -->
    </body>
</html>