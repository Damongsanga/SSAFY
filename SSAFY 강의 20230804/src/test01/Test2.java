package test01;

import com.google.gson.Gson;

public class Test2 {
	public static void main(String[] args) {
		// json 문자열 => 자바 객철로
		// gson.fromJson("문자열",..)
		
		Gson gson = new Gson();
		
		String str1 = "{\"name\":\"유승호\",\"age\":10}";
		String str2 = "{\"name\":\"이주원\",\"age\":20}";
		String str3 = "{\"name\":\"안상준\",\"age\":30}";
		
		// 문자열 객체와 person이라는 클래스 정보를 입력
		Person p1 = gson.fromJson(str1, Person.class);
		Person p2 = gson.fromJson(str2, Person.class);
		Person p3 = gson.fromJson(str3, Person.class);
		
		// to String override 결과 출력
		System.out.println(p1); 
		System.out.println(p2);
		System.out.println(p3);
		
	}

}
