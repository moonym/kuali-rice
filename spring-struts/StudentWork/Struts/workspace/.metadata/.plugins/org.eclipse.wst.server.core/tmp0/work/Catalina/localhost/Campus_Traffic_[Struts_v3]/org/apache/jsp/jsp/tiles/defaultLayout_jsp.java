package org.apache.jsp.jsp.tiles;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class defaultLayout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fhtml;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005fgetAsString_0026_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fhtml_005fhtml = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ftiles_005fgetAsString_0026_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fhtml_005fhtml.release();
    _005fjspx_005ftagPool_005ftiles_005fgetAsString_0026_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      if (_jspx_meth_html_005fhtml_005f0(_jspx_page_context))
        return;
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_html_005fhtml_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:html
    org.apache.struts.taglib.html.HtmlTag _jspx_th_html_005fhtml_005f0 = (org.apache.struts.taglib.html.HtmlTag) _005fjspx_005ftagPool_005fhtml_005fhtml.get(org.apache.struts.taglib.html.HtmlTag.class);
    _jspx_th_html_005fhtml_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005fhtml_005f0.setParent(null);
    int _jspx_eval_html_005fhtml_005f0 = _jspx_th_html_005fhtml_005f0.doStartTag();
    if (_jspx_eval_html_005fhtml_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("<head>\n");
        out.write("<title>");
        if (_jspx_meth_tiles_005fgetAsString_005f0(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
          return true;
        out.write("</title>\n");
        out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
        if (_jspx_meth_tiles_005finsert_005f0(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("</head>\n");
        out.write("<body>\n");
        if (_jspx_meth_tiles_005finsert_005f1(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
          return true;
        out.write('\n');
        if (_jspx_meth_tiles_005finsert_005f2(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("</body>\n");
        int evalDoAfterBody = _jspx_th_html_005fhtml_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_html_005fhtml_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fhtml.reuse(_jspx_th_html_005fhtml_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fhtml.reuse(_jspx_th_html_005fhtml_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005fgetAsString_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:getAsString
    org.apache.struts.tiles.taglib.GetAttributeTag _jspx_th_tiles_005fgetAsString_005f0 = (org.apache.struts.tiles.taglib.GetAttributeTag) _005fjspx_005ftagPool_005ftiles_005fgetAsString_0026_005fname_005fnobody.get(org.apache.struts.tiles.taglib.GetAttributeTag.class);
    _jspx_th_tiles_005fgetAsString_005f0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fgetAsString_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/tiles/defaultLayout.jsp(8,7) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fgetAsString_005f0.setName("title");
    int _jspx_eval_tiles_005fgetAsString_005f0 = _jspx_th_tiles_005fgetAsString_005f0.doStartTag();
    if (_jspx_th_tiles_005fgetAsString_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fgetAsString_0026_005fname_005fnobody.reuse(_jspx_th_tiles_005fgetAsString_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fgetAsString_0026_005fname_005fnobody.reuse(_jspx_th_tiles_005fgetAsString_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsert_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.tiles.taglib.InsertTag _jspx_th_tiles_005finsert_005f0 = (org.apache.struts.tiles.taglib.InsertTag) _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.get(org.apache.struts.tiles.taglib.InsertTag.class);
    _jspx_th_tiles_005finsert_005f0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005finsert_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/tiles/defaultLayout.jsp(10,0) name = attribute type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsert_005f0.setAttribute("head");
    int _jspx_eval_tiles_005finsert_005f0 = _jspx_th_tiles_005finsert_005f0.doStartTag();
    if (_jspx_th_tiles_005finsert_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.reuse(_jspx_th_tiles_005finsert_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.reuse(_jspx_th_tiles_005finsert_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsert_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.tiles.taglib.InsertTag _jspx_th_tiles_005finsert_005f1 = (org.apache.struts.tiles.taglib.InsertTag) _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.get(org.apache.struts.tiles.taglib.InsertTag.class);
    _jspx_th_tiles_005finsert_005f1.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005finsert_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/tiles/defaultLayout.jsp(13,0) name = attribute type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsert_005f1.setAttribute("header");
    int _jspx_eval_tiles_005finsert_005f1 = _jspx_th_tiles_005finsert_005f1.doStartTag();
    if (_jspx_th_tiles_005finsert_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.reuse(_jspx_th_tiles_005finsert_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.reuse(_jspx_th_tiles_005finsert_005f1);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsert_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.tiles.taglib.InsertTag _jspx_th_tiles_005finsert_005f2 = (org.apache.struts.tiles.taglib.InsertTag) _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.get(org.apache.struts.tiles.taglib.InsertTag.class);
    _jspx_th_tiles_005finsert_005f2.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005finsert_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/tiles/defaultLayout.jsp(14,0) name = attribute type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsert_005f2.setAttribute("body");
    int _jspx_eval_tiles_005finsert_005f2 = _jspx_th_tiles_005finsert_005f2.doStartTag();
    if (_jspx_th_tiles_005finsert_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.reuse(_jspx_th_tiles_005finsert_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.reuse(_jspx_th_tiles_005finsert_005f2);
    return false;
  }
}
