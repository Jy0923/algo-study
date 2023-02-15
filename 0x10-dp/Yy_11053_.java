package silver.s2.no11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열
public class No11053_3 {
	
	static int n;
	static int[] arr; 
	static int[] dp; // arr[0]~arr[n-1]까지 중에 arr[n]보다 작은 수들의 개수
	static int maxCnt = 1; // 기본값이 1
	
	
	static int dp(int n) {
		// arr[0]부터 본인보다 왼쪽중에 작은애들 셀건데
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				// arr[i]가 더 클 때
				if(arr[j] < arr[i])
					// dp[i]는 현재까지 나온 최대 카운트 수에다가 본인이 더해져서 +1을 해준다.
					// dp[i] = dp[j]+1 로 안쓰는 이유는
					// 이중포문의 안쪽 포문이 돌면서 dp[j]보다 dp[j-1] 등이 더 클 수 있기 때문에 Math.max 이용해서 최대 카운트 뽑아낸다.
					dp[i] = Math.max(dp[i], dp[j] + 1);
				
				// dp중에 제일 큰 카운트 수를 리턴하기 위해 사용한다.
				maxCnt = Math.max(maxCnt, dp[i]);
			}
		}
		
		return maxCnt;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1; // 길이가 1일때도 무조건 1이니까 기본값을 1로 설정
		}
		
		System.out.println(dp(n));
	}
	
}





/*
   혹시 이거 왜틀리는지 피드백해주실분 구합니당,, 
	// 가장 긴 증가하는 부분 수열
	public class No11053_2 {
	
		static int n;	
		static int[] arr; 
		static int[] dp; // arr[n] 보다 작은 arr값들의 개수
	
	static Set<Integer> set; // 중복값 빼주기 위해서 임시로 사용
							 // 예시) 1 2 1 2 3 4 -> arr[3] 에서 arr[0], arr[2]를 두번세지 않기 위해 set을 사용
	
	static int dp(int n) {
		
		for(int i=0; i<n; i++) {
			dp[i] = 1; // 무조건 1개이상이니까 1로 설정
			
			set = new HashSet<>(); // i가 초기화될때마다 set 초기화한 후
			
			// i보다 작은 j에 대해 반복문을 돌리면서
			for(int j=0; j<i; j++) {
				// arr[i]보다 작고, set에 없는 숫자이면(중복일 때 카운트 안하기 위해)
				if(arr[j] < arr[i] && !set.contains(arr[j])) {
					// 카운트 한번 세주고
					dp[i]++;
					// set에 해당 작은수를 저장해준다.
					// 이후 반복문에서 같은 숫자가 나올때 중복 카운트를 막는다.
					set.add(arr[j]);
				}
			}
		}
		
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(dp));
		
		int maxCnt = 0;
		for(int i=0; i<n; i++) 
			maxCnt = Math.max(dp[i], maxCnt);
				
		return maxCnt;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		System.out.println(dp(n));
	}
	
}

 */
