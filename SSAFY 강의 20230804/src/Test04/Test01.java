package Test04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import com.google.gson.Gson;

public class Test01 {

	public static void main(String[] args) throws IOException {
		// 파일 읽어오기
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/refrigerator.json")));
		StringBuilder sb = new StringBuilder();
		String str = null;
		
		while((str = br.readLine()) != null) {
			sb.append(str).append("\n");
		}
		
		// json -> 객체배열
		Gson gson = new Gson();
		Refrigerator[] arr = gson.fromJson(sb.toString(), Refrigerator[].class);
		System.out.println(Arrays.toString(arr));
		
		// 객체 수정
		arr[1].setPrice(2_000_000);
		
		// 파일 저장하기
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/refrigerator-new.json")));
		String str2 = gson.toJson(arr);
		bw.write(str2);
		bw.close();
		
	}
	
}
