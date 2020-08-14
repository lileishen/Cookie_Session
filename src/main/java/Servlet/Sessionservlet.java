package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author nono
 * @Package Servlet
 * @ClassName Sessionservlet.java
 * @Description TODO
 * @createTime 2020年08月14日 19:41:00
 */
public class Sessionservlet extends HttpServlet {

    /**
     * 获取SessioN域中的数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void set(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
