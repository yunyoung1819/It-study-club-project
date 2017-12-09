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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserInfoVO> getUserInfoListService() {  //ServiceImpl => UserInfoDao
		return userInfoDao.getUserInfoListDao();
	}

	/*@Override
	public int deleteUserInfoService(UserInfoDeleteRequestVO userInfoDeleteRequestVO) {
		return userInfoDao.deleteUserInfoDao(userInfoDeleteRequestVO);
	}*/
}
