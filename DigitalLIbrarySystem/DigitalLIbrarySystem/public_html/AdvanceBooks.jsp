<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" import="java.util.*,java.sql.*" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Digital Library System</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.style6 {color: #FFFFFF}
.style7 {color: #000000}
.style8 {color: #000000; font-weight: bold; }
a:link {
	color: #FF0000;
}
-->
</style>
 <script language="javascript">
      function fun()
      {
          if(document.addbook.title.value=="" || document.addbook.author.value=="" || document.addbook.bookprice.value=="")
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
		<h1><jsp:include page="header.html"/> 
	  </h1>
		
  </div>
	<div id="menu">
        <jsp:include page="useroptions.html"/> 
	</div>
</div>
<div id="page">
  <!-- end #content -->
<div id="sidebar">
		<div id="news" class="boxed1">
			<blockquote>
			  <blockquote>
			    <h2 class="title">Advance Bookings</h2>
		      </blockquote>
		  </blockquote>
	  </div>
        <table width="576" border="0" align="center">
          <tr>
            <th width="54" bgcolor="#B59E39"><span class="style6">ISBN No</span></th>
            <th width="73" bgcolor="#B59E39"><span class="style6">Book ID</span></th>
            <th width="105" bgcolor="#B59E39"><span class="style6">Student ID</span></th>
            <th width="113" bgcolor="#B59E39"><span class="style6">Booked Date</span></th>
            <th width="130" bgcolor="#B59E39"><span class="style6">ToDay</span></th>
            <th width="29" bgcolor="#B59E39"><span class="style6"></span></th>
            <th width="42" bgcolor="#B59E39"><span class="style6"></span></th>
          </tr>
         <tr>
            <td bgcolor="#F7AF9B"><div align="center" class="style7"><strong></strong></div></td>
            <td bgcolor="#F7AF9B"><div align="center" class="style8"></div></td>
            <td bgcolor="#F7AF9B"><div align="center" class="style8"></div></td>
            <td bgcolor="#F7AF9B"><div align="center" class="style8"></div></td>
            <td bgcolor="#F7AF9B"><div align="center" class="style8"></div></td>
   
            <td width="29" bgcolor="#F7AF9B"><a href="issueadvancebook.jsp?bookid=0&stuid=0&isbn=0" class="style8">Issue</a></td>
            <td width="42" bgcolor="#F7AF9B"><a href="deleteadvancebook.jsp?bookid=0&stuid=0&isbn=0" class="style8">Delete</a></td>

          </tr>
         
        </table>
        </center>
        </div>
<!-- end #sidebar -->
</div>
<!-- end #page -->
<div id="footer">
	<p>&nbsp;</p>
</div>
</body>
</html>
