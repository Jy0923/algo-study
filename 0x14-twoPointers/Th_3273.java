package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3273_두수의합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sizeOfNum = Integer.parseInt(br.readLine());
		int[] numArr = new int[sizeOfNum];
		
		String[] read = br.readLine().split(" ");
		for(int i=0; i<sizeOfNum; i++) {
			numArr[i] = Integer.parseInt(read[i]);
		}
		Arrays.sort(numArr);
		
		int x = Integer.parseInt(br.readLine());
		
		int l = 0;
		int r = sizeOfNum-1;
		int cnt = 0;
		while(l < r) {
			int cur = numArr[l] + numArr[r];
			if(cur == x) cnt++;
			if(cur <= x) l++;
			else r--;	
		}
		
		System.out.println(cnt);
	}
}
