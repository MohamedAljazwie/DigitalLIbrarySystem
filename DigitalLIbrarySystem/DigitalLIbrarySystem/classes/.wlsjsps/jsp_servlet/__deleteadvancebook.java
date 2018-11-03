package jsp_servlet;

import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.sql.*;

public final class __deleteadvancebook extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/deleteadvancebook.jsp", 1466371196125L ,"12.1.3.0.0","Africa/Cairo")) return true;
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

    private static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private static java.lang.String  _wl_block1 ="\r\n\r\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n<html>\r\n  <head>\r\n    <base href=\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private static java.lang.String  _wl_block2 ="\">\r\n    \r\n    <title>Digital Library System</title>\r\n    \r\n    <meta http-equiv=\"pragma\" content=\"no-cache\">\r\n    <meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n    <meta http-equiv=\"expires\" content=\"0\">\r\n    <meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n    <meta http-equiv=\"description\" content=\"This is my page\">\r\n    \r\n    <!--\r\n    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n    -->\r\n  </head>\r\n  \r\n  <body>\r\n        <center>\r\n  \r\n  <br><br>\r\n <table>\r\n   <tr>\r\n    ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private static java.lang.String  _wl_block3 ="\r\n                ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private static java.lang.String  _wl_block4 ="                        \r\n     \r\n\r\n    \r\n\r\n  </body>\r\n</html>\r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print(_jsp_expressionInterceptor.intercept( String.valueOf(basePath), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.Scripting));
            _bw.write(_wl_block2Bytes, _wl_block2);

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
                        Statement st1=con.createStatement();
            st.executeUpdate("delete from lms_booking where book_id='"+request.getParameter("bookid")+"' and stu_id='"+request.getParameter("stuid")+"'");
            ResultSet rs=st.executeQuery("select * from lms_booking where book_id='"+request.getParameter("bookid")+"' order by booking_date");
            
            if(rs.next())
            {
                st1.executeUpdate("update lms_books set status='Booked' where book_id='"+request.getParameter("bookid")+"'");
                st1.executeUpdate("insert into lms_mails values(msg_seg.nextval,'"+rs.getString(1)+"','The bookid-"+request.getParameter("bookid")+" is available. Collect the book with in 48 hours.')");
            }
            else
            {
                st1.executeUpdate("update lms_books set status='Available' where book_id='"+request.getParameter("bookid")+"'");
            }
           	
           
            {java.lang.String __page = "/AdvanceBooks.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) {
                    __encoding = "ISO-8859-1";
                }
                if (__queryParams.length==0) {
                     pageContext.forward(__page);
                } else {
                    pageContext.forward(weblogic.utils.http.HttpParsing.makeURI(__page,__queryParams,__encoding));
                }if(true) return;
            }_bw.write(_wl_block3Bytes, _wl_block3);
}
         catch(Exception e)
         {
             e.printStackTrace();
             
            {java.lang.String __page = "/AdvanceBooks.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) {
                    __encoding = "ISO-8859-1";
                }
                if (__queryParams.length==0) {
                     pageContext.forward(__page);
                } else {
                    pageContext.forward(weblogic.utils.http.HttpParsing.makeURI(__page,__queryParams,__encoding));
                }if(true) return;
            }_bw.write(_wl_block3Bytes, _wl_block3);

         }
          
      
            _bw.write(_wl_block4Bytes, _wl_block4);
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
