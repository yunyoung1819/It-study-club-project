package com.studyspring.service;

import java.util.Map;

import com.studyspring.vo.UserInfoEnrollRequestVO;

public interface UserInfoService {
	public String searchNameService(Map<String, Object> info); // ���յ��� ���߰� �������� ��������

	public int enrollUserInfoService(UserInfoEnrollRequestVO userInfoEnrollRequestVO);
}
