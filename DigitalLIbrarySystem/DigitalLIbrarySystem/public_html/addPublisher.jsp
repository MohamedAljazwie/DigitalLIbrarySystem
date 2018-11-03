<!DOCTYPE html>
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
        <script language="javascript" type="text/javascript" src="scripts/datetimepicker.js">
          //Date Time Picker script- by TengYong Ng of http://www.rainforestnet.com
          //Script featured on JavaScript Kit (http://www.javascriptkit.com)
          //For this script, visit http://www.javascriptkit.com 
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
              if (document.addbook.title.value == "" || document.addbook.author.value == "" || document.addbook.bookprice.value == "") {
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
                            <h2 class="title">Add Publisher</h2>
                        </blockquote>
                    </blockquote>
                </div>
                <form action="addbook" name="addbook" method="post" onsubmit="return fun()">
                    <table border="0" align="left" width="100%">
               <jsp:include page="/publisher.jsp" flush="true"/>  
                  
                        <tr>
                            <td colspan="2" align="left">
                                <input type="submit" value="Add Publisher" style="width: 200px;"/>
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
         
        <br/><br/><!-- end #page -->
        <div id="footer">
            <p>&nbsp;</p>
        </div>
    </body>
</html>