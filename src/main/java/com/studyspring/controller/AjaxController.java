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
		
		System.out.println("ajax call : " + params.get("searchName") + "," 
		          + params.get("searchAge") + "," + params.get("searchNo"));
		
		retVal.put("val", userInfoService.searchUserInfoDBService(params));
		
		return retVal;
	}
	
	//update
	@RequestMapping(value = "/updateuserdb", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> updateUserDB(@RequestBody Map<String, Object> params){
		// ResponseBody : Map 방식으로 반환
		// RequestBody : 파라미터로 Map 전달
		Map<String, Object> retVal = new HashMap<String, Object>();
		
		System.out.println("ajax call : " + params.get("updateName") + "," + params.get("updateAge"));
		
		retVal.put("resultCode", userInfoService.updateUserInfoDBService(params));
		
		return retVal;
	}
	
	//deleteuserdb
	@RequestMapping(value = "/deleteuserdb", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> deleteUserDB(@RequestBody Map<String, Object> params){
		// ResponseBody : Map 방식으로 반환
		// RequestBody : 파라미터로 Map 전달
		Map<String, Object> retVal = new HashMap<String, Object>();
		
		System.out.println("ajax call : " + params.get("deleteName") + "," + params.get("deleteAge"));
		
		retVal.put("resultCode", userInfoService.deleteUserInfoDBService(params));
		
		return retVal;
	}
} 
