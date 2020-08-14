package Servlet;

import Utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author nono
 * @Package Servlet
 * @ClassName CookieServlet.java
 * @Description TODO
 * @createTime 2020年08月14日 19:41:00
 */
public class CookieServlet extends BaseServlet {



    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     Cookie cookie =new Cookie("path1","path1");
     cookie.setPath(req.getContextPath()+"/abc");
     resp.addCookie(cookie);
    }

    protected void deleteCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie cookie = CookieUtils.findCookie("key2", cookies);
        if (cookie!=null){
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            resp.getWriter().write("Cookie被删除了");
        }
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*
//        1.先创建一个要修改的同名的Cookie对象
        Cookie cookie = new Cookie("key1", "newval1");
//        2.在构造器，同时赋予新的Cookie值
        resp.addCookie(cookie); //通知客户端保存并修改
//        3.调用response.addCookie(Cookie);
        resp.getWriter().write("Cookie的值修改了");

*/
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if ("key1".equals(cookie.getName())){
                cookie.setValue("newkey2");
                break;
            }
        }

        resp.getWriter().write("Cookie的值被我修改了");

    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br/>");
        }

        //获取你想要的Cookie
        Cookie iWantCookie = CookieUtils.findCookie("key1", cookies);
        resp.getWriter().write("你想要的Cookie[" + iWantCookie.getName() + "=" + iWantCookie.getValue() + "]");

    }

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Cookie 对象
        Cookie cookie = new Cookie("key1", "value1");
        Cookie cookie2 = new Cookie("key2", "value2");
        Cookie cookie3 = new Cookie("key3", "value3");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);
        resp.getWriter().write("Cookie 创建成功");


    }
}
