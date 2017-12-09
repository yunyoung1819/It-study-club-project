package com.studyspring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.studyspring.vo.UserInfoVO;

@Repository  //Dao���� Impl���� ����������. ����ҿ� ������ ��� @Repository�� �ؾ���. �̰� �س����� �ӵ��� ����
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
		
		// DB �۾�
		// db�� �����Ƿ� ���� ��ü�� �����Ͽ� setting��
		
		UserInfoVO user_one = new UserInfoVO();
		user_one.setUserName("���α׷���");
		user_one.setUserAge(30);
		user_one.setUserImage("sample1.png");
		
		listuser.add(user_one);
		
		UserInfoVO user_two = new UserInfoVO();
		user_two.setUserName("�ҹ��");
		user_two.setUserAge(26);
		user_two.setUserImage("sample2.png");
		
		listuser.add(user_two);
		
		UserInfoVO user_three = new UserInfoVO();
		user_three.setUserName("���Ϸ�");
		user_three.setUserAge(28);
		user_three.setUserImage("sample3.png");
		
		listuser.add(user_three);
		
		return listuser;
	}

}
