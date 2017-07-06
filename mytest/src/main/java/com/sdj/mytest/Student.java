package com.sdj.mytest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

	private String nickName;
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	private String no = "001";

	private String age = "12";

	private boolean sex = true;

	private String nation = "中国";

	private Date birthday;

	public Student() {
		try
		{
			birthday = new SimpleDateFormat().parse("2006-7-8");
		} catch (Exception e) {

		}
	}

}
