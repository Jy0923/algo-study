package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2470_두용액 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		
		int[] arr = new int[N];
		
		String[] read = sc.nextLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(read[i]);
		}
		
		Arrays.sort(arr);
		
		long[] answer = new long[2];
		
		int l = 0, r = N-1;
		long minValue = Integer.MAX_VALUE;
		while(l < r) {
			long cur = arr[l] + arr[r];

			if(minValue > Math.abs(cur)) {
				minValue = Math.abs(cur);
				answer[0] = arr[l];
				answer[1] = arr[r];
			} 
			
			if(cur < 0) l++;
			if(cur >= 0) r--;
		}
		
		System.out.print(answer[0] + " " + answer[1]);
		sc.close();
	}
}
