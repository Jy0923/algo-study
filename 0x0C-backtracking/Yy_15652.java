package silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15652 {
	
	static int n, m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void recursion(int k) {
		
		if(k == m) {
			for(int i=0; i<m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i=0; i<n; i++) {
			// 1. 중복이 가능하므로 isUsed 를 확인할 필요가 없고
			// 2. 비내림차순이니까 나보다 작은게 올 수 없다.
			if(k != 0 && arr[k-1] > i+1) 
				continue;
				
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
