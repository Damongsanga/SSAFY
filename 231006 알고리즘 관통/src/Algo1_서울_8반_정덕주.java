import java.util.Arrays;
import java.util.Scanner;

public class Algo1_서울_8반_정덕주 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		int lcd = 40; // 최소공배수가 lcd.. 맞나요? gcd는 최대 공약수인걸로 알고있는데 헷갈리네용 ㅠ
		
		int[] dp = new int[lcd+1];
		// dp[0]을 제외한 dp를 모두 무한대 값으로 설정,Integer.MAX_VALUE-1 해주는 이유는 오버플로우 방지 
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		dp[0] = 0;
		
		// DP
		// 3,5,8의 최소공배수인 40까지 DP를 저장
		for (int i = 3; i <= lcd; i++) {
			if (i >= 8) dp[i] = Math.min(dp[i-8] + 1, dp[i]);
			if (i >= 5) dp[i] = Math.min(dp[i-5] + 1, dp[i]);
			if (i >= 3) dp[i] = Math.min(dp[i-3] + 1, dp[i]);
		}
		
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= P; tc++) {
			long p = sc.nextLong(); // 지불하고자 하는 금액
			long answer = 0;
			// 만약 해당 금액 최소공배수로 나눈 값이 무한대 값이라면 -1 출력
			// 아니라면 최소공배수만큼 반복될 것임으로 최소 공배수인 40으로 나눈 몫 * 5 (동전의 금액중 최대인 8이 최소공배수동안 반복되는 횟수) 와 나머지를 더함
			if (dp[(int)(p % lcd)] == Integer.MAX_VALUE-1) {
				answer = -1;
			} else {
				answer = p/lcd * 5 + dp[(int)(p % lcd)];
			}
			sb.append("#" + tc + " " + answer + "\n");
		}
		
		System.out.println(sb);
	}
}
