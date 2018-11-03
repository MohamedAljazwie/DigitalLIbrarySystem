<%@ page contentType="text/html;charset=windows-1256" errorPage="/errorPage.jsp" %>
<%@ taglib prefix="library" uri="https://java.sun.com/jsp/library/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
     
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256"/>
        <title>Digital Library System</title>
           <meta name='Author' content='Vamsi'/>
        <link rel='stylesheet' type='text/css' href='styles.css'/>
        
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
<script language='javascript' type='text/javascript' src='scripts/script.js'></script>
     <table width="100%" cellspacing="1" cellpadding="4" border="0">
        <c:if test="${! empty param.role}">
                  <library:search role="${param.role}"  type="${param.type}" value="${param.value}" >
                <c:set var="iterate" value="iterateed" scope="session"/>
                </library:search>
                </c:if>
            <tr>
                  <th id="browse_hed" width="36">Operations on Selected Records</th>
                <th id="browse_hed" width="4">
                    <img src="images/button_edit.png" width="12" height="13" border="0" alt='Edit' style='cursor:hand'
                         onclick='submitEditForm(SearchResulte,document.SearchResulte.row_ids)'/>
                </th>
                <th id="browse_hed" width="4">
                    <img src="images/button_drop.png" width="12" height="13" border="0" alt='Delete' style='cursor:hand'
                         onclick='submitBDropForm(SearchResulte,document.SearchResulte.row_ids)'/>
                </th>
                <th style='background:white' width="1"></th>
                <c:choose>
                    <c:when test="${param.start_index gt 1}">
                        <th id="browse_hed" width="5">
                            <img border="0" width="12" height="12" src="images/prev.gif" onclick='prev_form.submit()'
                                 style='cursor:hand' />
                        </th>
                        <form name="prev_form" action="SearchResult.jsp" method="post">
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
                        <th style='background:white' width="5"></th>
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
                    
                        <form name="next_form" action="SearchResult.jsp" method="post">
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
           <FORM NAME=edit_form METHOD=post ACTION='EditNorm' >
                            <INPUT TYPE=hidden NAME=table_name VALUE="  tableName  ">
                            <INPUT TYPE=hidden NAME=row_count  VALUE="  rowIds.length  ">
					
                            <DIV id=common_div ALIGN=center>
				    <table width="100%" align="left" cellspacing="1" cellpadding="4" border="0"
                                                   style='border-style:double; border-width:1px;  border-color:black'>
                                       <TR>
				  <c:forEach  items="${sessionScope.coulmnsNames}"  var="columnName">
						 <th  id="browse_th" width="100" height="33" bgcolor="#B79A36" class="style1">
                                                <div align="center">${columnName}</div>
                                                </th>
				</c:forEach>
					</TR>
				        <TR>
				<!--	for(int i=0;i<columnCount;i++)	{
						writer.print("<TD id=insert_td>" + typeName[i] +
									 "[" + colSizes[i]);
						
						if(decimals[i] > 0)	writer.println("," + decimals[i] + "]</TD>");
						else				writer.println("]</TD>");
					}-->
					</TR>
                                       <TR>			
                                        <c:forEach items="${sessionScope.coulmnsData}" var="rowData" begin="${pageScope.start_index}" end="${pageScope.end_index}">
                                          <tr>
                                                  <c:forEach items="${rowData.value}"  var="data">
                                                     
                                                             <TD id=insert_td width="100" height="33" bgcolor="#B79A36" class="style1">
                                                                       <INPUT TYPE=text id=insert_norm_inp align="center" 
                                                                       width="100" height="33" value="${data}" />
                                                            </td>
                                                           
                                                  </c:forEach>
                                           </tr>
                            </c:forEach>
						<!--for(int j=0;j<columnCount;j++)	{
							String data = null;
							try {	data = resultSet.getString(j+1);	}
							catch(Exception e)	{	data = "$DATA_READ_ERROR$"; }

							writer.println(	"<TD id=insert_td>" +
											"<INPUT TYPE=hidden NAME='row_" + i + "_prev_data' " +
											" VALUE=\"" + data + "\">" +
											"<INPUT TYPE=text id=insert_norm_inp NAME='row_" + i + 
											"_curr_data' MAXLENGTH='" + colSizes[j] + "' " + 
											"VALUE=\"" + data + "\"></TD>");
						}	
					} -->
					</TR></TABLE></DIV><BR>
				
                               </FORM>
                             <FORM>
                               <TABLE WIDTH=100% CELLSPACING=1 CELLPADDING=4 BORDER=0>
                                    <TR>
					    <TD WIDTH=20% ALIGN=left><IMG SRC="images/go1.jpg" 
									NAME=go1 WIDTH=30 HEIGHT=30 BORDER=0 STYLE='cursor:hand' 
									onMouseOut='putOff(this,13)' onMouseUp='putOff(this,13)' 
									onMouseDown='putOn(this,13)' onClick='edit_form.submit()' alt="Update">
									</TD>
					  <TD WIDTH=40%></TD>
					  <TD WIDTH=20% ALIGN=right><IMG SRC="images/go1.jpg" 
									NAME=go2 WIDTH=30 HEIGHT=30 BORDER=0 STYLE='cursor:hand' 
									onMouseOut='putOff(this,13)' onMouseUp='putOff(this,13)' 
									onMouseDown='putOn(this,13)' onClick='edit_form.submit()' alt="Update">
									</TD>
                                    </TR>
				</TABLE>
                            </form>
    </body>
</html>