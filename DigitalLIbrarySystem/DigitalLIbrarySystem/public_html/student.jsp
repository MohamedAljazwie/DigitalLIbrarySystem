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

 <tr>
        <td width="231">
            <span class="style5">National ID</span>
        </td>
        <td width="360" height="20">
            <input type="text" name="nationalID" maxlength="50" size="30" id="nationalID" align="middle"
                   style="width:inherit; height:inherit;"
                   value="${sessionScope.student.nationalID}"/>
        </td>
        <td align="center" width="332" class="style2">
            <strong>
                <c:choose>
                    <c:when test="${!empty param.nationalID}">
                        <c:out value="${param.nationalID}"/>
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
    <jsp:include page="/personalInfo.jsp" flush="true"/>
    <tr>
        <td width="231">
            <span class="style5">User Name</span>
        </td>
        <td width="360" height="20">
            <input type="text" name="userName" maxlength="50" size="30" id="userName" align="middle"
                   style="width:inherit; height:inherit;"
                   value="${sessionScope.student.access.userName}"/>
        </td>
        <td align="center" width="332" class="style2">
            <strong>
                <c:choose>
                    <c:when test="${!empty sessionScope.studentError.access.userName}">
                        <c:out value="${sessionScope.studentError.access.userName}"/>
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
            <span class="style5">Password</span>
        </td>
        <td width="360" height="20">
            <input type="password" name="password" maxlength="50" size="30" id="password" align="middle"
                   style="width:inherit; height:inherit;"
                   vlaue="${sessionScope.student.access.password}"/>
        </td>
        <td align="center" width="332" class="style2">
            <strong>
                <c:choose>
                    <c:when test="${!empty sessionScope.studentError.access.password}">
                        <c:out value="${sessionScope.studentError.access.userName}"/>
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
        </tr>
      <tr>
        <td width="231">
            <span class="style5">Security Question</span>
        </td>
        <td width="360" height="20">
           <select name="question" style="width: 300px;">
                                    <option value="select Question">select Question</option>
                                   <option value="What is  your uncle  Name">What is  your uncle  Name</option>
                                   <option value="What  is your favorte hoppies">What  is your favorte hoppies</option>
                                </select>
        </td>
        <td align="center" width="332" class="style2">
            <strong>
                <c:choose>
                    <c:when test="${!empty param.question}">
                        <c:out value="${param.question}"/>
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
            <span class="style5">Answer</span>
        </td>
        <td width="360" height="20">
            <input type="text" name="answer" maxlength="50" size="30" id="answer" align="middle"
                   style="width:inherit; height:inherit;"/>
        </td>
        <td align="center" width="332" class="style2">
            <strong>
                <c:choose>
                    <c:when test="${!empty param.answer}">
                        <c:out value="${param.answer}"/>
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
  
