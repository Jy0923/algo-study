package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2230_수고르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] read = br.readLine().split(" ");
		int N = Integer.parseInt(read[0]);
		int M = Integer.parseInt(read[1]);
		
		int[] numArr = new int[N];
		for(int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(numArr);
		
		int l = 0,r = 0;
		int min = Integer.MAX_VALUE;
		while(r < N) {
			int cur = numArr[r] - numArr[l];
			
			if(cur == M) {
				min = M;
				break;
			}
			
			if(cur > M) {
				min = Math.min(min, cur);
				l++;
			} else if(cur <= M) {
				r++;
			}
		}
		System.out.println(min);	
	}
}
