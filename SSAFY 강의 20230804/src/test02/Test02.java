package test02;

import com.google.gson.Gson;

public class Test02 {
	public static void main(String[] args) {
		Gson gson = new Gson();
		String str = "{\"name\":\"한재훈\",\"age\":20,\"hobbies\":[\"자바\",\"알고리즘\",\"자바스크립트\"]}";
		
		
		Person p = gson.fromJson(str, Person.class);
		System.out.println(p);
		
	}

}
