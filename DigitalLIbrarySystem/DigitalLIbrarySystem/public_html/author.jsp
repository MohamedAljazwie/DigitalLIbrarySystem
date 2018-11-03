<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1256"%>
<%@ taglib prefix="library" uri="https://java.sun.com/jsp/library/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<jsp:include page="/personalInfo.jsp" flush="true"/>
<tr>
    <td width="231">
        <span class="style5">Qulefication</span>
    </td>
    <td width="360" height="20">
        <input type="text" name="qulefication1" maxlength="50" size="30" id="qulefication1" align="middle"
               style="width:inherit; height:inherit;" value="${param.qulefication}"/>
    </td>
    <td align="center" width="332" class="style2">
        <strong>
            <c:choose>
                <c:when test="${!empty param.qulefication}">
                    <c:out value="${param.userName}"/>
                </c:when>
                <c:otherwise>
                    <strong>Required</strong>
                </c:otherwise>
            </c:choose></strong>
    </td>
</tr>
<tr>
    <td colspan="3">
        <br/>
    </td>
</tr>
<tr>
    <td width="231">
        <span class="style5">Qulefication</span>
    </td>
    <td colspan="2"  width="360" height="20">
        <input type="text" name="qulefication2" maxlength="50" size="30" id="qulefication2" align="middle"
               style="width:inherit; height:inherit;" value="${param.qulefication}"/>
    </td>
</tr>
<tr>
    <td colspan="3">
        <br/>
    </td>
</tr>
<tr>
    <td width="231">
        <span class="style5">Qulefication</span>
    </td>
    <td  colspan="2" width="360" height="20">
        <input type="text" name="qulefication3" maxlength="50" size="30" id="qulefication3" align="middle"
               style="width:inherit; height:inherit;" value="${param.qulefication}"/>
    </td>
</tr>
<tr>
    <td colspan="3">
        <br/>
    </td>
</tr>