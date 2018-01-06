package com.studyspring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studyspring.dao.UserInfoDao;
import com.studyspring.vo.UserInfoEnrollRequestVO;
import com.studyspring.vo.UserInfoVO;

@Service  //Service임을 ServiceImpl에 명시해주어야함 
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
		System.out.println("서비스");
		System.out.println(params);
		return userInfoDao.searchUserInfoDBDao(params);
	}
	// Select는 테이블이 반환됨. 그래서 list로 반환
	// insert, update나 delete는 int로 반환
	// sql에서 update나 delete를 입력하면 3 rows delete가 반환됨. 몇 개의 
	@Override
	public int updateUserInfoDBService(Map<String, Object> params) {
		return userInfoDao.updateUserInfoDBDao(params);
	}

	@Override
	public int deleteUserInfoDBService(Map<String, Object> params) {
		System.out.println("서비스 : " + params);
		return userInfoDao.deleteUserInfoDBDao(params);
	}


}
