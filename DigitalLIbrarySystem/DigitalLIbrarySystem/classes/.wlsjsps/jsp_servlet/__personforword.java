package jsp_servlet;

import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class __personforword extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/personForword.jsp", 1478023397626L ,"12.1.3.0.0","Africa/Cairo")) return true;
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

    private static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private static java.lang.String  _wl_block1 ="\r\n<html>\r\n    <head>\r\n        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1256\"/>\r\n    </head>\r\n    <body>\r\n    \r\n      ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private static java.lang.String  _wl_block2 ="\r\n            ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private static java.lang.String  _wl_block3 ="\r\n                ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private static java.lang.String  _wl_block4 ="\r\n                    ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private static java.lang.String  _wl_block5 ="\r\n                        ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private static java.lang.String  _wl_block6 ="\r\n                            ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private static java.lang.String  _wl_block7 ="\r\n        \r\n    </body>\r\n</html>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
             org.apache.taglibs.standard.tag.common.core.ChooseTag __tag0 = null ;
            int __result__tag0 = 0 ;

            if (__tag0 == null ){
                __tag0 = new  org.apache.taglibs.standard.tag.common.core.ChooseTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
            }
            __tag0.setPageContext(pageContext);
            __tag0.setParent(null);
            _activeTag=__tag0;
            __result__tag0 = __tag0.doStartTag();

            if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.common.core.ChooseTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block3Bytes, _wl_block3);
                     org.apache.taglibs.standard.tag.rt.core.WhenTag __tag1 = null ;
                    int __result__tag1 = 0 ;

                    if (__tag1 == null ){
                        __tag1 = new  org.apache.taglibs.standard.tag.rt.core.WhenTag ();
                        weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
                    }
                    __tag1.setPageContext(pageContext);
                    __tag1.setParent(__tag0);
                    __tag1.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope.Role eq \'Publisher\' || \'Author\'}",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
                    _activeTag=__tag1;
                    __result__tag1 = __tag1.doStartTag();

                    if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                        if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                             throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.WhenTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                        }
                        do {
                            _bw.write(_wl_block4Bytes, _wl_block4);
                            org.sun.Library.Bean.PersonInfo info= null;synchronized(session){
                                info=(org.sun.Library.Bean.PersonInfo)pageContext.getAttribute("info",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                                if(info==null){
                                    info=new org.sun.Library.Bean.PersonInfo();
                                    pageContext.setAttribute("info",info,javax.servlet.jsp.PageContext.SESSION_SCOPE);
                                    _bw.write(_wl_block5Bytes, _wl_block5);
                                    {java.lang.String __value = request.getParameter("address");

                                        if ((__value != null) && !__value.equals((java.lang.Object)""))info.setAddress(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"address"));
                                    }{java.lang.String __value = request.getParameter("name");

                                        if ((__value != null) && !__value.equals((java.lang.Object)""))info.setName(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"name"));
                                    }{java.lang.String __value = request.getParameter("id");

                                        if ((__value != null) && !__value.equals((java.lang.Object)""))info.setId(( java.lang.Object) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.Object.class,"id"));
                                    }{java.lang.String __value = request.getParameter("email");

                                        if ((__value != null) && !__value.equals((java.lang.Object)""))info.setEmail(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"email"));
                                    }{java.lang.String __value = request.getParameter("phone");

                                        if ((__value != null) && !__value.equals((java.lang.Object)""))info.setPhone(( org.sun.Library.Bean.Phone) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, org.sun.Library.Bean.Phone.class,"phone"));
                                    }_bw.write(_wl_block4Bytes, _wl_block4);

                                }
                            }
                            _bw.write(_wl_block4Bytes, _wl_block4);

                            if (_jsp__tag2(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block3Bytes, _wl_block3);
                        } while (__tag1.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
                    }
                    if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                        _activeTag = null;
                        _releaseTags(pageContext, __tag1);
                        return;
                    }
                    _activeTag=__tag1.getParent();
                    weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
                    __tag1.release();
                    _bw.write(_wl_block3Bytes, _wl_block3);
                     org.apache.taglibs.standard.tag.rt.core.WhenTag __tag3 = null ;
                    int __result__tag3 = 0 ;

                    if (__tag3 == null ){
                        __tag3 = new  org.apache.taglibs.standard.tag.rt.core.WhenTag ();
                        weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
                    }
                    __tag3.setPageContext(pageContext);
                    __tag3.setParent(__tag0);
                    __tag3.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope.Role eq \'Student\'} ",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
                    _activeTag=__tag3;
                    __result__tag3 = __tag3.doStartTag();

                    if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                        if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                             throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.WhenTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                        }
                        do {
                            _bw.write(_wl_block4Bytes, _wl_block4);
                            org.sun.Library.Controler.Member.Student student= null;synchronized(session){
                                student=(org.sun.Library.Controler.Member.Student)pageContext.getAttribute("student",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                                if(student==null){
                                    student=new org.sun.Library.Controler.Member.Student();
                                    pageContext.setAttribute("student",student,javax.servlet.jsp.PageContext.SESSION_SCOPE);
                                    _bw.write(_wl_block5Bytes, _wl_block5);
                                    {java.lang.String __value = request.getParameter("info");

                                        if ((__value != null) && !__value.equals((java.lang.Object)""))student.setInfo(( org.sun.Library.Bean.PersonInfo) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, org.sun.Library.Bean.PersonInfo.class,"info"));
                                    }{java.lang.String __value = request.getParameter("question");

                                        if ((__value != null) && !__value.equals((java.lang.Object)""))student.setQuestion(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"question"));
                                    }{java.lang.String __value = request.getParameter("answer");

                                        if ((__value != null) && !__value.equals((java.lang.Object)""))student.setAnswer(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"answer"));
                                    }{java.lang.String __value = request.getParameter("nationalID");

                                        if ((__value != null) && !__value.equals((java.lang.Object)""))student.setNationalID(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"nationalID"));
                                    }{java.lang.String __value = request.getParameter("access");

                                        if ((__value != null) && !__value.equals((java.lang.Object)""))student.setAccess(( org.sun.Library.Bean.Access) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, org.sun.Library.Bean.Access.class,"access"));
                                    }_bw.write(_wl_block5Bytes, _wl_block5);
                                    org.sun.Library.Bean.PersonInfo info= null;synchronized(session){
                                        info=(org.sun.Library.Bean.PersonInfo)pageContext.getAttribute("info",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                                        if(info==null){
                                            info=new org.sun.Library.Bean.PersonInfo();
                                            pageContext.setAttribute("info",info,javax.servlet.jsp.PageContext.SESSION_SCOPE);
                                            _bw.write(_wl_block6Bytes, _wl_block6);
                                            {java.lang.String __value = request.getParameter("address");

                                                if ((__value != null) && !__value.equals((java.lang.Object)""))info.setAddress(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"address"));
                                            }{java.lang.String __value = request.getParameter("name");

                                                if ((__value != null) && !__value.equals((java.lang.Object)""))info.setName(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"name"));
                                            }{java.lang.String __value = request.getParameter("id");

                                                if ((__value != null) && !__value.equals((java.lang.Object)""))info.setId(( java.lang.Object) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.Object.class,"id"));
                                            }{java.lang.String __value = request.getParameter("email");

                                                if ((__value != null) && !__value.equals((java.lang.Object)""))info.setEmail(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"email"));
                                            }{java.lang.String __value = request.getParameter("phone");

                                                if ((__value != null) && !__value.equals((java.lang.Object)""))info.setPhone(( org.sun.Library.Bean.Phone) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, org.sun.Library.Bean.Phone.class,"phone"));
                                            }_bw.write(_wl_block5Bytes, _wl_block5);

                                        }
                                    }
                                    _bw.write(_wl_block5Bytes, _wl_block5);
                                    org.sun.Library.Bean.Access access= null;synchronized(session){
                                        access=(org.sun.Library.Bean.Access)pageContext.getAttribute("access",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                                        if(access==null){
                                            access=new org.sun.Library.Bean.Access();
                                            pageContext.setAttribute("access",access,javax.servlet.jsp.PageContext.SESSION_SCOPE);
                                            _bw.write(_wl_block6Bytes, _wl_block6);
                                            {java.lang.String __value = request.getParameter("password");

                                                if ((__value != null) && !__value.equals((java.lang.Object)""))access.setPassword(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"password"));
                                            }{java.lang.String __value = request.getParameter("userNmae");

                                                if ((__value != null) && !__value.equals((java.lang.Object)""))access.setUserNmae(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"userNmae"));
                                            }_bw.write(_wl_block5Bytes, _wl_block5);

                                        }
                                    }
                                    _bw.write(_wl_block5Bytes, _wl_block5);
                                    {student.setInfo(( org.sun.Library.Bean.PersonInfo ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope.info}",org.sun.Library.Bean.PersonInfo.class,pageContext,_jspx_fnmap));
                                    }_bw.write(_wl_block5Bytes, _wl_block5);
                                    {student.setAccess(( org.sun.Library.Bean.Access ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope.access}",org.sun.Library.Bean.Access.class,pageContext,_jspx_fnmap));
                                    }_bw.write(_wl_block4Bytes, _wl_block4);

                                }
                            }
                            _bw.write(_wl_block4Bytes, _wl_block4);

                            if (_jsp__tag4(request, response, pageContext, _activeTag, __tag3))
                             return;
                            _bw.write(_wl_block3Bytes, _wl_block3);
                        } while (__tag3.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
                    }
                    if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                        _activeTag = null;
                        _releaseTags(pageContext, __tag3);
                        return;
                    }
                    _activeTag=__tag3.getParent();
                    weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
                    __tag3.release();
                    _bw.write(_wl_block2Bytes, _wl_block2);
                } while (__tag0.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag0);
                return;
            }
            _activeTag=__tag0.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
            __tag0.release();
            _bw.write(_wl_block7Bytes, _wl_block7);
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.RedirectTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.core.RedirectTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.setParentForClassicTag(__tag2, parent);
        __tag2.setUrl(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("addPerson", java.lang.String.class,"url"));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.RedirectTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.core.RedirectTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.setParentForClassicTag(__tag4, parent);
        __tag4.setUrl(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("addPerson", java.lang.String.class,"url"));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }
}
