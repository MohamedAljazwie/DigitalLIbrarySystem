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
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css"/>
        <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
        <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
        <script>
          $(function () {
              $("#datepicker").datepicker();
          });
          $(function () {
              $("#datepicker1").datepicker();
          });
          $(function () {
              $("#datepicker2").datepicker();
          });
        </script>
        <style type="text/css">
<!--                .style1 {
                    color: #FF0000;
                    font-weight: bold;
                    font-size: 14px;
                }
-->
            </style>
        <script language="javascript">
          function fun() {
              if (document.issueBook.studentID.value == "" || document.issueBook.nationalID.value == "" || document.issueBook.bookID.value == "" || document.issueBook.isbn.value == "" || document.issueBook.issueDate.value == "" || document.issueBook.returnDate.value == ""
              {
                  alert("All fields are Manditary");
                  return false;
              }

              return true;
          }
        </script>
    </head>
    <body>
        <div id="header">
            <div id="logo">
                <h1>
                    <jsp:include page="header.html"/>
                </h1>
            </div>
            <div id="menu">
                <jsp:include page="adminoptions.html"/>
            </div>
        </div>
        <div id="page">
            <!-- end #content -->
            <div id="sidebar">
                <div id="news" class="boxed1">
                    <blockquote>
                        <blockquote>
                            <h2 class="title">Book FINE</h2>
                        </blockquote>
                    </blockquote>
                </div>
                <form action="" method="post" name="login">
                    <div align="center" class="style1">
                        <c:if test="${! empty param.status}">
                            <c:out value="${param.status}"/>
                            <br/> <center>The Fine For this Student  is</center>
                        </c:if>
                    </div>
                </form>
                 
                <br/>
                 
                <br/>
                <script language="javascript">
                  function change() {
                      var isbn = "";
                      var stuid = document.returnbook.stuid.value;
                      location.href = "getbooks?isbn=" + isbn + "&page=/ReturnBook.jsp&prefix=issue&stuid=" + stuid;
                  }

                  function change1() {
                      var isbn = "";
                      var stuid = document.returnbook.stuid.value;
                      var bookid = document.returnbook.bookid.value;
                      location.href = "getbooks?isbn=" + isbn + "&page=/ReturnBook.jsp&prefix=issue&stuid=" + stuid + "&bookid=" + bookid;
                  }

                  function calculate() {
                      if (parseInt(document.returnbook.bookcost.value) > 0) {
                          //alert(document.returnbook.bookcost.value);
                          //alert(document.returnbook.fine.value);
                          document.returnbook.totalcost.value = parseInt(document.returnbook.bookcost.value) + parseInt(document.returnbook.fine.value);
                          //alert(document.returnbook.totalcost.value);
                          document.returnbook.return1.disabled = false;
                          checkbalance();
                      }
                  }

                  function enable() {
                      //document.returnbook.bookcost.disabled=false;
                      document.returnbook.return1.disabled = true;
                      document.returnbook.cash.disabled = false;
                      document.returnbook.bookcost.value = document.returnbook.bookcosthid.value;
                      //document.returnbook.calculate.disabled=false;  
                      calculate();
                  }

                  function checkbalance() {
                      if (parseInt(document.returnbook.totalcost.value) > parseInt(document.returnbook.amount.value)) {
                          alert("Insufficient Amount\n Amount shoud be pay by Cash");
                          return false;
                      }
                      return true;
                  }

                  function feetype() {
                      if (document.returnbook.cash.value == "Deduct from Fee") {
                          if (!checkbalance())
                              document.returnbook.return1.disabled = true;
                      }
                      else 
                          document.returnbook.return1.disabled = false;
                  }
                </script>
                <form action="" name="bookFine" method="post" onsubmit="return checkbalance()">
                    <table width="100%"  border="0" align="left">
                        <tr>
                                <td width="60" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Student  ID</div></td>
                                <td width="90" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">${FINE.returnBook.student.info.id}</div>
                                </td>
                                </tr>
                                <tr>
                                <td width="60" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Student National ID</div></td>
                                <td width="90" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">${FINE.returnBook.student.nationalID}</div>
                                </td>
                                </tr>
                                <tr>
                                <td width="60" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Fine Date</div></td>
                                <td width="90" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">${FINE.fineDate}</div>
                                </td>
                                </tr>
                                <c:choose>
                                <c:when test="${empty param.bookLost}">  
                                   <tr>
                                <td width="60" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">COST</div></td>
                                <td width="90" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">  ${FINE.cost}</div>
                                </td>
                                </tr>
                                </c:when>
                                  </c:choose>
                        
                        <tr>
                            <td width="60" colspan="2"  class="style1">
                            <form action="#" method="POST">
                                <input type="submit" name="bookLost" value="In case of loss of Book click here" onclick="enable()"/>
                                 </form>
                                <br/>
                            </td>
                        </tr>
                       <c:if test="${! empty param.bookLost}">
                       <c:set var="bookLost" value="${ param.bookLost}" scope="session"/>
                       <tr>
                                <td width="60" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Book  Price</div>
                              </td>
                                 <td width="90" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">${spec.price}</div>
                                </td>
                                </tr>
                                <tr>
                                <td width="60" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">Total Cost</div>
                                </td>
                                <td width="90" height="28" bgcolor="#B79A36" class="style1">
                                    <div align="center">${FINE.totalCost}</div>
                                </td>
                            </tr>
                       </c:if>
                        <tr>
                            <td>
                                <span class="style1" >Select Mode of Pay</span>
                            </td>
                            <td>
                                <select name="modeOfPay"  style="width: 300px;">
                                    <option value="Cash">Cash</option>
                                    <option value="Deduct from Fee">Deduct from Fee</option>
                                </select>
                            </td>
                        </tr>
                        <tr><td colspan="2"> <br/></td></tr>
                           <tr>
                                <td >
                                    <span class="style1"><strong> Remark</strong></span>
                                </td>
                                <td >
                                    <textarea name="remark" id="remark" cols="50" rows="10"
                                              value="${param.remark}">
                                   </textarea>
                                </td>
                            </tr>
                         
                        <tr>
                            <td align="center">
                                <input type="submit" name="fine" value="Confirm  Data"  style="width: 250px;"/>
                            </td>
                            <td>
                                <input type="reset" value="Clear"  style="width: 250px;"/>
                            </td>
                        </tr>
                    </table>
                </form>
                <c:if test="${! empty param.fine}">
                <c:set  target="${sessionScope.FINE}"  property="modeOfPay" value="${param.modeOfPay}"/>
                <c:set target="${sessionScope.FINE}" property="remark" value="${param.remark}" />
                <c:redirect url="fine"/>
                </c:if>
            </div>
            <!-- end #sidebar -->
        </div>
        <!-- end #page -->
        <br/><br/>
         <br/><br/>
          <br/><br/>
           <br/><br/>
         <br/><br/>
          <br/>
        <div id="footer">
            <p>&nbsp;</p>
        </div>
    </body>
</html>