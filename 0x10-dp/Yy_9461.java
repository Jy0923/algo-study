package silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No9461_2 {
	// int[] 배열로하면 최대 n=100일 때 범위 넘어감
	static long[] arr = {1, 1, 1};
	
	// 앞에 두개를 더한게 다음다음값이 된다
	static void padoban(int n) {
		
		if(n > 3) 
			arr = Arrays.copyOf(arr, n);
		
		for(int i=3; i<n; i++) 
			arr[i] = arr[i-2] + arr[i-3];
		
		System.out.println(arr[n-1]);
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<t; tc++) {
			int n = Integer.parseInt(br.readLine());
			padoban(n);
		}
		
	}

}
