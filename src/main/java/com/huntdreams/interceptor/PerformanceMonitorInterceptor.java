package com.huntdreams.interceptor;

import org.apache.commons.lang.time.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

/**
 * Created by noprom on 1/29/16.
 */
public class PerformanceMonitorInterceptor implements HandlerInterceptor {

    ThreadLocal<StopWatch> stopWatchThreadLocal = new ThreadLocal<StopWatch>();
    Logger logger = Logger.getLogger(String.valueOf(this.getClass()));

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatchThreadLocal.set(stopWatch);

        logger.info("Accessing URL path: " + getURLPath(httpServletRequest));
        logger.info("Request processing started on: " + getCurrentTime());
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("Request processing ended on " + getCurrentTime());
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        StopWatch stopWatch = stopWatchThreadLocal.get();
        stopWatch.stop();

        logger.info("Total time taken for processing: " + stopWatch.getTime() + " ms");
        stopWatchThreadLocal.set(null);
        logger.info("==================================================");
    }

    /**
     * 获得当前时间
     * @return
     */
    public String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return dateFormat.format(calendar.getTime());
    }

    /**
     * 获得请求URL
     * @param request
     * @return
     */
    private String getURLPath(HttpServletRequest request) {
        String currentPath = request.getRequestURI();
        String queryString = request.getQueryString();
        queryString = queryString == null ? "" : "?" + queryString;
        return currentPath + queryString;
    }
}
