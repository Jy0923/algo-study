import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.concurrent.SynchronousQueue;

public class Main {
	static int n;
	static int m;
	static int i;
	static int j;
	
	// 입력받은 숫자의 배열
	static int[] arr;
	
	// 누적합을 넣을 배열
	static int[] arrSum;
	
	// 누적합을 만들기 위한 sum 변수
	static int sum;
	
	// 결과를 출력할 result 변수
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 배열 arr와 누적합 배열 arrSum을 선언한다.
		arr = new int[n];
		arrSum = new int[n];
		sum = 0;
		result = 0;

		
		// n만큼 순회하면서 배열에 입력받은 정수를 넣고
		// 각 인덱스의 값을 더해서 다시 누적합 배열에 넣어준다.
		for (int idx = 0; idx < n; idx++) {

			arr[idx] = Integer.parseInt(st.nextToken());
			sum += arr[idx];
			arrSum[idx] = sum;
		}

		// 0부터 m까지 순회
		// 구간 i와 j를 입력받는데 인덱스와 숫자를 맞추기 위해서 1을 빼준다.
		for (int idx = 0; idx < m; idx++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken()) - 1;
			j = Integer.parseInt(st.nextToken()) - 1;

			// i가 0일 때는 j까지의 합을 result에 저장하고
			if (i == 0) {
				result = arrSum[j];
			
			} else {
				// i가 0이 아니면 j까지의 합부터 i-1까지의 합을 빼주고 result에 저장한다.
				result = arrSum[j] - arrSum[i - 1];
			}

			// 그리고 결과 출력
			System.out.println(result);

		}

	}
}
