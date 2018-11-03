package jsp_servlet;

import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class __bookforword extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/bookForword.jsp", 1478023397898L ,"12.1.3.0.0","Africa/Cairo")) return true;
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

    private static java.lang.String  _wl_block1 ="\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private static java.lang.String  _wl_block2 ="\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private static java.lang.String  _wl_block3 ="\r\n<html>\r\n    <head>\r\n        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1256\"/>\r\n    </head>\r\n    <body>\r\n    \r\n  ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private static java.lang.String  _wl_block4 ="\r\n       \r\n    \r\n       ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private static java.lang.String  _wl_block5 ="\r\n      \r\n      ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private static java.lang.String  _wl_block6 ="\r\n       ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private static java.lang.String  _wl_block7 ="\r\n       \r\n       ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private static java.lang.String  _wl_block8 ="\r\n      \r\n       ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private static java.lang.String  _wl_block9 ="\r\n   \r\n       ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private static java.lang.String  _wl_block10 ="\r\n      ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private static java.lang.String  _wl_block11 ="\r\n     \r\n     ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private static java.lang.String  _wl_block12 ="\r\n    \r\n        ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private static java.lang.String  _wl_block13 ="\r\n    </body>\r\n</html>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            org.sun.Library.Controler.Book.Book book= null;synchronized(session){
                book=(org.sun.Library.Controler.Book.Book)pageContext.getAttribute("book",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(book==null){
                    book=new org.sun.Library.Controler.Book.Book();
                    pageContext.setAttribute("book",book,javax.servlet.jsp.PageContext.SESSION_SCOPE);
                    _bw.write(_wl_block4Bytes, _wl_block4);
                    org.sun.Library.Bean.BookSpec bookSpec= null;{
                        bookSpec=(org.sun.Library.Bean.BookSpec)pageContext.getAttribute("bookSpec");
                        if(bookSpec==null){
                            bookSpec=new org.sun.Library.Bean.BookSpec();
                            pageContext.setAttribute("bookSpec",bookSpec);
                            _bw.write(_wl_block5Bytes, _wl_block5);
                            org.sun.Library.Controler.Member.Author author= null;{
                                author=(org.sun.Library.Controler.Member.Author)pageContext.getAttribute("author");
                                if(author==null){
                                    author=new org.sun.Library.Controler.Member.Author();
                                    pageContext.setAttribute("author",author);
                                    _bw.write(_wl_block6Bytes, _wl_block6);
                                    org.sun.Library.Bean.PersonInfo authorInfo= null;{
                                        authorInfo=(org.sun.Library.Bean.PersonInfo)pageContext.getAttribute("authorInfo");
                                        if(authorInfo==null){
                                            authorInfo=new org.sun.Library.Bean.PersonInfo();
                                            pageContext.setAttribute("authorInfo",authorInfo);
                                            _bw.write(_wl_block6Bytes, _wl_block6);
                                            {authorInfo.setName(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${param.author}",java.lang.String.class,pageContext,_jspx_fnmap));
                                            }_bw.write(_wl_block6Bytes, _wl_block6);
                                            {authorInfo.setId(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${authorView[param.author]}",java.lang.Object.class,pageContext,_jspx_fnmap));
                                            }_bw.write(_wl_block6Bytes, _wl_block6);

                                        }
                                    }
                                    _bw.write(_wl_block7Bytes, _wl_block7);
                                    {author.setInfo(( org.sun.Library.Bean.PersonInfo ) weblogic.servlet.jsp.ELHelper.evaluate("${pageScope.authorInfo}",org.sun.Library.Bean.PersonInfo.class,pageContext,_jspx_fnmap));
                                    }_bw.write(_wl_block6Bytes, _wl_block6);

                                }
                            }
                            _bw.write(_wl_block8Bytes, _wl_block8);
                            org.sun.Library.Controler.Member.Publisher publisher= null;{
                                publisher=(org.sun.Library.Controler.Member.Publisher)pageContext.getAttribute("publisher");
                                if(publisher==null){
                                    publisher=new org.sun.Library.Controler.Member.Publisher();
                                    pageContext.setAttribute("publisher",publisher);
                                    _bw.write(_wl_block6Bytes, _wl_block6);
                                    org.sun.Library.Bean.PersonInfo publishInfo= null;{
                                        publishInfo=(org.sun.Library.Bean.PersonInfo)pageContext.getAttribute("publishInfo");
                                        if(publishInfo==null){
                                            publishInfo=new org.sun.Library.Bean.PersonInfo();
                                            pageContext.setAttribute("publishInfo",publishInfo);
                                            _bw.write(_wl_block6Bytes, _wl_block6);
                                            {publishInfo.setName(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${param.publisher}",java.lang.String.class,pageContext,_jspx_fnmap));
                                            }_bw.write(_wl_block6Bytes, _wl_block6);
                                            {publishInfo.setId(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${publisherView[param.publisher]}",java.lang.Object.class,pageContext,_jspx_fnmap));
                                            }_bw.write(_wl_block6Bytes, _wl_block6);

                                        }
                                    }
                                    _bw.write(_wl_block8Bytes, _wl_block8);
                                    {publisher.setInfo(( org.sun.Library.Bean.PersonInfo ) weblogic.servlet.jsp.ELHelper.evaluate("${pageScope.publishInfo}",org.sun.Library.Bean.PersonInfo.class,pageContext,_jspx_fnmap));
                                    }_bw.write(_wl_block6Bytes, _wl_block6);

                                }
                            }
                            _bw.write(_wl_block9Bytes, _wl_block9);
                            {java.lang.String __value = request.getParameter("isbn");

                                if ((__value != null) && !__value.equals((java.lang.Object)""))bookSpec.setIsbn(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"isbn"));
                            }_bw.write(_wl_block6Bytes, _wl_block6);
                            {java.lang.String __value = request.getParameter("title");

                                if ((__value != null) && !__value.equals((java.lang.Object)""))bookSpec.setTitle(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"title"));
                            }_bw.write(_wl_block6Bytes, _wl_block6);
                            {java.lang.String __value = request.getParameter("subject");

                                if ((__value != null) && !__value.equals((java.lang.Object)""))bookSpec.setSubject(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"subject"));
                            }_bw.write(_wl_block6Bytes, _wl_block6);
                            {java.lang.String __value = request.getParameter("price");

                                if ((__value != null) && !__value.equals((java.lang.Object)""))bookSpec.setPrice(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"price"));
                            }_bw.write(_wl_block6Bytes, _wl_block6);
                            {java.lang.String __value = request.getParameter("publishDate");

                                if ((__value != null) && !__value.equals((java.lang.Object)""))bookSpec.setPublishDate(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType(__value, java.lang.String.class,"publishDate"));
                            }_bw.write(_wl_block6Bytes, _wl_block6);
                            {bookSpec.setAuthor(( org.sun.Library.Controler.Member.Author ) weblogic.servlet.jsp.ELHelper.evaluate("${pageScope.author}",org.sun.Library.Controler.Member.Author.class,pageContext,_jspx_fnmap));
                            }_bw.write(_wl_block6Bytes, _wl_block6);
                            {bookSpec.setPublisher(( org.sun.Library.Controler.Member.Publisher ) weblogic.servlet.jsp.ELHelper.evaluate("${pageScope.publisher}",org.sun.Library.Controler.Member.Publisher.class,pageContext,_jspx_fnmap));
                            }_bw.write(_wl_block10Bytes, _wl_block10);

                        }
                    }
                    _bw.write(_wl_block9Bytes, _wl_block9);
                    org.sun.Library.Controler.Book.Category category= null;{
                        category=(org.sun.Library.Controler.Book.Category)pageContext.getAttribute("category");
                        if(category==null){
                            category=new org.sun.Library.Controler.Book.Category();
                            pageContext.setAttribute("category",category);
                            _bw.write(_wl_block6Bytes, _wl_block6);
                            {category.setName(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${param.category}",java.lang.String.class,pageContext,_jspx_fnmap));
                            }_bw.write(_wl_block6Bytes, _wl_block6);
                            {category.setId(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${categoryView[param.category]}",java.lang.Object.class,pageContext,_jspx_fnmap));
                            }_bw.write(_wl_block6Bytes, _wl_block6);

                        }
                    }
                    _bw.write(_wl_block11Bytes, _wl_block11);
                    {java.lang.String __value = request.getParameter("copies");

                        if ((__value != null) && !__value.equals((java.lang.Object)""))book.setCopies(java.lang.Integer.valueOf( weblogic.utils.StringUtils.valueOf(__value)).intValue());
                    }_bw.write(_wl_block6Bytes, _wl_block6);
                    {book.setBookSpec(( org.sun.Library.Bean.BookSpec ) weblogic.servlet.jsp.ELHelper.evaluate("${pageScope.bookSpec}",org.sun.Library.Bean.BookSpec.class,pageContext,_jspx_fnmap));
                    }_bw.write(_wl_block6Bytes, _wl_block6);
                    {book.setCategory(( org.sun.Library.Controler.Book.Category ) weblogic.servlet.jsp.ELHelper.evaluate("${pageScope.category}",org.sun.Library.Controler.Book.Category.class,pageContext,_jspx_fnmap));
                    }_bw.write(_wl_block12Bytes, _wl_block12);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
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
         org.apache.taglibs.standard.tag.rt.core.RedirectTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.RedirectTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.setParentForClassicTag(__tag0, parent);
        __tag0.setUrl(( java.lang.String) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("addBook", java.lang.String.class,"url"));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
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
}
