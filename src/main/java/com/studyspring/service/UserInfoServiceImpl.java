package com.studyspring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studyspring.dao.UserInfoDao;
import com.studyspring.vo.UserInfoEnrollRequestVO;
import com.studyspring.vo.UserInfoVO;

@Service  //Service���� ServiceImpl�� ������־���� 
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
	UserInfoDao userInfoDao;
	
	@Override
	public String searchNameService(Map<String, Object> info) {
		return userInfoDao.searchNameDao(info);
	}

	@Override
	public int enrollUserInfoService(UserInfoEnrollRequestVO userInfoEnrollRequestVO) {
		return 0;
	}

	@Override
	public List<UserInfoVO> getUserInfoListService() {  //ServiceImpl => UserInfoDao
		return userInfoDao.getUserInfoListDao();
	}

	@Override
	public List<Map<String, Object>> searchUserInfoDBService(Map<String, Object> params) {
		System.out.println("����");
		System.out.println(params);
		return userInfoDao.searchUserInfoDBDao(params);
	}
	// Select�� ���̺��� ��ȯ��. �׷��� list�� ��ȯ
	// insert, update�� delete�� int�� ��ȯ
	// sql���� update�� delete�� �Է��ϸ� 3 rows delete�� ��ȯ��. �� ���� 
	@Override
	public int updateUserInfoDBService(Map<String, Object> params) {
		return userInfoDao.updateUserInfoDBDao(params);
	}

	@Override
	public int deleteUserInfoDBService(Map<String, Object> params) {
		System.out.println("���� : " + params);
		return userInfoDao.deleteUserInfoDBDao(params);
	}


}
