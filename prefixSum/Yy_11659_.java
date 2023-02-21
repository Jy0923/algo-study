package guganhap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 누적합 알고리즘 처음이라 구글링해봄
public class No11659 {
	
	static int n, m, i, j;
	static int[] arr;
	static int[] prefix; // 누적합을 위한 배열 생성
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		prefix = new int[n+1]; // prefix(n) - prefix(1)일때 대비해서 크기 n+1
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		prefix[1] = arr[0];
		for(int i=2; i<=n; i++) 
			prefix[i] = prefix[i-1] + arr[i-1]; // arr[0]부터 arr[i]까지 누적합계가 들어감
		
		for(int tc=0; tc<m; tc++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			
			System.out.println(prefix[j] - prefix[i-1]);
			
		}
		
	}
	
	
	
	
	
	
//	기본방식으로 풀었더니 시간초과
//	static int n, m, i, j;
//	static int[] arr;
//	static int sum;
//	static StringBuilder sb = new StringBuilder();
//	
//	static void sum(int i, int j) {
//		
//		sum = 0;
//		for(int idx=i-1; idx<j; idx++) 
//			sum += arr[idx];
//		
//		sb.append(sum).append("\n");
//	}
//	
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		n = Integer.parseInt(st.nextToken());
//		m = Integer.parseInt(st.nextToken());
//		
//		arr = new int[n];
//		
//		st = new StringTokenizer(br.readLine());
//		for(int i=0; i<n; i++) 
//			arr[i] = Integer.parseInt(st.nextToken());
//		
//		for(int tc=0; tc<m; tc++) {
//			st = new StringTokenizer(br.readLine());
//			i = Integer.parseInt(st.nextToken());
//			j = Integer.parseInt(st.nextToken());
//			
//			sum(i,j);
//		}
//		
//		System.out.println(sb);
//	}
}
