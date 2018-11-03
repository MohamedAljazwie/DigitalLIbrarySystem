package jsp_servlet;

import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.sql.*;

public final class __userviewjournal extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/userviewjournal.jsp", 1467600825943L ,"12.1.3.0.0","Africa/Cairo")) return true;
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

    private static java.lang.String  _wl_block0 ="\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\r\n<title>Digital Library System</title>\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<link href=\"default.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n  <script language=\"javascript\">\r\n      function fun()\r\n      {\r\n          var jid=document.getbook.hidden.value;\r\n          var issue=document.getbook.issue.value;\r\n          location.href=\"viewjournals.jsp?jid=\"+jid+\"&issue=\"+issue;\r\n      }\r\n     function change()\r\n     {\r\n          var isbn=document.getbook.isbn.value;\r\n          location.href=\"getbooks?isbn=\"+isbn+\"&page=/userviewjournal.jsp&bookid=&stuid=&prefix=\";  \r\n     }\r\n  </script>\r\n  <style type=\"text/css\">\r\n<!--\r\n.style1 {\r\n\tcolor: #000000;\r\n\tfont-weight: bold;\r\n}\r\n.style2 {color: #FFFFFF}\r\n-->\r\n  </style>\r\n</head>\r\n<body>\r\n<div id=\"header\">\r\n\t<div id=\"logo\">\r\n\t\t<h1>";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private static java.lang.String  _wl_block1 =" \r\n\t  </h1>\r\n\t\t\r\n  </div>\r\n\t<div id=\"menu\">\r\n  ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private static java.lang.String  _wl_block2 ="\r\n\t</div>\r\n</div>\r\n<div id=\"page\">\r\n  <!-- end #content -->\r\n<div id=\"sidebar\">\r\n\t\t<div id=\"news\" class=\"boxed1\">\r\n\t\t\t<blockquote>\r\n\t\t\t  <blockquote>\r\n\t\t\t    <h2 class=\"title\">Journals</h2>\r\n\t\t      </blockquote>\r\n\t\t  </blockquote>\r\n\t  </div>\r\n    <FORM action=\"viewjournals.jsp\" name=\"getbook\" method=\"post\">\r\n <table width=\"179\" border=\"0\" align=\"center\">\r\n    <tr>\r\n   <td width=\"65\"><span class=\"style1\">Period</span></TD>\r\n   <td width=\"102\"><select name=\"isbn\" onChange=\"change()\">\r\n   <OPTION>--select--</OPTION>\r\n   <option value=\"Daily\">Daily</option>\r\n   <option value=\"Weekly\">Weekly</option>\r\n   <option value=\"Fortnightly\">Fortnightly</option>\r\n   <option value=\"Monthly\">Monthly</option>\r\n   <option value=\"Annually\">Annually</option>  </select>\r\n   </td>\r\n   </tr>\r\n   </table>\r\n   <center>\r\n   ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private static java.lang.String  _wl_block3 ="\r\n  <br/>\r\n   <table width=\"413\" border=\"0-\" align=\"center\">\r\n    <tr>\r\n    <th width=\"166\" bgcolor=\"#B59631\"><span class=\"style2\">Journal Name</span></th>\r\n    <th width=\"86\" bgcolor=\"#B59631\"><span class=\"style2\">Price</span></th>\r\n    <th width=\"147\" bgcolor=\"#B59631\"><span class=\"style2\">Issue On</span></th>\r\n     ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private static java.lang.String  _wl_block4 ="<tr><td bgcolor=\"#F7AF9B\"><div align=\"center\" class=\"style1\">\r\n       <div align=\"left\">";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private static java.lang.String  _wl_block5 ="</div>\r\n     </div></td>\r\n             <td bgcolor=\"#F7AF9B\"><div align=\"center\" class=\"style1\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private static java.lang.String  _wl_block6 ="</div></td>\r\n             <td bgcolor=\"#F7AF9B\"><div align=\"center\" class=\"style1\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private static java.lang.String  _wl_block7 ="</div></td>\r\n             \r\n             </tr>\r\n          ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private static java.lang.String  _wl_block8 ="\r\n      </table>\r\n    </FORM>\r\n          ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private static java.lang.String  _wl_block9 ="  \r\n    </center>\r\n   \r\n  </div>\r\n<!-- end #sidebar -->\r\n</div>\r\n<!-- end #page -->\r\n<div id=\"footer\">\r\n\t<p>&nbsp;</p>\r\n</div>\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
            {java.lang.String __page ="header.html";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block1Bytes, _wl_block1);
            {java.lang.String __page ="useroptions.html";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block2Bytes, _wl_block2);

   if(session.getAttribute("isbnno")!=null)
    {
      out.print((String)session.getAttribute("isbnno")+" Journals");
            }
            _bw.write(_wl_block3Bytes, _wl_block3);

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
            ResultSet rs=st.executeQuery("select * from lms_journals where period='"+(String)session.getAttribute("isbnno")+"'");
            while(rs.next())
            {
             
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(rs.getString(2)), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(rs.getString(3)), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(rs.getString(5)), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block7Bytes, _wl_block7);
}
          
            _bw.write(_wl_block8Bytes, _wl_block8);

             
             }
             catch(Exception e)
             {
                  e.printStackTrace();
             }
            _bw.write(_wl_block9Bytes, _wl_block9);
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
