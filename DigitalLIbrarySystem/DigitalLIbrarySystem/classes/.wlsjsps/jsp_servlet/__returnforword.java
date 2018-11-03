package jsp_servlet;

import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.lang.System;

public final class __returnforword extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ReturnForword.jsp", 1478023397617L ,"12.1.3.0.0","Africa/Cairo")) return true;
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

    private static java.lang.String  _wl_block1 ="\r\n<html>\r\n    <head>\r\n        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1256\"/>\r\n    </head>\r\n    <body>\r\n     ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private static java.lang.String  _wl_block2 ="\r\n              \r\n                                ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private static java.lang.String  _wl_block3 ="\r\n                                                    ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private static java.lang.String  _wl_block4 ="\r\n                                                           ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private static java.lang.String  _wl_block5 =" <!--  end info bean-->\r\n                                       ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private static java.lang.String  _wl_block6 ="\r\n                                       ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private static java.lang.String  _wl_block7 ="\r\n                                ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private static java.lang.String  _wl_block8 =" <!-- end student bean-->\r\n                                ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private static java.lang.String  _wl_block9 ="\r\n                                                     ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private static java.lang.String  _wl_block10 ="    \r\n                                                             ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private static java.lang.String  _wl_block11 ="\r\n                                                             ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private static java.lang.String  _wl_block12 ="\r\n                                                       ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private static java.lang.String  _wl_block13 =" <!-- end spec bean-->\r\n                                        ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private static java.lang.String  _wl_block14 ="\r\n                                        ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private static java.lang.String  _wl_block15 =" <!-- end book bean-->\r\n                         ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private static java.lang.String  _wl_block16 ="\r\n                         ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private static java.lang.String  _wl_block17 ="\r\n                ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private static java.lang.String  _wl_block18 =" <!--  end issue bean-->\r\n                \r\n                ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private static java.lang.String  _wl_block19 ="\r\n    \r\n    </body>\r\n</html>";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            org.sun.Library.Controler.Book.ReturnBook returnBook= null;synchronized(session){
                returnBook=(org.sun.Library.Controler.Book.ReturnBook)pageContext.getAttribute("returnBook",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(returnBook==null){
                    returnBook=new org.sun.Library.Controler.Book.ReturnBook();
                    pageContext.setAttribute("returnBook",returnBook,javax.servlet.jsp.PageContext.SESSION_SCOPE);
                    _bw.write(_wl_block2Bytes, _wl_block2);
                    org.sun.Library.Controler.Member.Student student= null;{
                        student=(org.sun.Library.Controler.Member.Student)pageContext.getAttribute("student");
                        if(student==null){
                            student=new org.sun.Library.Controler.Member.Student();
                            pageContext.setAttribute("student",student);
                            _bw.write(_wl_block3Bytes, _wl_block3);
                            org.sun.Library.Bean.PersonInfo info= null;{
                                info=(org.sun.Library.Bean.PersonInfo)pageContext.getAttribute("info");
                                if(info==null){
                                    info=new org.sun.Library.Bean.PersonInfo();
                                    pageContext.setAttribute("info",info);
                                    _bw.write(_wl_block4Bytes, _wl_block4);
                                    {java.lang.String __value = request.getParameter("studentID");

                                        if ((__value != null) && !__value.equals((java.lang.Object)""))info.setId(( java.lang.Object) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.Object.class,"id"));
                                    }_bw.write(_wl_block3Bytes, _wl_block3);

                                }
                            }
                            _bw.write(_wl_block5Bytes, _wl_block5);
                            {student.setInfo(( org.sun.Library.Bean.PersonInfo ) weblogic.servlet.jsp.ELHelper.evaluate("${pageScope.info}",org.sun.Library.Bean.PersonInfo.class,pageContext,_jspx_fnmap));
                            }_bw.write(_wl_block6Bytes, _wl_block6);
                            {java.lang.String __value = request.getParameter("nationalID");

                                if ((__value != null) && !__value.equals((java.lang.Object)""))student.setNationalID(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"nationalID"));
                            }_bw.write(_wl_block7Bytes, _wl_block7);

                        }
                    }
                    _bw.write(_wl_block8Bytes, _wl_block8);
                    org.sun.Library.Controler.Book.Book book= null;{
                        book=(org.sun.Library.Controler.Book.Book)pageContext.getAttribute("book");
                        if(book==null){
                            book=new org.sun.Library.Controler.Book.Book();
                            pageContext.setAttribute("book",book);
                            _bw.write(_wl_block9Bytes, _wl_block9);
                            org.sun.Library.Bean.BookSpec bookSpec= null;{
                                bookSpec=(org.sun.Library.Bean.BookSpec)pageContext.getAttribute("bookSpec");
                                if(bookSpec==null){
                                    bookSpec=new org.sun.Library.Bean.BookSpec();
                                    pageContext.setAttribute("bookSpec",bookSpec);
                                    _bw.write(_wl_block10Bytes, _wl_block10);
                                    {java.lang.String __value = request.getParameter("isbn");

                                        if ((__value != null) && !__value.equals((java.lang.Object)""))bookSpec.setIsbn(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"isbn"));
                                    }_bw.write(_wl_block11Bytes, _wl_block11);
                                    {bookSpec.setTitle(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope.bookTitile}",java.lang.String.class,pageContext,_jspx_fnmap));
                                    }_bw.write(_wl_block12Bytes, _wl_block12);

                                }
                            }
                            _bw.write(_wl_block13Bytes, _wl_block13);
                            {book.setBookSpec(( org.sun.Library.Bean.BookSpec ) weblogic.servlet.jsp.ELHelper.evaluate("${pageScope.bookSpec}",org.sun.Library.Bean.BookSpec.class,pageContext,_jspx_fnmap));
                            }_bw.write(_wl_block14Bytes, _wl_block14);
                            {java.lang.String __value = request.getParameter("bookID");

                                if ((__value != null) && !__value.equals((java.lang.Object)""))book.setId(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"id"));
                            }_bw.write(_wl_block14Bytes, _wl_block14);

                            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
                             return;
                            _bw.write(_wl_block7Bytes, _wl_block7);

                        }
                    }
                    _bw.write(_wl_block15Bytes, _wl_block15);
                    {returnBook.setBook(( org.sun.Library.Controler.Book.Book ) weblogic.servlet.jsp.ELHelper.evaluate("${pageScope.book}",org.sun.Library.Controler.Book.Book.class,pageContext,_jspx_fnmap));
                    }_bw.write(_wl_block16Bytes, _wl_block16);
                    {returnBook.setStudent(( org.sun.Library.Controler.Member.Student ) weblogic.servlet.jsp.ELHelper.evaluate("${pageScope.student}",org.sun.Library.Controler.Member.Student.class,pageContext,_jspx_fnmap));
                    }_bw.write(_wl_block16Bytes, _wl_block16);
                    {java.lang.String __value = request.getParameter("issueDate");

                        if ((__value != null) && !__value.equals((java.lang.Object)""))returnBook.setIssueDate(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"issueDate"));
                    }_bw.write(_wl_block16Bytes, _wl_block16);
                    {java.lang.String __value = request.getParameter("returnDate");

                        if ((__value != null) && !__value.equals((java.lang.Object)""))returnBook.setReturnDate(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"returnDate"));
                    }_bw.write(_wl_block16Bytes, _wl_block16);
                    {java.lang.String __value = request.getParameter("returnedDate");

                        if ((__value != null) && !__value.equals((java.lang.Object)""))returnBook.setReturnedDate(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"returnedDate"));
                    }_bw.write(_wl_block16Bytes, _wl_block16);
                    {java.lang.String __value = request.getParameter("nots");

                        if ((__value != null) && !__value.equals((java.lang.Object)""))returnBook.setNots(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"nots"));
                    }_bw.write(_wl_block17Bytes, _wl_block17);

                }
            }
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
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

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.common.core.RemoveTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.common.core.RemoveTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.setParentForClassicTag(__tag0, parent);
        __tag0.setVar(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("bookTitile", java.lang.String.class,"var"));
        __tag0.setScope(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("session", java.lang.String.class,"scope"));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.common.core.RemoveTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.RedirectTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.core.RedirectTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.setParentForClassicTag(__tag1, parent);
        __tag1.setUrl(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("returnbook?isbn=${pageScope.bookSpec.isbn}",java.lang.String.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }
}
