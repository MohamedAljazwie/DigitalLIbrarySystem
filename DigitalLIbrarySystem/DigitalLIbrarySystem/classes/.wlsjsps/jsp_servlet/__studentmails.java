package jsp_servlet;

import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.sql.*;

public final class __studentmails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/StudentMails.jsp", 1466371452815L ,"12.1.3.0.0","Africa/Cairo")) return true;
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

    private static java.lang.String  _wl_block1 ="\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n\t<head>\r\n\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n\t\t<title>Digital Library System</title>\r\n\t\t<meta name=\"keywords\" content=\"\" />\r\n\t\t<meta name=\"description\" content=\"\" />\r\n\t\t<link href=\"default.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n\t\t<script language=\"javascript\">\r\n      function fun()\r\n      {\r\n          var jid=document.getbook.hidden.value;\r\n          var issue=document.getbook.issue.value;\r\n          location.href=\"viewjournals.jsp?jid=\"+jid+\"&issue=\"+issue;\r\n      }\r\n     function change()\r\n     {\r\n          var isbn=document.getbook.isbn.value;\r\n          location.href=\"getbooks?isbn=\"+isbn+\"&page=/viewjournals.jsp&bookid=&stuid=&prefix=\";  \r\n     }\r\n  </script>\r\n\t\t<style type=\"text/css\">\r\n<!--\r\n.style4 {\r\n\tcolor: #FFFFFF\r\n}\r\n\r\n.style6 {\r\n\tcolor: #000000;\r\n\tfont-weight: bold;\r\n}\r\n\r\na:link {\r\n\tcolor: #FF0000;\r\n}\r\n\r\na:hover {\r\n\tcolor: #FFFFFF;\r\n}\r\n-->\r\n</style>\r\n\t</head>\r\n\t<body>\r\n\t\t<div id=\"header\">\r\n\t\t\t<div id=\"logo\">\r\n\t\t\t\t<h1>";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private static java.lang.String  _wl_block2 ="\r\n\t\t\t\t</h1>\r\n\r\n\t\t\t</div>\r\n\t\t\t<div id=\"menu\">\r\n\t\t\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private static java.lang.String  _wl_block3 ="\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<div id=\"page\">\r\n\t\t\t<!-- end #content -->\r\n\t\t\t<div id=\"sidebar\">\r\n\t\t\t\t<div id=\"news\" class=\"boxed1\">\r\n\t\t\t\t\t<blockquote>\r\n\t\t\t\t\t\t<blockquote>\r\n\t\t\t\t\t\t\t<h2 class=\"title\">\r\n\t\t\t\t\t\t\t\tMails\r\n\t\t\t\t\t\t\t</h2>\r\n\t\t\t\t\t\t</blockquote>\r\n\t\t\t\t\t</blockquote>\r\n\t\t\t\t</div>\r\n\t\t\t\t<table width=\"603\" border=\"0\" align=\"center\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th width=\"74\" bgcolor=\"#B59631\">\r\n\t\t\t\t\t\t\t<span class=\"style4\">Msg ID.</span>\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t<th width=\"471\" bgcolor=\"#B59631\">\r\n\t\t\t\t\t\t\t<span class=\"style4\">Content</span>\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t</tr>\r\n\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private static java.lang.String  _wl_block4 ="\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td bgcolor=\"#F7AF9B\">\r\n\t\t\t\t\t\t\t<div align=\"center\" class=\"style6\">";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private static java.lang.String  _wl_block5 ="</div>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td bgcolor=\"#F7AF9B\">\r\n\t\t\t\t\t\t\t<span class=\"style6\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private static java.lang.String  _wl_block6 ="</span>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td width=\"36\" bgcolor=\"#F7AF9B\">\r\n\t\t\t\t\t\t\t<a href=\"DeleteMails?msgid=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private static java.lang.String  _wl_block7 ="&page=StudentHome.jsp\">Delete</a>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private static java.lang.String  _wl_block8 ="\r\n\t\t\t\t</table>\r\n\t\t\t\t</center>\r\n\r\n\t\t\t</div>\r\n\t\t\t<!-- end #sidebar -->\r\n\t\t</div>\r\n\t\t<!-- end #page -->\r\n\t\t<div id=\"footer\">\r\n\t\t\t<p>\r\n\t\t\t\t&nbsp;\r\n\t\t\t</p>\r\n\t\t</div>\r\n\t</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
            {java.lang.String __page ="studentoptions.html";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block3Bytes, _wl_block3);

						ServletContext ctx = request.getServletContext();
						String driver = ctx.getInitParameter("driver");
						String url = ctx.getInitParameter("url");
						String dname = ctx.getInitParameter("dname");
						String dpass = ctx.getInitParameter("dpass");
						try {
							Class.forName(driver);
							Connection con = DriverManager.getConnection(url, dname, dpass);
							Statement st = con.createStatement();
							String msgid = "";
                             
							System.out.println("select * from lms_mails where per_id='"
									+ (String) session.getAttribute("userid") + "'");
							ResultSet rs = st
									.executeQuery("select * from lms_mails where per_id='"
											+ (String) session.getAttribute("userid") + "'");
							while (rs.next()) {
								msgid = rs.getString(1);
					
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(msgid), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(rs.getString(3)), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(msgid), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block7Bytes, _wl_block7);

						}

						} catch (Exception e) {
							System.out.println(e);
							e.printStackTrace();
						}
					
            _bw.write(_wl_block8Bytes, _wl_block8);
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
