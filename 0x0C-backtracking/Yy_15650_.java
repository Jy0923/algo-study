package silver.s3;

import java.util.Scanner;

public class No15650 {
	// N과 M(2)

	static int n, m;
	static int[] arr = new int[10]; // 수열을 담을 배열
	static boolean[] isUsed = new boolean[10]; // 특정 수가 쓰였는지 나타내는 배열
	
	public static void func(int k) {
		
		// 종료조건
		if(k == m) {
			for(int i=0; i<m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!isUsed[i]) {
				
				if(k != 0 && i < arr[k-1]) 
					continue;
				
				arr[k] = i;
				isUsed[i] = true;
				func(k+1);
				
				isUsed[i] = false; 
			}
		}
	}
	
	public static void main(String[] args) {
		/*
		 * 백트래킹
		 * 		비어있는 리스트에서 시작해 수를 하나씩 추가하면서 
		 * 		길이가 M인 수열이 완성되면 출력하는 방식으로 구현
		 */
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();	m = sc.nextInt();
		
		func(0);
		
		
	}


}
