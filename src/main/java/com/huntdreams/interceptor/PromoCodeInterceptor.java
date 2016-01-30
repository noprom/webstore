package com.huntdreams.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * PromoCode 访问权限控制
 * Created by noprom on 1/30/16.
 */
public class PromoCodeInterceptor extends HandlerInterceptorAdapter {

    private String promoCode;//code
    private String errorRedirect;//错误跳转
    private String offerRedirect;//正确跳转

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
        String givenPromoCode = request.getParameterValues("promo") == null ? "" : request.getParameterValues("promo")[0];
        if (request.getRequestURI().endsWith("products/specialOffer")) {
            if (givenPromoCode.equals(promoCode)) {
                response.sendRedirect(request.getContextPath() + "/" + offerRedirect);
            } else {
                response.sendRedirect(errorRedirect);
            }
            return false;
        }
        return true;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getErrorRedirect() {
        return errorRedirect;
    }

    public void setErrorRedirect(String errorRedirect) {
        this.errorRedirect = errorRedirect;
    }

    public String getOfferRedirect() {
        return offerRedirect;
    }

    public void setOfferRedirect(String offerRedirect) {
        this.offerRedirect = offerRedirect;
    }
}
