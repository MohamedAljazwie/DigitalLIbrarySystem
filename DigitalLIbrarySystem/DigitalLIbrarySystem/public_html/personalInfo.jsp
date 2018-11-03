<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1256"%>
<%@ taglib prefix="library" uri="https://java.sun.com/jsp/library/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256"/>
<title>Person Information</title>
<meta name="keywords" content=""/>
<meta name="description" content=""/>
<link href="default.css" rel="stylesheet" type="text/css"/>

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
            <span class="style5">Name</span>
        </td>
        <td width="360" height="20">
            <input type="text" name="name" maxlength="50" size="30" id="name" align="middle"
                   style="width:inherit; height:inherit;"
                   value="${sessionScope.info.name}" />
        </td>
        <td align="center" width="332" class="style2">
            <strong>
                <c:choose>
                    <c:when test="${! empty sessionScope.infoError.name}">
                        <c:out value="${sessionScope.infoError.name}"/>
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
            <span class="style5">Email</span>
        </td>
        <td width="360" height="20">
            <input type="text" name="email" maxlength="50" size="30" id="email" align="middle"
                   style="width:inherit; height:inherit;"
                   value="${sessionScope.info.email}" />
        </td>
        <td align="center" width="332" class="style2">
            <strong>
                <c:choose>
                    <c:when test="${! empty sessionScope.infoError.email}">
                        <c:out value="${sessionScope.infoError.email}"/>
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
            <span class="style5">Address</span>
        </td>
        <td width="360" >
          <textarea name="address" id="address"  cols="20" rows="8"
          value="${sessionScope.info.address}">
          </textarea>
        
        </td>
        <td></td>
    </tr>
     
    <tr>
        <td colspan="3">
            <br/>
        </td>
    </tr>
     
    <tr>
        <td width="231">
            <span class="style5">Primary Phone</span>
        </td>
        <td width="360" height="20">
            <input type="text" name="phone1" maxlength="50" size="30" id="phone1" align="middle"
                   style="width:inherit; height:inherit;"
                  />
        </td>
        <td align="center" width="332" class="style2">
            <strong>
                <c:choose>
                    <c:when test="${!empty param.Phone1}">
                        <c:out value="${param.Phone1}"/>
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
            <span class="style5">Second Phone</span>
        </td>
        <td width="360" height="20">
            <input type="text" name="phone2" maxlength="50"  size="30" id="phone2" align="middle"
                   style="width:inherit; height:inherit;"/>
        </td>
        <td></td>
    </tr>
     
    <tr>
        <td colspan="3">
            <br/>
        </td>
    </tr>
     
    <!--<tr>
                            <td width="231">
                                <span class="style5">Quantity(Copies)</span>
                            </td>
                            <td width="360" height="20">
                                <input type="number" name="isbn" size="20" id="isbn" align="middle"
                                       style="width:inherit; height:inherit;"/>
                            </td>
                            <td align="center" width="332" class="style2">
                                <strong>
                                    <c:choose>
                                        <c:when test="${!empty param.copies}">
                                            <c:out value="${param.copies}"/>
                                        </c:when>
                                        <c:otherwise>
                                            <strong>Required</strong>
                                        </c:otherwise>
                                    </c:choose></strong>
                            </td>
                        </tr>-->
     
    <tr>
        <td colspan="3">
            <br/>
        </td>
    </tr>