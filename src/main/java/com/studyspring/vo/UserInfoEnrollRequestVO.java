package com.studyspring.vo;

// VO는 클래스로 만든다
// 리퀘스틀 던질 객체이다.
// VO는 두개 다 대문자로 명명한다 (명명규칙)
public class UserInfoEnrollRequestVO {
	private String userName;
	private int userAge;
	private String userImage;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
}
