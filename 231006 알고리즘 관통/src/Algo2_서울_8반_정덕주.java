import java.util.*;

public class Algo2_서울_8반_정덕주 {
	
	static int[] rr = {-1,0,1,0};
	static int[] rc = {0,1,0,-1};
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int[][] arr = new int[5][10];
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 10; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			answer = 0; // 답 초기화
			permutation(0, new int[5][10], new boolean[5], arr);
			System.out.printf("#%d %d \n", tc, answer);
			
		}
	}
	
	// 놀이판
	// 재귀를 통한 순열
	static void permutation(int depth, int[][] p, boolean[] visited, int[][] arr) {
		
		// 순열을 모두 뽑았으면 BFS 탐색
		if (depth == 5) {
			boolean[][] visitedBFS = new boolean[5][10];
			if (BFS(visitedBFS, p)) answer++; // BFS 탐색하여 경로 존재시 답++
			return;
		}
		
		
		for (int i = 0; i < 5; i++) {
			if (visited[i]) continue; // 이미 뽑았다면 continue;
			visited[i] = true; // 뽑은 수 방문처리
			p[depth] = arr[i];
			permutation(depth+1, p, visited, arr);
			visited[i] = false; // 방문처리 원복
		}
	}
	
	
	static boolean BFS(boolean[][] visitedBFS, int[][] p) {
		
		Queue<Integer[]> queue = new ArrayDeque();
		
		// 초기값 설정
		for (int i = 0; i < 10; i++) {
			if (p[0][i] == 0) {
				queue.add(new Integer[] {0, i});
				visitedBFS[0][i] = true;
			}
		}
		
		while(!queue.isEmpty()) {
			
			Integer[] now = queue.poll();
			int r = now[0]; int c = now[1];
			
			// 마지막 높이까지 도달했으면 구슬은 통과할 수 있음으로 true 반환
			if (r == 4) {
				return true;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = r + rr[i];
				int nc = c + rc[i];
				if (nr < 0 || nc < 0 || nr >= 5 || nc >= 10) continue; // 범위를 벗어나면 continue;
				if (p[nr][nc] == 1) continue; // 지나갈 수 없으면 continue;
				if (visitedBFS[nr][nc]) continue; // 방문했으면 continue;
				visitedBFS[nr][nc] = true;
				queue.add(new Integer[] {nr, nc});
			}
		}
		return false;
	}

}
