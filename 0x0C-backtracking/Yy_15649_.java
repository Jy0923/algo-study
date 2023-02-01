package silver.s3;

import java.util.Scanner;

public class No15649 {
	// N과 M(1)

	static int n, m;
	static int[] arr = new int[10];
	static boolean[] isUsed = new boolean[10];
	
	// 현재 k개까지 수를 택한 상황에서 arr[k]를 정하는 함수
	// 맨처음에 func(0)을 호출하면 arr[0]을 정한 후에 func(1)을 호출
	public static void func(int k) {
		// 종료조건
		// m개를 모두 택했으니 수열을 출력한 후 함수 종료
		if(k == m) {
			for(int i=0; i<m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		// m이 아니면 n까지 수를 차례로 확인하며 아직 쓰이지 않은 수를 찾아낸다.
		for(int i=1; i<=n; i++) {
			if(!isUsed[i]) {
				arr[k] = i;
				isUsed[i] = true;
				func(k+1);
				
				// arr[k] = i 로 둔 상태에서 func(k+1)에 들어갔다가 모든 과정을 끝냈다는 얘기이니 false로 돌림
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
