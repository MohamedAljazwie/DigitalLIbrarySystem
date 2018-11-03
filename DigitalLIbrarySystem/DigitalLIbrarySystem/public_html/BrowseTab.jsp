<%@ page contentType="text/html;charset=windows-1256"%>
<%@ taglib prefix="library" uri="https://java.sun.com/jsp/library/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256"/>
    </head>
    <body>
        <br/>
        <table width="100%" cellspacing="1" cellpadding="4" border="0">
           <tr>
            <th> The Start index Count is ${param.start_index}</th>
            </tr>
            <tr>
            <th> The records per page Count is ${param.records_per_page}</th>
            </tr>
            <tr>
            <th> The Row Count is ${param.row_count}</th>
            </tr>
            <tr>
            <tr>
                <th id="browse_hed" width="36">Operations on Selected Records</th>
                <th id="browse_hed" width="4">
                    <img src="images/button_edit.png" width="12" height="13" border="0" alt='Edit' style='cursor:hand'
                         onclick='submitEditForm(action_form,action_form.row_ids)'/>
                </th>
                <th id="browse_hed" width="4">
                    <img src="images/button_drop.png" width="12" height="13" border="0" alt='Delete' style='cursor:hand'
                         onclick='submitBDropForm(action_form,action_form.row_ids)'/>
                </th>
                <th style='background:white' width="1"></th>
                <c:choose>
                    <c:when test="${param.start_index gt 1}">
                        <th id="browse_hed" width="5">
                            <img border="0" width="12" height="12" src="images/prev.gif" onclick='prev_form.submit()'
                                 style='cursor:hand' />
                        </th>
                        <form name="prev_form" method="post" action='BrowseTab.jsp'>
                            <input type="hidden" name="row_count" value='${param.row_count}'/>
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
                    
                        <form name="next_form" method="post" action='BrowseTab.jsp'>
                            <input type="hidden" name="row_count" value='${param.row_count}'/>
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
    </body>
</html>