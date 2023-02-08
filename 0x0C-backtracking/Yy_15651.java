package silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15651_2 {
	// 계속 시간초과나서
	// Scanner -> BufferedReader 사용했고
	// sysout 대신 StringBuilder 사용했고
	// boolean[] isUsed 배열 필요없어서 삭제함
	
	static int n, m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	// k개를 고르고 arr[k]를 찾을 차례
	public static void recursion(int k) {
		
		// 종료조건
		if(k == m) {
			for(int i=0; i<m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i=0; i<n; i++) {
			arr[k] = i + 1;
			recursion(k+1);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		
		recursion(0);
		
		System.out.println(sb);
	}

}
