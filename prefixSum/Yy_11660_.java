package prefixSum.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11660 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] prefixSum = new int[n+1][n+1];// 인덱스 0 들어간자리는 다 비워주기
		int[][] map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i != 1 || j != 1) {
					prefixSum[i][j] = prefixSum[i][j-1] + prefixSum[i-1][j] 
									- prefixSum[i-1][j-1] + map[i-1][j-1];
				} else 
					prefixSum[1][1] = map[0][0];
			}
		}
		
//		for(int i=0; i<=n; i++) {
//			System.out.println(Arrays.toString(prefixSum[i]));
//		}
		
		
		for(int tc=0; tc<m; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum = prefixSum[x2][y2] - prefixSum[x1-1][y2]
					- prefixSum[x2][y1-1] + prefixSum[x1-1][y1-1];
			
			System.out.println(sum);
		}
		
	}
}


/*
 * 이렇게풀면 시간초과남 2차배열 누적합은 이렇게푸는거 아님 ^_ㅠ
public class No11660 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 누적합용 2차배열
		int[][] prefixSum = new int[n][n+1]; // 인덱스 에러 방지를 위해 열1개 추가
		for(int i=0; i<n; i++) {
			prefixSum[i][1] = map[i][0];
			for(int j=2; j<=n; j++) {
				prefixSum[i][j] += prefixSum[i][j-1] + map[i][j-1];
			}
		}

		// 누적합 확인용
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<=n; j++) {
//				System.out.print(prefixSum[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for(int tc=0; tc<m; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			for(int r=x1; r<=x2; r++) {
				sum += prefixSum[r][y2] - prefixSum[r][y1-1];
			}
			
			System.out.println(sum);
		}
	}
}
*/
