package test01;
import com.google.gson.Gson;

public class Test {
	
	// 외부 라이브러리 (GSON) 인식시키기
	// 1. JRE System Library에 끼워 넣기 (권장되지 않음)
	// 2. 프로젝트 외부에 있는 jar 파일 인식시키기
	// 	- 프로젝트를 이사할 때 외부 파일은 인식되지 않을 수 있음
	// 3. 프로젝트 내부로 jar 파일을 복사하고 인식시키기
	// 	- 프로젝트 우클릭 => Build path => Configure build path => Library 탭 => add jars
	// 4. Maven 프로젝트로 변경 후 pom.xml에 dependency 추가
	// 아래 코드는 3번으로 진행
	
	// gson.jar => lib 폴더
	// refrigerator.json => data 폴더
	
	public static void main(String[] args) {
		Gson gson = new Gson();
		
		// 객체 -> json 문자열
		
		Person p1 = new Person("유승호", 10);
		Person p2 = new Person("이주원", 20);
		Person p3 = new Person("안상준", 30);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		
		
		String p1str = gson.toJson(p1);
		String p2str = gson.toJson(p2);
		String p3str = gson.toJson(p3);
		
		System.out.println(p1str);
		System.out.println(p2str);
		System.out.println(p3str);
		
	}
}
