<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1256"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256"/>
    </head>
    <body align="center">
        <form name="browseform" method="post" action='BrowseTab.jsp'>
            <table width="100%" cellspacing="1" cellpadding="4" border="0" style='border-style:double; border-width:1px; 
									border-color:black'>
                <tr>
                    <th id="common_th" colspan="2">TABLE DISPLAY SETTINGS</th>
                </tr>
                 
                <tr>
                    <td width="55">
                        <table width="100%" cellspacing="1" cellpadding="4" border="0" style='border-style:double; border-width:1px; 
									border-color:black'>
                            <tr>
                                <th id="common_hed">No.of Records Per Page</th>
                                <td id="common_td">
                                    <input name="records_per_page" type="text" style='background:azure;width:145px'
                                           value="11"/>
                                </td>
                            </tr>
                             
                            <tr>
                                <th id="common_hed">Starting From Record</th>
                                <td id="common_td">
                                    <input name="start_index" type="text" style='background:azure;width:145px'
                                           value="1"/>
                                </td>
                            </tr>
                               <tr>
                                <th id="common_hed">Row count </th>
                                <td id="common_td">
                                    <input name="row_count" type="text" style='background:azure;width:145px'
                                           value="107"/>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                 
                <tr>
                    <td align="right">
                        <img name="pic11" src="images/reset1.jpg" border="0" width="70" height="24"
                             onmousedown='putOn(this,11)' onmouseup='putOff(this,11)' onmouseout='putOff(this,11)'
                             onclick='browseform.reset()' style='cursor:hand'/>
                    </td>
                    <td align="left">
                        <img name="pic12" src="images/fetch1.jpg" border="0" width="70" height="24"
                             onmousedown='putOn(this,12)' onmouseup='putOff(this,12)' onmouseout='putOff(this,12)'
                             onclick='browseform.submit()' style='cursor:hand'/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>