import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static int[] arr;
	static int[] arrSum;
	static int sum;
	static int[] newArr;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 전체 날짜의 수 n
		n = Integer.parseInt(st.nextToken());
		
		// 연속적인 날짜의 수 k
		k = Integer.parseInt(st.nextToken());
		
		// 온도의 배열 
		arr = new int[n];
		
		// 온도의 누적합을 저장할 배열 
		arrSum = new int[n];
		
		// k동안의 합을 저장할 배열 
		newArr = new int[n - k + 1];
		
		// 최대값 추출을 위한 max 변수
		max = Integer.MAX_VALUE;
		
		// 합은 0으로 초기화
		sum = 0;
		
		
		st = new StringTokenizer(br.readLine());

		// 들어온 값을 arr 배열에 저장하고, sum에 계속 더해나간다.
		// sum을 arrSum에 저장
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			arrSum[i] = sum;

		}
		
		// 첫 구간합이 만들어지는 k-1부터 n까지 
		for (int i = k -1; i < n;i++) {
			
			// 첫 구간합은 arrSum의 첫 항
			if ( i == k-1) {
				newArr[i - k + 1] = arrSum[i];
				
				// 맨 처음 값을 max 값으로 갱신
				max = arrSum[i];
			} else {
				
				// 이후부턴 i번째 누적합에서 i-k번째 누적합을 빼주고
				// 해당 값을 newArr에 저장
				newArr[i - k + 1] = arrSum[i] - arrSum[i-k];
				
				// 만약 이 값이 max보다 크다면 갱신
				if ( newArr[i - k + 1] > max) {
					max = newArr[i - k + 1];
				}
			}
			

		}
		// max값 출력
		System.out.println(max);

	}
}
