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
	// @Autowired ��ġ�� class �Ʒ��� �´�. DI �ڵ�����
	@Autowired  
	UserInfoService userInfoService;  //UserInfoService �������̽��� Autowired�� ���ָ� DI�� ���� �����δ� UserInfoServiceImpl�� ����.
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET) //.do�� url�� ����ϸ� ��ŷ�� �ϴ��� jsp ������ �� �� ���� ������ .do�� ����ϴ� ���� �����ϴ�.
	public ModelAndView main(ModelAndView mv) {	
		// Model : Controller�� View�� �������ش�. �׷��� Model���� ModelAndView�� ������
		// model�� return ���� String�̱� ������ ã�� ����.
		mv.setViewName("main");  //setViewName���� ���� ����� View �̸��� ������.
		//modelAndView : �������� model�̶�� ���� ��µ� ���� Ÿ���� String�̶� � View���� ã�� ����.
		// modelAndView�� setViewName�̳� addObject ���� �޼ҵ带 �������ֱ� ������ �� ������. 
		
		//study 1
		mv.addObject("modelvalue", "Hello Spring");
		
		//study 2
		mv.addObject("value1", "5");
		mv.addObject("value2", "6");
		
		//study 3
		Map<String, Object> info = new HashMap<String, Object>();
		// Map�� new�� �ص� ����ڰ� ���� ���� �ƴ϶� �ý��ۿ��� ���� ���̱� ������ Heap Memory�� ������� �ʴ´�.
		// ���� Map�� ����
		info.put("name", "yunyoung");

		mv.addObject("searchname", userInfoService.searchNameService(info));
		
		//study 4
		UserInfoEnrollRequestVO userInfoEnrollRequestVO = new UserInfoEnrollRequestVO();
		Map<String, Object> result = new HashMap<String, Object>();
		
		userInfoEnrollRequestVO.setUserName("Yun Young");
		userInfoEnrollRequestVO.setUserAge(30);
		userInfoEnrollRequestVO.setUserImage("sampleimage1.png");
		// @RequestBody�� �̿��ϸ� setter �۾��� ���ص� ��.  
		
		if(userInfoService.enrollUserInfoService(userInfoEnrollRequestVO) == 1){
			result.put("flag", "success");
		}else{
			result.put("flag", "fail");
		}
		
		mv.addObject("result", result);
		
		return mv;
	}
	
}
