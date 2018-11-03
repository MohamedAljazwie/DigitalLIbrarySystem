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
                                         window.open("SearchResult.jsp?role="+role+"&&records_per_page=11&&start_index=1&&row_count=30", 'searchResult');
                                           
                    }
                  function LoadPersons(){ 
                                         var role=document.SearchFor.personSearch.options[document.SearchFor.personSearch.selectedIndex].value;
                                         window.open("SearchResult.jsp?role="+role+"&&records_per_page=11&&start_index=1&&row_count=30", 'searchResult');
                   }
                    
                    function LoadBooks() {
                                         var role=document.SearchFor.Role.options[document.SearchFor.Role.selectedIndex].value;
                                         var type=document.SearchFor.bookSearch.options[document.SearchFor.bookSearch.selectedIndex].value;
                                         var value=document.SearchFor.valueSearched.value
                                         window.open("SearchResult.jsp?role="+role+"&&type="+type+"&&value="+value+"&&records_per_page=11&&start_index=1&&row_count=30", 'searchResult');
                    }
                      function LoadspecficPerson() {
                                         var role=document.SearchFor.personSearch.options[document.SearchFor.personSearch.selectedIndex].value;
                                         var type=document.SearchFor.columnSearch.value;
                                         var value=document.SearchFor.valueSearched.value
                                         window.open("SearchResult.jsp?role="+role+"&&type="+type+"&&value="+value+"&&records_per_page=11&&start_index=1&&row_count=30", 'searchResult');
                    }
                    function getName() {
                        var role=document.SearchFor.personSearch.options[document.SearchFor.personSearch.selectedIndex].value;
                        return role;
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
                                <span class="style5">Search For</span>
                            </td>
                            </tr>
                            <tr>
                            <td width="77">
                                <select name="Role" id="Role" style="width: 150px;"  onchange="this.form.submit();LoadPage()">
                                    <option value="" selected="selected">Search For</option>
                                    <option <c:if test="${param.Role eq 'Person'}">selected="selected"</c:if> value="Person">Person</option>
                                    <option <c:if test="${param.Role eq 'Book'}">selected="selected"</c:if> value="Book"  >Book</option>
                                    
                                </select>
                               
                            </td>
                            
                        </tr>
                        <tr><td><br/></td></tr>
                        <c:if test="${param.Role eq 'Person'}">
                        <tr>
                            <td width="231">
                                <span class="style5">Slect Person</span>
                            </td>
                            </tr>
                            <tr>
                            <td width="77">
                                <select name="personSearch"  id ="personSearch" style="width: 150px;" onchange="LoadPersons()">
                                    <option selected="selected" value="">Slect    Person</option>
                                    <option value="Student">Student</option>
                                    <option value="Author">Author</option>
                                     <option value="Publisher">Publisher</option>
                                </select>
                            </td>
                            </tr>
                             <tr><td><br/></td></tr>
                             <tr>
                            <td width="231">
                                <span class="style5">Search By :</span>
                            </td>
                            </tr>
                            <tr>
                            <td width="77"> 
                            <input type="radio" name="columnSearch" id="columnSearch" value="Name" /> <label>By Name</label> 
                           </td>
                           </tr>
                           <tr>
                           <td>
                            <input type="radio" name="columnSearch" id="columnSearch" value="Address"/> <label>By Address</label> 
                            </td>
                            </tr>
                            </c:if>
                        <tr><td><br/></td></tr>
                        <c:if test="${param.Role eq 'Book'}">
                        <tr>
                            <td width="231">
                                <span class="style5">Select Type</span>
                            </td>
                            </tr>
                            <tr>
                            <td width="77">
                                <select name="bookSearch" id="bookSearch" style="width: 150px;" onchange="">
                              
                                    <option  selected="selected" value="">Select   Type</option>
                                    <option value="isbn">isbn</option>
                                    <option value="title">title</option>
                                    <option value="Author">Author</option>
                                </select>
                            </td>
                            </tr>
                            </c:if>
                            <tr><td><br/></td></tr>
                            <c:if test="${! empty param.Role}">
                            <tr>
                                <td width="231">
                                    <span class="style5">Search By</span>
                                </td>
                                </tr>
                                <tr>
                                <td width="150" height="25">
                                    <input type="text" name="valueSearched"  maxlength="50" size="50" id="valueSearched"
                                           align="middle" style="width:inherit; height:inherit;"
                                           value="${sessionScope.valueSearched}"/>
                                </td>
                            </tr>
                            </c:if>
                             <tr><td><br/></td></tr>
                             <c:choose>
                             <c:when test="${param.Role eq 'Person'}">
                            <tr>
                                <td align="left">
                                    <input type="button"  name="Search" id="Search" value="Person Search"
                                           style="width: 100px;" onclick="LoadspecficPerson()"/>
                                </td>
                            </tr>
                            </c:when>
                            <c:when test="${param.Role eq 'Book'}">
                            <tr>
                                <td align="left">
                                    <input type="button"  name="Search" id="Search" value="Book Search"
                                           style="width: 100px;" onclick="LoadBooks()"/>
                                </td>
                            </tr>
                            </c:when>
                            </c:choose>
                    </table>
                </form>
<!-- end #sidebar -->
</div>
<!-- end #page -->

</body>
</html>
