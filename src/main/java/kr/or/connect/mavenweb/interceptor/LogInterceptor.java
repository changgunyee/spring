package kr.or.connect.mavenweb.interceptor;

import java.sql.*;
import java.text.*;

import javax.servlet.http.*;

import org.slf4j.*;
import org.springframework.web.method.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.handler.*;

public class LogInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
    	
    	String controllerName = "";
		String actionName = "";
    	if( handler instanceof HandlerMethod ) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			controllerName  = handlerMethod.getBeanType().getSimpleName().replace("Controller", "");
			actionName = handlerMethod.getMethod().getName();
		}

		logger.debug("컨트롤러 : {} 액션: {} ", controllerName, actionName);	
    	
	}
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
		long now= System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String nowStr=dayTime.format(new Date(now));
		
        logger.debug("요청 URL:{}, 시간:{}, 클라이언트ip:{} ",request.getRequestURL(),nowStr,request.getRemoteAddr());
        System.out.print(""+request.getRemoteAddr()+request.getRequestURL());
        return true;
    }


}