package jsp_servlet;

import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class __brpwesform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/brpwesForm.jsp", 1477154059566L ,"12.1.3.0.0","Africa/Cairo")) return true;
        return false;
    }
    private weblogic.servlet.jsp.ExpressionInterceptor _jsp_expressionInterceptor = weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.getNonOperExpressionInterceptor();

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "windows-1256".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private static java.lang.String  _wl_block0 ="<!DOCTYPE html>\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private static java.lang.String  _wl_block1 ="\r\n<html>\r\n    <head>\r\n        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1256\"/>\r\n    </head>\r\n    <body align=\"center\">\r\n        <form name=\"browseform\" method=\"post\" action=\'BrowseTab.jsp\'>\r\n            <table width=\"100%\" cellspacing=\"1\" cellpadding=\"4\" border=\"0\" style=\'border-style:double; border-width:1px; \r\n\t\t\t\t\t\t\t\t\tborder-color:black\'>\r\n                <tr>\r\n                    <th id=\"common_th\" colspan=\"2\">TABLE DISPLAY SETTINGS</th>\r\n                </tr>\r\n                 \r\n                <tr>\r\n                    <td width=\"55\">\r\n                        <table width=\"100%\" cellspacing=\"1\" cellpadding=\"4\" border=\"0\" style=\'border-style:double; border-width:1px; \r\n\t\t\t\t\t\t\t\t\tborder-color:black\'>\r\n                            <tr>\r\n                                <th id=\"common_hed\">No.of Records Per Page</th>\r\n                                <td id=\"common_td\">\r\n                                    <input name=\"records_per_page\" type=\"text\" style=\'background:azure;width:145px\'\r\n                                           value=\"11\"/>\r\n                                </td>\r\n                            </tr>\r\n                             \r\n                            <tr>\r\n                                <th id=\"common_hed\">Starting From Record</th>\r\n                                <td id=\"common_td\">\r\n                                    <input name=\"start_index\" type=\"text\" style=\'background:azure;width:145px\'\r\n                                           value=\"1\"/>\r\n                                </td>\r\n                            </tr>\r\n                               <tr>\r\n                                <th id=\"common_hed\">Row count </th>\r\n                                <td id=\"common_td\">\r\n                                    <input name=\"row_count\" type=\"text\" style=\'background:azure;width:145px\'\r\n                                           value=\"107\"/>\r\n                                </td>\r\n                            </tr>\r\n                        </table>\r\n                    </td>\r\n                </tr>\r\n                 \r\n                <tr>\r\n                    <td align=\"right\">\r\n                        <img name=\"pic11\" src=\"images/reset1.jpg\" border=\"0\" width=\"70\" height=\"24\"\r\n                             onmousedown=\'putOn(this,11)\' onmouseup=\'putOff(this,11)\' onmouseout=\'putOff(this,11)\'\r\n                             onclick=\'browseform.reset()\' style=\'cursor:hand\'/>\r\n                    </td>\r\n                    <td align=\"left\">\r\n                        <img name=\"pic12\" src=\"images/fetch1.jpg\" border=\"0\" width=\"70\" height=\"24\"\r\n                             onmousedown=\'putOn(this,12)\' onmouseup=\'putOff(this,12)\' onmouseout=\'putOff(this,12)\'\r\n                             onclick=\'browseform.submit()\' style=\'cursor:hand\'/>\r\n                    </td>\r\n                </tr>\r\n            </table>\r\n        </form>\r\n    </body>\r\n</html>";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

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
        response.setHeader("Content-Type", "text/html;charset=windows-1256");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=windows-1256");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
