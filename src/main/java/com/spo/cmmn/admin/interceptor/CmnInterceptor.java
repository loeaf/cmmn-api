package com.spo.cmmn.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spo.cmmn.admin.comm.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CmnInterceptor implements HandlerInterceptor {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static final String SESSION_NAME = "SessionDTO";
	
	@Autowired
    CommonService commonService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		
		// 세션 가져오기
//		ObjectMapper mapper = new ObjectMapper();
//		SessionDTO sessionDto = mapper.convertValue(request.getSession().getAttribute(SESSION_NAME), SessionDTO.class);
//		
//		if(sessionDto == null) {//NULL일 시 에러페이지로 이동
//			throw new Exception("로그인 정보 호출 실패: SESSION FAILL");
//		}else {//권한 체크 후 해당 권한없으면 에러 에러 배출
//			HashMap<String, Object> params = new HashMap<>();
//			params.put("userId", sessionDto.getSession_usrid());
//			params.put("uri", request.getRequestURI());
//			
//			Boolean checked = commonService.checkUserTrnscAuthrt(params);
//			
//			if(!checked) {
//				throw new Exception("권한 체크 실패 (권한없음): AUTHRT CHECKED FAILL");
//			}
//		}

		logger.info("**************************************** CommonInterceptor preHandle START **********************************");
		logger.debug("request.getRequestURL() ================== "+request.getRequestURL());
		logger.info("**************************************** CommonInterceptor preHandle END **********************************");
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		try {
			logger.info("**************************************** CommonInterceptor postHandle START **********************************");
			logger.info("**************************************** CommonInterceptor postHandle END **********************************");
	
			HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
