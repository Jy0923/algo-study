package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1806_부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] read;
		
		read = br.readLine().split(" ");
		int N = Integer.parseInt(read[0]);
		int S = Integer.parseInt(read[1]);
		
		int[] arr = new int[N];
		
		read = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(read[i]);
		}
		
		int minLength = Integer.MAX_VALUE;
		
		int l = 0, r = 0;
		int sum = arr[l];
		while(l <= r && r < N && minLength != 1) {
			if(sum >= S) {
				minLength = Math.min(minLength, r-l+1);
			}
			
			if(sum < S) {
				if(r == N-1) break;
				sum += arr[++r];
			} else {
				sum -= arr[l++];
			}
		}
		
		if(minLength == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(minLength);
		}
	}
}