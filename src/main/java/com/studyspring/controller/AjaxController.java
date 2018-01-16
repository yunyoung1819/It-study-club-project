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
		@RequestMapping(value = "/enrollajax", method = RequestMethod.POST)	//post�� �����͸� ���� form ����� �����̱� ������ produces = {"application/json"}�� ����. ������ binary ����
		@ResponseBody
		public Map<String, Object> enrollStudent(MultipartHttpServletRequest multi) {
			// ���� ���ε带 ���ؼ� MultipartHttpServletRequest�� ��
			Map<String, Object> retVal = new HashMap<String, Object>();
			
			System.out.println("------------------<<File Upload>>---------------------");

			// ���� ��� ����
			String root = multi.getSession().getServletContext().getRealPath("/");
			String path = root + "resources/upload/";

			File dir = new File(path);

			// ���丮�� ���� ��� ����ó��
			if (!dir.isDirectory()) {
				dir.mkdir();
			}

			// ���۵� ���ϵ�(getFileNames)�� �ҷ����� ���� �ݺ���(Formdata Ž��)//
			Iterator<String> files = multi.getFileNames();

			while (files.hasNext()) {
				String uploadFile = files.next();
	           
			    MultipartFile mFile = multi.getFile(uploadFile);
			    
			    String fileName_original = mFile.getOriginalFilename();
			    //���� ������Ʈ(����)�� resources ���//
			    String file_save_path = "D:\\workspace-sts-3.8.2.RELEASE_STUDYCLUB\\StudySpring\\src\\main\\webapp\\resources\\upload\\";
			    // linux�� macOS�� �������ø� �ϳ� ����. window�� �������ø� �ΰ��� �ٿ�����
			    try {
			    	mFile.transferTo(new File(file_save_path+fileName_original));
			    	
			    	System.out.println("���۵� ���� �̸� : " +fileName_original);
				    //System.out.println("���� �̸�: " + newFileName);
				    System.out.println("���� ������: " + mFile.getSize());
					
					System.out.println("------------------------------------------------------");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// ���� �̿��� text������//
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
		// ResponseBody : Map ������� ��ȯ
		// RequestBody : �Ķ���ͷ� Map ����
		Map<String, Object> retVal = new HashMap<String, Object>();
		
		System.out.println("ajax call : " + params.get("updateName") + "," + params.get("updateAge"));
		
		retVal.put("resultCode", userInfoService.updateUserInfoDBService(params));
		
		return retVal;
	}
	
	//deleteuserdb
	@RequestMapping(value = "/deleteuserdb", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> deleteUserDB(@RequestBody Map<String, Object> params){
		// ResponseBody : Map ������� ��ȯ
		// RequestBody : �Ķ���ͷ� Map ����
		Map<String, Object> retVal = new HashMap<String, Object>();
		
		System.out.println("ajax call : " + params.get("deleteName") + "," + params.get("deleteAge"));
		
		retVal.put("resultCode", userInfoService.deleteUserInfoDBService(params));
		
		return retVal;
	}
} 
