package org.sun.Library.Tags;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.collections.BidiMap;

import org.apache.commons.collections.OrderedBidiMap;

import org.apache.commons.collections.SortedBidiMap;

import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.apache.commons.collections.map.HashedMap;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Admin.Admin;
import org.sun.Library.Controler.Admin.Admins;
import org.sun.Library.Controler.Admin.AdminView;
import org.sun.Library.Controler.Types.Role;
import org.sun.Library.System.DisplayCategories;

public class View extends BodyTagSupport {
    private Map<Integer, String> display;
    private BidiMap author;
    private BidiMap publisher;
    private BidiMap category;
    private Message<Map<Integer, String>> message;
    private String role = "noName";

    @Override
    public int doStartTag() throws JspException {

       //Admins admin = new AdminView();
      Admin admin = Admin.getInstance();
        message = admin.view(Role.valueOf(role));
        display = message.getMessage();
        
        switch (Role.valueOf(role)) {
        case Author:
            {
                System.out.println("role is  " + role);
                author =new DualHashBidiMap();
                author.putAll(display);
                author=author.inverseBidiMap();
                System.out.println("author id  is  "+author.get("ALI"));
              pageContext.setAttribute("authorView", author,pageContext.SESSION_SCOPE);
            }
            break;
        case Category:
            {
                System.out.println("role is  " + role);
                category =new DualHashBidiMap();
                category.putAll(display);
                category=category.inverseBidiMap();
                Object c =category.get("Java");
                System.out.println("category id  is  "+c);
                pageContext.setAttribute("categoryView", category,pageContext.SESSION_SCOPE);
            }
            break;
        case Publisher:
            {
                System.out.println("role is  " + role);
                publisher =new DualHashBidiMap();
                publisher.putAll(display);
                publisher=publisher.inverseBidiMap();
                System.out.println("publisher id  is  "+publisher.get("mahmoud"));
                pageContext.setAttribute("publisherView", publisher,pageContext.SESSION_SCOPE);
            }
            break;
        }
       pageContext.setAttribute("display", display);
        return EVAL_BODY_INCLUDE;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public int doAfterBody() throws JspException {
//        switch (Role.valueOf(role)) {
//        case Category:
//            {
//                String category = pageContext.getRequest().getParameter("category");
//                System.out.println("category  is " + category);
//                if (category != null && !category.equals(""))
//                    pageContext.setAttribute("category", display.get(category));
//            }
//            break;
//        }
//

        return SKIP_BODY;
    }
}
