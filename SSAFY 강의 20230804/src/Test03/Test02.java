package Test03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class Test02 {
	public static void main(String[] args) {
		String str = "[{\"name\":\"A\",\"age\":20},{\"name\":\"B\",\"age\":20},{\"name\":\"C\",\"age\":20},{\"name\":\"D\",\"age\":20},{\"name\":\"E\",\"age\":20},{\"name\":\"F\",\"age\":20},{\"name\":\"G\",\"age\":20},{\"name\":\"H\",\"age\":20}]";
		Gson gson = new Gson();
		Person[] arr = gson.fromJson(str, Person[].class);
		
		// 출력 1.
		System.out.println(Arrays.toString(arr));
		
		// 출력 2.
		List<Person> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		System.out.println(list);
		
	}

}
