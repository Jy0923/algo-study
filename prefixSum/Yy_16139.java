package prefixSum.silver.no16139;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 인간-컴퓨터 상호작용
// 2차배열만들어서 낼아침까지 재제출예정
public class No16139_2 {
	
	static char[] arr;
	static int[] prefixSum;
	static StringTokenizer st;
	static char a;
	static int q, l, r;
	static StringBuilder sb = new StringBuilder();
	
	
	static void prefixSum(char[] arr, char a, int l, int r) {
		
		prefixSum = new int[arr.length+1];
		if(arr[0] == a) 
			prefixSum[1]++;
		
		for(int i=2; i<=arr.length; i++) {
			prefixSum[i] = prefixSum[i-1];
			if(arr[i-1] == a)
				prefixSum[i]++;
		}
		
		sb.append(prefixSum[r] - prefixSum[l-1]).append("\n");
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		arr = new char[str.length()];
		for(int i=0; i<arr.length; i++) 
			arr[i] = str.charAt(i);
		
		q = Integer.parseInt(br.readLine());

		for(int tc=0; tc<q; tc++) {
			st = new StringTokenizer(br.readLine());
			a = st.nextToken().charAt(0);
			l = Integer.parseInt(st.nextToken()) + 1; // prefixSum은 n+1이라서 편하게 +1함
			r = Integer.parseInt(st.nextToken()) + 1;
			
			prefixSum(arr, a, l, r);
		}
		System.out.println(sb);
	}
}
