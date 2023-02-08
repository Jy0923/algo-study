import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14889_2 {

	static int n;
	static int[][] map;
	static int min = Integer.MAX_VALUE; // 최소 경험치차 확인용
	static boolean[] isUsed;
	static StringTokenizer st;
	
	
	public static void recursion(int idx, int depth) {
		
		// 종료조건
		if(depth == n/2) {
			function();
			return;
		}
		
		// 순열이 아닌 조합일 땐, i=idx로 해야 시간초과 X
		for(int i=idx; i<n; i++) {
			if(!isUsed[i]) {
				isUsed[i] = true;
				recursion(i+1, depth + 1);
				isUsed[i] = false;
			}
		}
	}

	// 재귀함수에서 nCn/2 조합의 숫자쌍들을 구한 후 
	// 그 숫자쌍들에 대한 경험치 합치기
	public static void function() {
		
		int start = 0;
		int link = 0;
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(isUsed[i] == true && isUsed[j] == true) {
					start += map[i][j];
					start += map[j][i];
				} else if(isUsed[i] == false && isUsed[j] == false) {
					link += map[i][j];
					link += map[j][i];
				}
			}
		}
		
		min = Math.min(min, Math.abs(start - link));
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		isUsed = new boolean[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recursion(0, 0);
		System.out.println(min);
		
	}
}
