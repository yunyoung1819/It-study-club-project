package com.studyspring.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.studyspring.service.UserInfoService;

@Controller
public class AjaxController {
	
	@Autowired  
	UserInfoService userInfoService;
	
	//Study 10//
		@RequestMapping(value = "/enrollajax", method = RequestMethod.POST)	//post로 데이터를 들어옴 form 방식의 전송이기 때문에 produces = {"application/json"}은 빼줌. 파일은 binary 형식
		@ResponseBody
		public Map<String, Object> enrollStudent(MultipartHttpServletRequest multi) {
			// 파일 업로드를 위해서 MultipartHttpServletRequest를 씀
			Map<String, Object> retVal = new HashMap<String, Object>();
			
			System.out.println("------------------<<File Upload>>---------------------");

			// 저장 경로 설정
			String root = multi.getSession().getServletContext().getRealPath("/");
			String path = root + "resources/upload/";

			File dir = new File(path);

			// 디렉토리가 없을 경우 예외처리
			if (!dir.isDirectory()) {
				dir.mkdir();
			}

			// 전송된 파일들(getFileNames)을 불러오기 위한 반복자(Formdata 탐색)//
			Iterator<String> files = multi.getFileNames();

			while (files.hasNext()) {
				String uploadFile = files.next();
	           
			    MultipartFile mFile = multi.getFile(uploadFile);
			    
			    String fileName_original = mFile.getOriginalFilename();
			    //현재 프로젝트(서버)의 resources 경로//
			    String file_save_path = "D:\\workspace-sts-3.8.2.RELEASE_STUDYCLUB\\StudySpring\\src\\main\\webapp\\resources\\upload\\";
			    // linux나 macOS는 역슬래시를 하나 붙임. window는 역슬래시를 두개씩 붙여야함
			    try {
			    	mFile.transferTo(new File(file_save_path+fileName_original));
			    	
			    	System.out.println("전송된 파일 이름 : " +fileName_original);
				    //System.out.println("파일 이름: " + newFileName);
				    System.out.println("파일 사이즈: " + mFile.getSize());
					
					System.out.println("------------------------------------------------------");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// 파일 이외의 text데이터//
			System.out.println("subject: " + multi.getParameter("subject"));
			System.out.println("content: " + multi.getParameter("content"));
		
			retVal.put("retVal", "true");
			
			return retVal;
		}
		
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
