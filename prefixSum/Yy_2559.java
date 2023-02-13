package prefixSum.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열
public class No2559 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		// arr[0] ~ arr[n-1]까지 누적합을 위한 배열 생성(prefixSum[0]은 0으로 비어둔다)
		int[] prefixSum = new int[n+1];
		for(int i=1; i<=n; i++) 
			prefixSum[i] = prefixSum[i-1] + arr[i-1];
		
        // k 구간만큼 비교해서 최댓값 구해주기
		int max = Integer.MIN_VALUE;
		for(int i=k; i<=n; i++) {
			if(max < prefixSum[i] - prefixSum[i-k])
				max = prefixSum[i] - prefixSum[i-k];
		}
		
		System.out.println(max);
		
	}

}
