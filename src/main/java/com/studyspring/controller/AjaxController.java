package com.studyspring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.studyspring.service.UserInfoService;

@Controller
public class AjaxController {
	
	@Autowired  
	UserInfoService userInfoService;
	
	// Study 11
	@RequestMapping(value = "/searchuserdb", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> searchUserDB(@RequestBody Map<String, Object> params){
		Map<String, Object> retVal = new HashMap<String, Object>();
		
		System.out.println("ajax call : " + params.get("searchName") + "," + params.get("searchAge") + "," + params.get("searchNo"));
		
		retVal.put("val", userInfoService.searchUserInfoDBService(params));
		
		return retVal;
	}
} 
