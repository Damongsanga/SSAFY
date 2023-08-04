package Test03;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class Test03 {
	public static void main(String[] args) {
		String str = "[{\"name\":\"A\",\"age\":20},{\"name\":\"B\",\"age\":20},{\"name\":\"C\",\"age\":20},{\"name\":\"D\",\"age\":20},{\"name\":\"E\",\"age\":20},{\"name\":\"F\",\"age\":20},{\"name\":\"G\",\"age\":20},{\"name\":\"H\",\"age\":20}]";
		
		// 바로 list로 만드려면..
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<Person>>() {}.getType();
		List<Person> list = gson.fromJson(str, listType);
		System.out.println(list);
	
	}
}
