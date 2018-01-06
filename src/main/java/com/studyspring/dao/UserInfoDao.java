package com.studyspring.dao;

import java.util.List;
import java.util.Map;

import com.studyspring.vo.UserInfoVO;

public interface UserInfoDao {  //UserInfoDao => UserInfoDaoImpl
	public String searchNameDao(Map<String, Object> info);
	public List<UserInfoVO> getUserInfoListDao();
	public List<Map<String, Object>> searchUserInfoDBDao(Map<String, Object> params);
	public int updateUserInfoDBDao(Map<String, Object> params);
	public int deleteUserInfoDBDao(Map<String, Object> params);
}
