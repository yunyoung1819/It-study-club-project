package com.studyspring.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository  //Dao임을 Impl에다 명시해줘야함. 저장소에 연관된 얘라 @Repository로 해야함. 이걸 해놓으면 속도가 빠름
public class UserInfoDaoImpl implements UserInfoDao{
	@Override
	public String searchNameDao(Map<String, Object> info) {
		
		System.out.println("user dao call (search name:" + info.get("name").toString() + ")");
		
		String name = info.get("name").toString() + "!!";
		
		return name;
	}

}
