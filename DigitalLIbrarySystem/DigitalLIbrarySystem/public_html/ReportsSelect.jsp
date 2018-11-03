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
        <script language="javascript"> 
                    function LoadPage(){ 
                                                 //   document.getElementById('SearchFor').src = '<a herf="SearchResult.jsp?role=${param.Role}"  target="SearchResult"></a>';
                                                   //onchange="window.open(this.options[this.selectedIndex].value, 'destination');
                                         //   this.selectedIndex = 0;"
                                         var role=document.SearchFor.Role.options[document.SearchFor.Role.selectedIndex].value;
                                       var reportDate=document.SearchFor.reportDate.value;
                                    //   var fromDate=document.searchFor.fromDate.value;
                                     //  var toDate=document.searchFor.toDate.value;
                                       //+"&&fromDate="+fromDate+"&&toDate="+toDate
                                        window.open("ReportResult.jsp?role="+role+"&&reportDate="+reportDate+"&&records_per_page=11&&start_index=1&&row_count=30", 'reportResult');
                                           
                    }
           
</script> 

<script type="text/javascript">
            function loadFrame()
            {
          //  var select_value=document.getElementById("Role").value;

            }
            </script>
        <style type="text/css">
<!--                .style1 {
                    color: #FF0000;
                    font-weight: bold;
                    font-size: 14px;
                }
-->
            </style>
    </head>
    <body  onLoad='loadImages()' BGCOLOR=#ffffff  link=black alink=black vlink=black>
        <div id="page">
            <form name="SearchFor" id="SearchFor" action="#" method="post">
                   <table border="0" align="left" width="100%">
                        <tr>
                            <td width="231">
                                <span class="style5">Report  For</span>
                            </td>
                            </tr>
                            <tr>
                            <td width="77">
                                <select name="Role" id="Role" style="width: 150px;"  onchange="LoadPage()">
                                    <option value="" selected="selected">Report For</option>
                                    <option <c:if test="${param.Role eq 'Book'}">selected="selected"</c:if> value="Book">Book</option>
                                    <option <c:if test="${param.Role eq 'IssuseBook'}">selected="selected"</c:if> value="IssuseBook"  >Issue Book</option>
                                    <option <c:if test="${param.Role eq 'ReturnBook'}">selected="selected"</c:if> value="ReturnBook"  >Return Book</option>
                                    <option <c:if test="${param.Role eq 'Student'}">selected="selected"</c:if> value="Student"  >Fines</option>
                                    <option <c:if test="${param.Role eq 'Mails'}">selected="selected"</c:if> value="Mails"  >Mails</option>
                                </select>
                               
                            </td>
                            
                        </tr>
                        <tr><td><br/></td></tr>
                             <tr>
                            <td width="231">
                                <span class="style5">Report  Date  :</span>
                            </td>
                            </tr>
                            <tr>
                            <td width="77"> 
                            <input type="radio" name="reportDate" id="reportDate" value="Daily"  <c:if test="${param.reportDate eq 'Daily'}">checked="checked"</c:if> onclick="this.form.submit();LoadPage()" /> <label>Daily</label> 
                           </td>
                           </tr>
                           <tr>
                           <td>
                            <input type="radio" name="reportDate" id="reportDate"  value="Weekly" <c:if test="${param.reportDate eq 'Weekly'}">checked="checked"</c:if>  onclick="this.form.submit();LoadPage()"/> <label>Weakly</label> 
                            </td>
                            </tr>
                            <tr>
                           <td>
                            <input type="radio" name="reportDate" id="reportDate" value="Monthly"  <c:if test="${param.reportDate eq 'Monthly'}">checked="checked"</c:if> onclick="this.form.submit();LoadPage()"/> <label>Monthly</label> 
                            </td>
                            </tr>
                             <tr>
                           <td>
                            <input type="radio" name="reportDate" id="reportDate" value="Others" <c:if test="${param.reportDate eq 'Others'}">checked="checked"</c:if>  onclick="this.form.submit()"/> <label>Others</label> 
                            </td>
                            </tr>
                         <tr><td><br/></td></tr>
                             <c:if test="${param.reportDate eq 'Others'}">
                            <tr>
                                <td width="231">
                                    <span class="style5">From :</span>
                                </td>
                                </tr>
                                <tr>
                                <td width="150" height="25">
                                    <input type="text" name="fromDate"  maxlength="50" size="50" id="fromDate"
                                           align="middle" style="width:inherit; height:inherit;"
                                           value="${param.fromDate}"/>
                                </td>
                            </tr>
                                  <tr>
                                <td width="231">
                                    <span class="style5">To  :</span>
                                </td>
                                </tr>
                                <tr>
                                <td width="150" height="25">
                                    <input type="text" name="toDate"  maxlength="50" size="50" id="toDate"
                                           align="middle" style="width:inherit; height:inherit;"
                                           value="${param.toDate}"/>
                                </td>
                            </tr>
                            <tr><td><br/></td></tr>
                              <tr>
                                <td align="left">
                                    <input type="button"  name="Report" id="Report" value="Get  Results"
                                           style="width: 100px;" onclick="this.form.submit();LoadPage()"/>
                                </td>
                            </tr>
                            </c:if>
                             <tr><td><br/></td></tr>
                             
                    </table>
                </form>
<!-- end #sidebar -->
</div>
<!-- end #page -->

</body>
</html>
