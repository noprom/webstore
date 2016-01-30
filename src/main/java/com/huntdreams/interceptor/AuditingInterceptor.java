package com.huntdreams.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

/**
 * 记录用户操作的Interceptor
 * Created by noprom on 1/30/16.
 */
public class AuditingInterceptor extends HandlerInterceptorAdapter {

    Logger logger = Logger.getLogger("auditLogger");//logger
    private String user;//用户
    private String productId;//商品id

    /**
     * 初始化
     * @param request request
     * @param response response
     * @param handler handler
     * @return true
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURI().endsWith("products/add") && request.getMethod().equals("POST")) {
            user = request.getRemoteUser();
            productId = request.getParameterValues("productId")[0];
        }
        return true;
    }

    /**
     * 记录到logger
     * @param request request
     * @param response response
     * @param handler handler
     * @param ex ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (request.getRequestURI().endsWith("products/add") && response.getStatus() == 302) {
            logger.info(String.format("A new product[%s] added by %s on %s", productId, user, getCurrentTime()));
        }
    }

    /**
     * 获得当前时间
     * @return 当前时间
     */
    private String getCurrentTime() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd 'at' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return format.format(calendar.getTime());
    }
}
