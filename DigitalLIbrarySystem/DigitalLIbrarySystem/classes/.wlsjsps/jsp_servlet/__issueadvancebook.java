package jsp_servlet;

import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.sql.*;

public final class __issueadvancebook extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/issueadvancebook.jsp", 1466371403999L ,"12.1.3.0.0","Africa/Cairo")) return true;
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

    private static java.lang.String  _wl_block1 ="\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\r\n<title>Digital Library System</title>\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<link href=\"default.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n <script language=\"javascript\">\r\n  function fun()\r\n  {\r\n     location.href=\"viewjournals.jsp\";\r\n  }\r\n  </script>\r\n<script language=\"javascript\">\r\n     \r\n     function change()\r\n     {\r\n          var isbn=document.issuebook.isbn.value;\r\n          location.href=\"getbooks?isbn=\"+isbn+\"&page=/IssueBook.jsp&prefix=issue\";  \r\n     }\r\n     function change1()\r\n     {\r\n          var isbn=document.issuebook.isbn.value;\r\n          var stuid=document.issuebook.stuid.value;\r\n          location.href=\"getbooks?isbn=\"+isbn+\"&page=/IssueBook.jsp&prefix=issue&stuid=\"+stuid;  \r\n     }\r\n     function fun()\r\n      {\r\n          if(document.issuebook.isbn.value==\"\" || document.issuebook.bookid.value==\"\")\r\n          {\r\n              alert(\"All fields are Manditary\");\r\n              return false;\r\n          }\r\n          return true;\r\n     }\r\n  \r\n     \r\n  </script>\r\n<style type=\"text/css\">\r\n<!--\r\n.style1 {\r\n\tcolor: #000000;\r\n\tfont-weight: bold;\r\n}\r\n-->\r\n</style>\r\n</head>\r\n<body>\r\n<div id=\"header\">\r\n\t<div id=\"logo\">\r\n\t\t<h1>";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private static java.lang.String  _wl_block2 =" \r\n\t  </h1>\r\n\t\t\r\n  </div>\r\n\t<div id=\"menu\">\r\n ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private static java.lang.String  _wl_block3 =" \r\n\t</div>\r\n</div>\r\n<div id=\"page\">\r\n  <!-- end #content -->\r\n<div id=\"sidebar\">\r\n\t\t<div id=\"news\" class=\"boxed1\">\r\n\t\t\t<blockquote>\r\n\t\t\t  <blockquote>\r\n\t\t\t    <h2 class=\"title\">Issuing Book</h2>\r\n\t\t      </blockquote>\r\n\t\t  </blockquote>\r\n\t  </div>\r\n   <FORM action=\"issuebook\" name=\"issuebook\" method=\"post\" onsubmit=\"return fun()\">\r\n <table align=\"center\">\r\n   <tr>\r\n    ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private static java.lang.String  _wl_block4 ="<td width=\"145\"><span class=\"style1\">ISBN No.</span></td>\r\n<TD width=\"168\"><input type=\"text\" name=\"isbn\" value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private static java.lang.String  _wl_block5 ="\"/>             </TD>\r\n     </tr>\r\n     <tr>\r\n     <td><span class=\"style1\">Book ID</span></td>\r\n     <TD><input type=text name=\"bookid\" value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private static java.lang.String  _wl_block6 ="\"/>     </TD>\r\n     </tr><tr>\r\n     <td><span class=\"style1\">Student ID</span></td>\r\n     <TD><input type=\"text\" name=\"stuid\"  value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private static java.lang.String  _wl_block7 ="\"/>\r\n        \r\n     ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private static java.lang.String  _wl_block8 ="     </TD>\r\n     </tr>\r\n     ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private static java.lang.String  _wl_block9 ="\r\n     <tr><td><span class=\"style1\">Amount Remaining</span></td>\r\n     <td><input type=\"text\" name=\"fee\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private static java.lang.String  _wl_block10 ="\" readonly/></td><td width=\"76\"><span class=\"style1\">Min. Rs 200 </span></td>\r\n     </tr>\r\n     <tr>\r\n     <td><span class=\"style1\">No. of books issued</span></td>\r\n     <td><input type=\"text\" name=\"nbooks\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private static java.lang.String  _wl_block11 ="\" readonly/></td><td><span class=\"style1\">Max. 3 books</span></td>\r\n     </tr>\r\n          ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private static java.lang.String  _wl_block12 ="\r\n        <tr>  <td><span class=\"style1\">Amount Remaining</span></td>\r\n        <td><input type=\"text\" name=\"fee\" readonly/></td><td><span class=\"style1\">Min. Rs 200 </span></td>\r\n        </tr>\r\n     <tr>\r\n     <td><span class=\"style1\">No. of books issued</span></td>\r\n     <td><input type=\"text\" name=\"nbooks\"  readonly/></td><td><span class=\"style1\">Max. 3 books</span></td>\r\n     </tr>\r\n                ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private static java.lang.String  _wl_block13 ="\r\n     <tr>\r\n     ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private static java.lang.String  _wl_block14 ="\r\n             \r\n               \r\n       ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private static java.lang.String  _wl_block15 ="\r\n             <td><span class=\"style1\">Issue Date</span></td>\r\n        <TD><input type=\"text\" name=\"isuuedate\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private static java.lang.String  _wl_block16 ="\" readonly/></td></tr>\r\n             \r\n             <tr><td><span class=\"style1\">Return Date</span></td>\r\n             <TD><input type=\"text\" name=\"returndate\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private static java.lang.String  _wl_block17 ="\" readonly/>\r\n      ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private static java.lang.String  _wl_block18 ="     </TD>\r\n     </tr>\r\n     <tr></tr>\r\n     <tr></tr>\r\n     <tr></tr>\r\n     <tr>\r\n     <td align=\"center\"><input type=\"submit\" name=return1 value=\"Issue\"/></td><td><input type=\"reset\" value=\"Clear\"/></td>\r\n     </tr>\r\n     </table>\r\n   </FORM>\r\n    ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private static java.lang.String  _wl_block19 ="                         \r\n     \r\n   \r\n  </div>\r\n<!-- end #sidebar -->\r\n</div>\r\n<!-- end #page -->\r\n<div id=\"footer\">\r\n\t<p>&nbsp;</p>\r\n</div>\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
            //st.executeUpdate("update lms_books set status='Available' where book_id='"+request.getParameter("bookid")+"'");
            //st.executeUpdate("delete from lms_booking where book_id='"+request.getParameter("bookid")+"' and stu_id='"+request.getParameter("stuid")+"'");
            ResultSet rs=st.executeQuery("select isbn_no,category from lms_isbn");
     
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(request.getParameter("isbn")), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(request.getParameter("bookid")), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(request.getParameter("stuid")), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block7Bytes, _wl_block7);
       rs=st.executeQuery("select fee,n_books from lms_registration where reg_id='"+request.getParameter("stuid")+"'");
      
            _bw.write(_wl_block8Bytes, _wl_block8);

          if(rs.next())
          {
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(rs.getInt(1)), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(rs.getInt(2)), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block11Bytes, _wl_block11);
}else{
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);

            rs=st.executeQuery("select to_char(sysdate),to_char(sysdate+15) from dual");
     
            _bw.write(_wl_block14Bytes, _wl_block14);

                
           while(rs.next())
           { 
	  
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(rs.getString(1)), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(rs.getString(2)), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block17Bytes, _wl_block17);

             }
      
            _bw.write(_wl_block18Bytes, _wl_block18);
}
         catch(Exception e)
         {
             e.printStackTrace();
         }
          
      
            _bw.write(_wl_block19Bytes, _wl_block19);
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
