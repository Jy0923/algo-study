package silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2579 {
	
	static int n;
	static int[] arr;
	static int[] dp;
	
	static int dp(int n) {
		
		if(n == 0) return 0; // 계단이 0개면 0 반환
		
		if(n >= 1)
			dp[0] = arr[0]; // 계단이 0개가 아니면 첫번째 계단의 최댓값은 자기자신
		
		if(n >= 2)
			dp[1] = arr[0] + arr[1]; // 계단이 2개이상일 때, 두번째 계단의 최댓값은 첫번째+두번째
		
		if(n >= 3) 
			dp[2] = Math.max(arr[1] + arr[2], arr[0] + arr[2]); // 1+3, 2+3 중에 하나가 최댓값(1+2는 마지막 계단 밟아야 되서 x)

		
		for(int i=3; i<n; i++) 
			dp[i] = Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]);
		
		return dp[n-1];
	}
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		dp = new int[n];
    	
    	for(int i=0; i<n; i++) 
    		arr[i] = Integer.parseInt(br.readLine());
    	
    	System.out.println(dp(n));
    	
    }
}








////이 문제 처음에 풀 때 마지막 계단을 무조건 밟아야된다고해서 
////인덱스를 반대로 해서 입력값을 배열에 저장하고
////마지막 계단부터 트리구조로 최댓값을 구해야겠다 생각하고 풀었는데 
////어디가 잘못된건지 이해가 안돼서 계속 질질끌었는데요
//
////문득 생각해보니 
////arr[0](마지막계단)이 안밟히는게 최대가 될 수 있어서 틀리는거같아요
////시간될 때 인덱스 거꾸로넣는걸로도 만들 수 있는지 다시해보겠슴다(보류)
//public class No2579_2 {
//	
//	static int[] arr;
//	static int n;
//	static int[] dp; // 각 계단에서의 최댓값을 표현하는 배열
//	
//	static int max(int n) {
//		// 계단이 없으면 0 반환
//		if(n == 0) return 0;
//		
//		// 마지막 계단은 무조건 밟아야 하니까 넣어주기
//		if(n >= 1)
//			dp[0] = arr[0];
//		
//		// 계단이 2개 이상이라면 2번째 계단의 최댓값은 첫번째계단 + 자기자신
//		if(n >= 2)
//			dp[1] = arr[0] + arr[1];
//		
//		// 계단이 3개라고 하면
//		// 1. 첫번째 계단 + 세번째 계단
//		// 2. 두번째 계단 + 세번쨰 계단중에 큰게 dp[2]이 된다.
//		// 근데 인덱스를 반대로 넣었으니 0,1 & 0,2 중에 확인
//		if(n >= 3) 
//			dp[2] = Math.max(arr[0] + arr[1], arr[0] + arr[2]); 
//
//		
//		for(int i=3; i<n; i++) {
//			dp[i] = Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]);
//		}
//		
//		// 예) 5, 10, 15, 20, 25, 30 일때 최댓값이 dp[n-1]이 아님(첫번째 계단을 안밟을 때)
//		// 따라서 return dp[n-1]을 하면안되고 dp중에 가장 큰 값을 넣어야함
//		int max = 0;
//		
//		for(int i=0; i<n; i++) 
//			max = Math.max(max, dp[i]);
//		
//		
//		return max;
//	}
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		n = Integer.parseInt(br.readLine());
//		
//		arr = new int[n];
//		dp = new int[n];
//		
//		// 도착점을 무조건 밟아야 하니까 뒤에서부터 트리만들면 될듯
//		// 뒤에서부터 확인하기 위해서 인덱스 거꾸로 넣어줬어요
//		for(int i=n-1; i>=0; i--) 
//			arr[i] = Integer.parseInt(br.readLine());
//		
//		System.out.println(max(n));
//		
//	} 
//
//}

