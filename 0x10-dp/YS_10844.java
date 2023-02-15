import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static long[][] dp;
	static long cnt;
	
	
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dp = new long[n+1][10];
		long mod = 1000000000;
		

		for (int i = 1; i < 10 ; i ++) {
			dp[1][i] = 1;
		}
		
		for ( int i = 2 ; i <= n; i++ ) {
			for(int j = 0; j < 10 ; j++) {
				
				if (j == 0) {
					dp[i][j] = dp[i-1][1] % mod;
				} else if (j == 9){
					dp[i][j] = dp[i-1][8] % mod;
				} else {

					
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] % mod;	
				
				
				}
			}
		}
		cnt = 0;
		
		for (int i = 0; i < 10 ; i++) {
			cnt += dp[n][i];
		}
		
		System.out.println(cnt % mod);

	}
}

// long 때문에 애 먹음,,,
// 아래는 백트래킹으로 푼 버전

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// public class Main {
// 	static int n;
// 	static int[] arr;
// 	static boolean[] visited;
// 	static int cnt;
	
	
	
//   public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		n = Integer.parseInt(br.readLine());
		
// 		arr = new int[n];
// 		visited = new boolean[n];
// 		cnt = 0;
// 		solution(0);
// 		System.out.println(cnt);
		
		
// 	}
    
    
//     public static void solution(int k) {
//     	if (k == n) {
//     		cnt++;
//     		return;

//     	}
    	
//     	for(int i = 0; i < 10; i++) {
//     		// 첫 항이 1일 경우 컨티
//     		if (k == 0 && i == 0) {
//     			continue;
//     		}
//     		if (k == 0) {
//     			arr[k] = i;

//     			solution(k+1);
//     			arr[k] = 0;

    			
//     		} else {
//     			if (Math.abs(i - arr[k-1]) == 1) {
//     				arr[k] = i;
//         		solution(k+1);
//         		arr[k] = 0;
//     			}
//     		}
//     	}
//     }
// }
