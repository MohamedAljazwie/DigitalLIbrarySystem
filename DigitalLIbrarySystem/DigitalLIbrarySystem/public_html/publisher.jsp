<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1256"%>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256"/>
<title>Person Information</title>
<meta name="keywords" content=""/>
<meta name="description" content=""/>
<link href="default.css" rel="stylesheet" type="text/css"/>
<script language="javascript" type="text/javascript" src="scripts/datetimepicker.js">
  //Date Time Picker script- by TengYong Ng of http://www.rainforestnet.com
  //Script featured on JavaScript Kit (http://www.javascriptkit.com)
  //For this script, visit http://www.javascriptkit.com 
</script>
<style type="text/css">
<!--        .style5 {
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
<jsp:include page="/personalInfo.jsp"/>