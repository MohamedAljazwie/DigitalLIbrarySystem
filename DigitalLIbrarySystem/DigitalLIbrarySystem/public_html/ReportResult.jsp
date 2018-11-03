<%@ page contentType="text/html;charset=windows-1256"%>
<%@ taglib prefix="library" uri="https://java.sun.com/jsp/library/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
 
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256"/>
        <title>Digital Library System</title>
           <meta name='Author' content='Vamsi'/>
        <link rel='stylesheet' type='text/css' href='styles.css'/>
        <script language='javascript' type='text/javascript' src='scripts/script.js'></script>
        <meta name="keywords" content=""/>
        <meta name="description" content=""/>
        <link href="default.css" rel="stylesheet" type="text/css"/>
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
          //  End -->
        </script>
    </head>
    <body onload='loadImages()' bgcolor="#ffffff" link="black" alink="black" vlink="black">
     <TABLE WIDTH=100% CELLSPACING=1 CELLPADDING=4 BORDER=0>
        <c:if test="${! empty param.role}">
                <library:viewAll role="${param.role}" reportDate="${param.reportDate}">
                <c:set var="iterate" value="iterateed" scope="session"/>
                </library:viewAll>
                </c:if>
            
            <tr>
                <th id="browse_hed" width="36">Operations on Selected Records</th>
                <th id="browse_hed" width="4">
                    <img src="images/button_edit.png" width="12" height="13" border="0" alt='Edit' style='cursor:hand'
                         onclick='submitEditForm(ReportResulte,document.ReportResulte.row_ids)'/>
                </th>
                <th id="browse_hed" width="4">
                    <img src="images/button_drop.png" width="12" height="13" border="0" alt='Delete' style='cursor:hand'
                         onclick='submitBDropForm(ReportResulte,document.ReportResulte.row_ids)'/>
                </th>
                <th style='background:white' width="1"></th>
                <c:choose>
                    <c:when test="${param.start_index gt 1}">
                        <th id="browse_hed" width="5">
                            <img border="0" width="12" height="12" src="images/prev.gif" onclick='prev_form.submit()'
                                 style='cursor:hand' />
                        </th>
                        <form name="prev_form" action="ReportResult.jsp" method="post">
                        <c:choose>
                        <c:when test="${empty requestScope.row_count}">
                            <input type="hidden" name="row_count" value= '${param.row_count}'/>
                            </c:when>
                            <c:otherwise>
                             <input type="hidden" name="row_count" value= '${requestScope.row_count}'/>
                            </c:otherwise>
                            </c:choose>
                            <input type="hidden" name="records_per_page" value="${param.records_per_page}"/>
                              
                            <c:choose>
                                <c:when test="${param.start_index gt param.records_per_page}">
                                    <input type="hidden" name="start_index"
                                           value='${param.start_index - param.records_per_page}'/>
                                </c:when>
                                <c:otherwise>
                                    <input type="hidden" name="start_index" value='1'/>
                                </c:otherwise>
                            </c:choose>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <th style='background:white' width=5></th>
                    </c:otherwise>
                </c:choose>
                <th id="browse_hed" width="45">
                    Displaying Records From
                    ${param.start_index}
                    -
                    <c:choose>
                        <c:when test="${param.start_index + param.records_per_page -1 ge param.row_count}">
                            ${param.row_count}
                        </c:when>
                        <c:otherwise>
                            ${param.start_index + param.records_per_page -1}
                        </c:otherwise>
                    </c:choose>
                </th>
                <c:choose>
                    <c:when test="${param.start_index + param.records_per_page -1 lt param.row_count}">
                        <th id="browse_hed" width="5">
                            <img border="0" width="12" height="12" src="images/next.gif" style='cursor:hand'
                                 onclick='next_form.submit()'/>
                        </th>
                    
                        <form name="next_form" action="ReportResult.jsp" method="post">
                            <c:choose>
                        <c:when test="${empty requestScope.row_count}">
                            <input type="hidden" name="row_count" value= '${param.row_count}'/>
                            </c:when>
                            <c:otherwise>
                             <input type="hidden" name="row_count" value= '${requestScope.row_count}'/>
                            </c:otherwise>
                            </c:choose>
                            <input type="hidden" name="records_per_page" value='${param.records_per_page}'/>
                            
                            <input type="hidden" name="start_index"
                                   value='${param.start_index + param.records_per_page}'/>
                           
                        </form>
                    </c:when>
                    <c:otherwise>
                        <th style='background:white' width="5"></th>
                    </c:otherwise>
                </c:choose>
            </tr>
        
        </table>
    <BR>
           <form name="ReportResulte" method="post" action='#'>
             <DIV id=common_div ALIGN=center>
            <table  align="left" cellspacing="1" cellpadding="4"
                   style='border-style:double; border-width:1px;  border-color:black'>
             <TR><TD>
                    <table width="1500" align="left" cellspacing="1" cellpadding="4" border="0"
                             style='border-style:double; border-width:1px;  border-color:black'>
                <tr>
                      <th id="common_th" colspan="${sessionScope.colspan +1}" align="center">
                        <strong>TABLE DISPLAY SETTINGS</strong>
                    </th>
                  
                </tr>
               
                    <c:if test="${ ! empty sessionScope.iterate}">
                           <c:choose>
                                                 <c:when test="${param.start_index eq 1}">
                                                 <c:set var="start_index" value="0" scope="page"/>
                                                 </c:when>
                                                 <c:otherwise>
                                                 <c:set var="start_index" value="${param.start_index}" scope="page"/>
                                                 </c:otherwise>
                         </c:choose>
                          <c:choose>
                                                 <c:when test="${param.start_index + param.records_per_page -1 lt 0}">
                                                 <c:set var="end_index" value="-1" scope="page"/>
                                                 </c:when>
                                                 <c:otherwise>
                                                 <c:set var="end_index" value="${param.start_index + param.records_per_page -1}" scope="page"/>
                                                 </c:otherwise>
                      </c:choose>
      <c:if test="${pageScope.end_index ge 0}">
                                     
                                     
                             <input type="hidden" name="row_count" value= '${requestScope.row_count}'/>
                           <tr>  
                        <TH  width="15" height="33" bgcolor="#B79A36" class="style1" id="browse_th">
                        <INPUT TYPE="checkbox" NAME="chk_all"
                                 onclick="CheckData(this,document.ReportResulte.row_ids)" />
			</TH>
                       
                       <c:forEach  items="${sessionScope.coulmnsNames}"  var="columnName">
                        
                        <th  id="browse_th" width="150" height="33" bgcolor="#B79A36" class="style1">
                            <div align="center">${columnName}</div>
                        </th>
                        </c:forEach>
                        </tr>
                        </table></td></tr>
                        <TR><TD>
                        
                            <table width="1500" align="left" cellspacing="1" cellpadding="4" border="0"
                                                 style='border-style:double; border-width:1px;  border-color:black'>
            
                        <c:forEach items="${sessionScope.coulmnsData}" var="rowData" begin="${pageScope.start_index}" end="${pageScope.end_index}">
                                          <tr>
                                          <td id="browse_td" width="15" height="33" bgcolor="#B79A36" class="style1">
                                             <INPUT type="checkbox" name="row_ids" VALUE="${rowData.key}"/>
                                             </td>
                                          <c:forEach items="${rowData.value}"  var="data">
                                             
                                                     <td id="browse_td" width="150" height="33" bgcolor="#B79A36" class="style1">
                                                                 <div align="center">${data}</div>
                                                    </td>
                                                   
                                          </c:forEach>
                                           </tr>
                        </c:forEach>
                     
                        </table>
                    </td></tr>
                         </c:if>
                            </c:if>
            </table></div><BR>
        </form>
    </body>
</html>