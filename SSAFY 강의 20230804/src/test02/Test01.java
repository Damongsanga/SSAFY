package test02;

import com.google.gson.Gson;

public class Test01 {
public static void main(String[] args) {
	
	Gson gson = new Gson();
	
	Person p = new Person("한재훈", 20, new String[] {"자바", "알고리즘", "자바스크립트"});
	String str = gson.toJson(p);
	System.out.println(str);
	
}
}
