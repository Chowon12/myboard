package com.myboard.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
 
public class SessionInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		 	HttpSession session = request.getSession(false);
//		 	if (session == null || session.getAttribute("userId") == null) {
//				response.sendRedirect("/main");
//				return true;
//			}
//		// false : 컨트롤러 실행x
		return true;
	}
	//컨트롤러에서 수행전에 pre 수행후에 post
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	//모든작업이 다 끝난후에 작동
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("새로고침 확인용 afterCompletion");
	}
}
