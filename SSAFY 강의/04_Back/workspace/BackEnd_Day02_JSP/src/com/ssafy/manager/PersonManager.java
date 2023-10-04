package com.ssafy.manager;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Person;

public class PersonManager {
	private List<Person> list = new ArrayList<>();
	
	private static PersonManager manager = new PersonManager();
	
	private PersonManager() {
	}
	
	public static PersonManager getInstance()	{
		return manager;
	}
	
	public void regist(Person p) {
		list.add(p);
	}
	
	
	public List<Person> getAll(){
		return list;
	}
	
	//그밖의 다른 기능들을 만들수 있다....
	
	
	
}
