package com.studyspring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.studyspring.service.UserInfoService;
import com.studyspring.vo.UserInfoEnrollRequestVO;

@Controller
public class MainController {
	// @Autowired 위치는 class 아래에 온다. DI 자동연결
	@Autowired  
	UserInfoService userInfoService;  //UserInfoService 인터페이스를 Autowired를 해주면 DI에 의해 실제로는 UserInfoServiceImpl이 동작.
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET) //.do로 url을 명명하면 해킹을 하더라도 jsp 파일을 볼 수 없기 때문에 .do로 명명하는 것이 안전하다.
	public ModelAndView main(ModelAndView mv) {	
		// Model : Controller랑 View를 매핑해준다. 그러나 Model보다 ModelAndView를 권장함
		// model의 return 값은 String이기 때문에 찾기 힘듬.
		mv.setViewName("main");  //setViewName으로 내가 출력할 View 이름을 지정함.
		//modelAndView : 기존에는 model이라는 것을 썼는데 리턴 타입이 String이라 어떤 View인지 찾기 힘듬.
		// modelAndView는 setViewName이나 addObject 같은 메소드를 지원해주기 때문에 더 권장함. 
		
		//study 1
		mv.addObject("modelvalue", "Hello Spring");
		
		//study 2
		mv.addObject("value1", "5");
		mv.addObject("value2", "6");
		
		//study 3
		Map<String, Object> info = new HashMap<String, Object>();
		// Map은 new를 해도 사용자가 만든 것이 아니라 시스템에서 만든 것이기 때문에 Heap Memory에 저장되지 않는다.
		// 따라서 Map을 권장
		info.put("name", "yunyoung");

		mv.addObject("searchname", userInfoService.searchNameService(info));
		
		//study 4
		UserInfoEnrollRequestVO userInfoEnrollRequestVO = new UserInfoEnrollRequestVO();
		Map<String, Object> result = new HashMap<String, Object>();
		
		userInfoEnrollRequestVO.setUserName("Yun Young");
		userInfoEnrollRequestVO.setUserAge(30);
		userInfoEnrollRequestVO.setUserImage("sampleimage1.png");
		// @RequestBody를 이용하면 setter 작업을 안해도 됨.  
		
		if(userInfoService.enrollUserInfoService(userInfoEnrollRequestVO) == 1){
			result.put("flag", "success");
		}else{
			result.put("flag", "fail");
		}
		
		mv.addObject("result", result);
		
		return mv;
	}
	
}
