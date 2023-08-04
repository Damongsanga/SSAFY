package Test03;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Test01 {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person("A", 20));
		list.add(new Person("B", 20));
		list.add(new Person("C", 20));
		list.add(new Person("D", 20));
		list.add(new Person("E", 20));
		list.add(new Person("F", 20));
		list.add(new Person("G", 20));
		list.add(new Person("H", 20));
		
		System.out.println(list);
		
		Gson gson = new Gson();
		String str = gson.toJson(list);
		System.out.println(str);
		
	}

}
