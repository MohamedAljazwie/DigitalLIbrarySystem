<%@ page contentType="text/html;charset=windows-1256"%>
<%@ page import="java.lang.System"%>
<%@ taglib prefix="library" uri="https://java.sun.com/jsp/library/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256"/>
        <meta NAME='Author' CONTENT='Vamsi'/>
        <LINK REL='stylesheet' TYPE='text/css' HREF='styles.css'/>
        <title>Digital Library System</title>
        <meta name="keywords" content=""/>
        <meta name="description" content=""/>
        <link href="default.css" rel="stylesheet" type="text/css"/>
        <SCRIPT LANGUAGE='javascript' TYPE='text/javascript'  SRC='Scripts/script.js'></SCRIPT>
        
        <style type="text/css">
<!--                .style1 {
                    color: #FF0000;
                    font-weight: bold;
                    font-size: 14px;
                }
-->
            </style>
    </head>
    <body onLoad='loadImages()' BGCOLOR=#ffffff link=black alink=black vlink=black>
       
                <div id="news" class="boxed1">
                    <blockquote>
                        <blockquote>
                            <h1 class="title"><Strong>Update Data Search Resulte</strong></h1>
                        </blockquote>
                    </blockquote>
                </div>
                    <div align="center" class="style1">
                        <c:if test="${! empty param.status}">
                            <c:out value="${param.status}"/>
                          </c:if>
                    </div>
                    <BR/>
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
                                
                        <FORM NAME=edit_form METHOD=post ACTION='EditNorm'  >
                             <DIV id=common_div ALIGN=center>
                            <INPUT TYPE=hidden NAME=table_name VALUE="  tableName  ">
                            <INPUT TYPE=hidden NAME=row_count  VALUE="  rowIds.length  ">
					
                           
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
                                <c:forEach  items="${paramValues.check_list}" var="list">
                      
                                              <c:forEach items="${sessionScope.coulmnsData[list]}" var="rowData">
                                                          <tr>
                                                                      <c:forEach items="${rowData.value}"  var="data">
                                                                         
                                                                                 <TD id=insert_td width="100" height="33" bgcolor="#B79A36" class="style1">
                                                                                           <INPUT TYPE=text id=insert_norm_inp align="center" 
                                                                                           width="100" height="33" value="${data}" />
                                                                                </td>
                                                                               
                                                                      </c:forEach>
                                                           </tr>
                                            </c:forEach>
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
					</TR></TABLE></DIV>
				
                               </FORM>
                           
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
                           
          </body>
    </html>
                                        
                                       