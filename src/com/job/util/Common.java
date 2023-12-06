package com.job.util;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Common {

    /*
    认证使用cookie
 */
    private static final String jobCookie = "jobCookie";

    public static String[] getUserInfoFromCookies(HttpServletRequest req){
        Cookie[] cookies = req.getCookies();
        if (cookies == null){
            return null;
        }
        for (Cookie cookie: cookies){
            if(cookie.getName().equals(jobCookie)){
                String userInfo;
                try {
                    userInfo = Base64Util.decryBASE64(cookie.getValue());
                    String[] userInfoArray = userInfo.split("==");
                    if (userInfoArray.length != 3){
                        return null;
                    }
                    try {
                        Integer.parseInt(userInfoArray[1]);
                    } catch (Exception e){
                        return null;
                    }
                    System.out.println("解密后信息:\t" + userInfo);
                    return userInfoArray;
                } catch (Exception e) {
                    System.out.println("验证失败");
                }
            }
        }
        return null;
    }
}
