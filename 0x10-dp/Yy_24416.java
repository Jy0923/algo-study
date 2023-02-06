package bronze.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No24416 {
	
	static int cnt = 0;

	public static int fibonacci(int n) {
		
		int[] fibos = new int[n+1];
		fibos[1] = fibos[2] = 1;
		
		// 재귀대신 for문
		// 반복문 n - 3 + 1만큼 실행 --> 재귀대신 dp를 쓰면 나오는 횟수
		for(int i=3; i<=n; i++) {
			fibos[i] = fibos[i-1] + fibos[i-2];
		}
		
		return fibos[n];
		
	}
	
	public static int fibonacci_recur(int n) {
		
		if(n == 1 || n == 2) {
			cnt++;
			return 1;
		}
		
		return fibonacci_recur(n - 1) + fibonacci_recur(n - 2);
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		fibonacci_recur(n);
		System.out.print(cnt + " " + (n-2));
				
	}
	
}
