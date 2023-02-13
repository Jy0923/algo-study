package prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_11659 {
	
	static int N; // 수의 개수
	static int M; // 합을 구해야 하는 횟수
	static int [] arr = new int [100001]; // 배열
	static long [] prefixSum = new long [100001]; // 누적합 배열
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String [] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		
		String [] strArr = br.readLine().split(" ");
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(strArr[i-1]);
			prefixSum[i] = prefixSum[i-1] + arr[i];
		}
		
		String [] str = null;
		int start = 0, end = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=M; i++) {
			str = br.readLine().split(" ");
			
			start = Integer.parseInt(str[0]);
			end = Integer.parseInt(str[1]);
			
			sb.append((prefixSum[end] - prefixSum[start-1]) + "\n");
		}
		
		System.out.println(sb);
		
	}
}
