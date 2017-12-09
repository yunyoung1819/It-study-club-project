package com.studyspring.service;

import java.util.List;
import java.util.Map;

import com.studyspring.vo.UserInfoEnrollRequestVO;
import com.studyspring.vo.UserInfoVO;

public interface UserInfoService {
	public String searchNameService(Map<String, Object> info); // ���յ��� ���߰� �������� ��������
	public int enrollUserInfoService(UserInfoEnrollRequestVO userInfoEnrollRequestVO);
	public List<UserInfoVO> getUserInfoListService();  //Service => ServiceImpl
	//public int deleteUserInfoService(UserInfoDeleteRequestVO userInfoDeleteRequestVO);
}
