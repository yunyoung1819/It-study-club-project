package com.studyspring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.studyspring.vo.UserInfoVO;

@Repository  //Dao임을 Impl에다 명시해줘야함. 저장소에 연관된 얘라 @Repository로 해야함. 이걸 해놓으면 속도가 빠름
public class UserInfoDaoImpl implements UserInfoDao{
	@Override
	public String searchNameDao(Map<String, Object> info) {
		
		System.out.println("user dao call (search name:" + info.get("name").toString() + ")");
		
		String name = info.get("name").toString() + "!!";
		
		return name;
	}

	@Override
	public List<UserInfoVO> getUserInfoListDao() {
		List<UserInfoVO> listuser = new ArrayList<UserInfoVO>();
		
		// DB 작업
		// db가 없으므로 직접 객체를 생성하여 setting함
		
		UserInfoVO user_one = new UserInfoVO();
		user_one.setUserName("프로그래머");
		user_one.setUserAge(30);
		user_one.setUserImage("sample1.png");
		
		listuser.add(user_one);
		
		UserInfoVO user_two = new UserInfoVO();
		user_two.setUserName("소방관");
		user_two.setUserAge(26);
		user_two.setUserImage("sample2.png");
		
		listuser.add(user_two);
		
		UserInfoVO user_three = new UserInfoVO();
		user_three.setUserName("파일럿");
		user_three.setUserAge(28);
		user_three.setUserImage("sample3.png");
		
		listuser.add(user_three);
		
		return listuser;
	}

}
