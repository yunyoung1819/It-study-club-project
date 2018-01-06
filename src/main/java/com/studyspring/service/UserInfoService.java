package com.studyspring.service;

import java.util.List;
import java.util.Map;

import com.studyspring.vo.UserInfoEnrollRequestVO;
import com.studyspring.vo.UserInfoVO;

public interface UserInfoService {
	
	public String searchNameService(Map<String, Object> info); // ���յ��� ���߰� �������� ��������
	public int enrollUserInfoService(UserInfoEnrollRequestVO userInfoEnrollRequestVO);
	public List<UserInfoVO> getUserInfoListService();  //Service => ServiceImpl
	public List<Map<String, Object>> searchUserInfoDBService(Map<String, Object> params);
	public int updateUserInfoDBService(Map<String, Object> params);
	public int deleteUserInfoDBService(Map<String, Object> params);
}
