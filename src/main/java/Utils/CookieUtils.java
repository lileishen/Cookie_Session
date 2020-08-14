package Utils;

import javax.servlet.http.Cookie;

/**
 * @author nono
 * @Package Utils
 * @ClassName CookieUtils.java
 * @Description TODO
 * @createTime 2020年08月14日 20:30:00
 */
public class CookieUtils {
    /**
     *
     * @param name
     * @param cookies
     * @return
     */
   public static Cookie findCookie(String name,Cookie[] cookies){
       if (name==null||cookies==null||cookies.length==0){
           return null;
       }
       for (Cookie cookie : cookies) {
           if (name.equals(cookie.getName())){
               return cookie;
           }
       }
       return null;
   }
}
