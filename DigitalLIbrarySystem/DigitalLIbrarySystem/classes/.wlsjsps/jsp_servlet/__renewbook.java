package jsp_servlet;

import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.sql.*;

public final class __renewbook extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/RenewBook.jsp", 1466371728859L ,"12.1.3.0.0","Africa/Cairo")) return true;
        return false;
    }
    private weblogic.servlet.jsp.ExpressionInterceptor _jsp_expressionInterceptor = weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.getNonOperExpressionInterceptor();

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private static java.lang.String  _wl_block0 ="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private static java.lang.String  _wl_block1 ="\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\r\n<title>Digital Library System</title>\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<link href=\"default.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n<script language=\"javascript\">\r\n     \r\n     function change()\r\n     {\r\n          var isbn=\"\";  \r\n          var stuid=document.renewbook.stuid.value;\r\n          location.href=\"getbooks?isbn=\"+isbn+\"&page=/RenewBook.jsp&prefix=issue&bookid=&stuid=\"+stuid;  \r\n     }\r\n     function change1()\r\n     {\r\n         var isbn=\"\";  \r\n          var stuid=document.renewbook.stuid.value;\r\n          var bookid=document.renewbook.bookid.value;\r\n          location.href=\"getbooks?isbn=\"+isbn+\"&page=/RenewBook.jsp&prefix=issue&stuid=\"+stuid+\"&bookid=\"+bookid; \r\n     }\r\n     function calculate()\r\n     {\r\n         var str1=new Date(document.renewbook.issuedate.value);\r\n        var str2=new Date(document.renewbook.returndate.value);\r\n        var bookid=document.renewbook.bookid.value;\r\n        var stuid=document.renewbook.stuid.value;\r\n\t      location.href=\"calculatefine?page=/RenewBook.jsp&isbn=&prefix=&bookid=\"+bookid+\"&stuid=\"+stuid; \r\n\t  \r\n     }\r\n  </script>\r\n<style type=\"text/css\">\r\n<!--\r\n.style1 {\r\n\tcolor: #000000;\r\n\tfont-weight: bold;\r\n}\r\n-->\r\n</style>\r\n</head>\r\n<body>\r\n<div id=\"header\">\r\n\t<div id=\"logo\">\r\n\t\t<h1>";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private static java.lang.String  _wl_block2 =" \r\n\t  </h1>\r\n\t\t\r\n  </div>\r\n\t<div id=\"menu\">\r\n   ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private static java.lang.String  _wl_block3 =" \r\n\t</div>\r\n</div>\r\n<div id=\"page\">\r\n  <!-- end #content -->\r\n<div id=\"sidebar\">\r\n\t\t<div id=\"news\" class=\"boxed1\">\r\n\t\t\t<blockquote>\r\n\t\t\t  <blockquote>\r\n\t\t\t    <h2 class=\"title\">Renew Book</h2>\r\n\t\t      </blockquote>\r\n\t\t  </blockquote>\r\n\t  </div>\r\n   <FORM action=\"renewbook\" name=\"renewbook\" method=\"post\">\r\n <table height=\"366\" border=\"0\" align=\"center\">\r\n   <tr>\r\n    ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private static java.lang.String  _wl_block4 ="<td width=\"142\" height=\"34\"><span class=\"style1\">Student ID</span></td>\r\n<TD width=\"142\"><select name=\"stuid\" onChange=\"change()\">\r\n             \r\n                 ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private static java.lang.String  _wl_block5 ="\r\n               <option value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private static java.lang.String  _wl_block6 ="\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private static java.lang.String  _wl_block7 ="</option>\r\n       ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private static java.lang.String  _wl_block8 ="\r\n                <option>--select--</option>\r\n       ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private static java.lang.String  _wl_block9 ="\r\n             <option value=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private static java.lang.String  _wl_block10 =">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private static java.lang.String  _wl_block11 ="</option>\r\n      ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private static java.lang.String  _wl_block12 ="\r\n         </select></TD>\r\n     </tr>\r\n     <tr>\r\n     <td height=\"31\"><span class=\"style1\">Book ID</span></td>\r\n     <TD><select name=\"bookid\" onChange=\"change1()\">\r\n     ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private static java.lang.String  _wl_block13 ="\r\n           \t\t\t\t<option value=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private static java.lang.String  _wl_block14 ="\r\n     </select></TD>\r\n     </tr>\r\n  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private static java.lang.String  _wl_block15 ="\r\n                <tr> <td height=\"30\"><span class=\"style1\">Previous Issued Date</span></td>\r\n        <td><input type=\"text\" name=issuedate value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private static java.lang.String  _wl_block16 ="\" readonly/></td></TR>\r\n     <tr>\r\n     <td height=\"30\"><span class=\"style1\">Previous Return Date</span></td>\r\n     <td><input type=\"text\" name=returndate value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private static java.lang.String  _wl_block17 ="\" readonly/></td></TR>         \t\t\r\n      ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private static java.lang.String  _wl_block18 ="\r\n            <tr> <td height=\"29\"><span class=\"style1\">Previous Issued Date</span></td>\r\n        <td><input type=\"text\" name=issuedate  readonly/></td></TR>\r\n     <tr>\r\n     <td height=\"32\"><span class=\"style1\">Previous Return Date</span></td>\r\n     <td><input type=\"text\" name=returndate  readonly/></td></TR>\r\n                         \r\n             ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private static java.lang.String  _wl_block19 =" \r\n     <TR><td height=\"29\"><span class=\"style1\">Fine</span></td>\r\n     <td><input type=\"text\" name=\"fine\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private static java.lang.String  _wl_block20 ="\" readonly/></td></tr>     \r\n     \t\r\n      ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private static java.lang.String  _wl_block21 ="\r\n        <TR><td height=\"30\"><span class=\"style1\">Fine</span></td>\r\n        <td><input type=\"text\" name=\"fine\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private static java.lang.String  _wl_block22 ="\" readonly/></td></tr>\r\n        \r\n      ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private static java.lang.String  _wl_block23 ="           \r\n     \r\n     <tr>\r\n     ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private static java.lang.String  _wl_block24 ="\r\n             \r\n               \r\n       ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private static java.lang.String  _wl_block25 ="\r\n             <td height=\"33\"><span class=\"style1\">Issue Date</span></td>\r\n        <TD><input type=\"text\" name=\"isuuedate\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private static java.lang.String  _wl_block26 ="\" readonly></td></tr>\r\n             \r\n             <tr><td height=\"31\"><span class=\"style1\">Return Date</span></td>\r\n             <TD><input type=\"text\" name=\"returndate\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private static java.lang.String  _wl_block27 ="\" readonly/></TD>\r\n      ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private static java.lang.String  _wl_block28 ="\r\n     </tr>\r\n     \r\n     <tr>\r\n     <td colspan=\"2\" align=\"center\"><INPUT type=\"submit\" name=\"return1\" value=\"Renew\"/>&nbsp;\r\n       <input type=\"reset\" value=\"Clear\"/></td></tr>\r\n     </table>\r\n \r\n    </FORM>\r\n     \r\n       ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private static java.lang.String  _wl_block29 ="                 \r\n     \r\n   \r\n  </div>\r\n<!-- end #sidebar -->\r\n</div>\r\n<!-- end #page -->\r\n<div id=\"footer\">\r\n\t<p>&nbsp;</p>\r\n</div>\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    protected void _jspInit() {
        _jsp_expressionInterceptor = weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.getExpressionInterceptor(getServletConfig());
    }

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            {java.lang.String __page ="header.html";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block2Bytes, _wl_block2);
            {java.lang.String __page ="useroptions.html";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block3Bytes, _wl_block3);

        ServletContext ctx=request.getServletContext();
        String driver=ctx.getInitParameter("driver");
        String url=ctx.getInitParameter("url");
        String dname=ctx.getInitParameter("dname");
        String dpass=ctx.getInitParameter("dpass");
        try
		{
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,dname,dpass);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select reg_id from lms_registration");
            
            _bw.write(_wl_block4Bytes, _wl_block4);

                if(session.getAttribute("stuid")!=null)
                {
                 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf((String)session.getAttribute("stuid")), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf((String)session.getAttribute("stuid")), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block7Bytes, _wl_block7);
       }
                else
                {
       
            _bw.write(_wl_block8Bytes, _wl_block8);

                }
           while(rs.next())
           { 
	  
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(rs.getString(1)), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(rs.getString(1)), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block11Bytes, _wl_block11);

            }
            _bw.write(_wl_block12Bytes, _wl_block12);
        System.out.println((String)session.getAttribute("stuid"));
              
                if(session.getAttribute("bookid")!=null)
                {
                 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf((String)session.getAttribute("bookid")), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf((String)session.getAttribute("bookid")), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block7Bytes, _wl_block7);
       }
                else
                {
       
            _bw.write(_wl_block8Bytes, _wl_block8);

                }
                if(session.getAttribute("stuid")!=null)
                {
                     System.out.println("values are going to be shown here");
       				 rs=st.executeQuery("select book_id from lms_books_issue where stu_id='"+(String)session.getAttribute("stuid")+"'");
           			 String bookid="";
           			 while(rs.next())
           			 {
                         bookid=rs.getString(1);
      
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(bookid), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(bookid), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block11Bytes, _wl_block11);
             
        			    }
                }
      
            _bw.write(_wl_block14Bytes, _wl_block14);

      //if(session.getAttribute("bookid")!=null && session.getAttribute("stuid")!=null)
      //{
            System.out.println("values are going to be shown here");
      		rs=st.executeQuery("select to_char(issue_date),to_char(return_date),(sysdate-return_date)*10 from lms_books_issue where stu_id='"+(String)session.getAttribute("stuid")+"' and book_id='"+(String)session.getAttribute("bookid")+"'");
         	String bookid="";
         	int fine=0;
         	int fine1=0;
           	if(rs.next())
           	 {
      
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(rs.getString(1)), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(rs.getString(2)), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block17Bytes, _wl_block17);
             fine=rs.getInt(3);
             }
             else
             {
            _bw.write(_wl_block18Bytes, _wl_block18);
 }
    
     if(fine>0)
        { 
        fine1=fine;
     
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(fine1), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block20Bytes, _wl_block20);
 }
      else
      {
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(fine1), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block22Bytes, _wl_block22);
} 
            _bw.write(_wl_block23Bytes, _wl_block23);

            rs=st.executeQuery("select to_char(sysdate),to_char(sysdate+15) from dual");
     
            _bw.write(_wl_block24Bytes, _wl_block24);

                
           while(rs.next())
           { 
	  
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(rs.getString(1)), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(rs.getString(2)), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block27Bytes, _wl_block27);

             }
      
            _bw.write(_wl_block28Bytes, _wl_block28);
  }
         catch(Exception e)
         {
             e.printStackTrace();
         }
          
            
            _bw.write(_wl_block29Bytes, _wl_block29);
        } catch (java.lang.Throwable __ee){
            __ee.setStackTrace(weblogic.jsp.internal.jsp.utils.SMAPUtils.loadSMAP(this.getClass()).processStackTrace(__ee.getStackTrace()));
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        } finally {
            javax.servlet.jsp.JspFactory.getDefaultFactory().releasePageContext(pageContext);
        }
    }
}
