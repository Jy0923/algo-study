import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] distance;
	static long[] price;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		distance = new long[n - 1];
		price = new long[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 거리 배열을 받고
		for (int i = 0; i < n - 1; i++) {
			distance[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());


		// 가격 배열을 받는다.
		for (int i = 0; i < n; i++) {
			price[i] = Long.parseLong(st.nextToken());

		}


		// 최소, 최소인덱스, 결과 변수를 선언한다.
		long min;
		int minIdx = 0;
		long result = 0;

		// 최소인덱스가 n이 되기 전까지
		Loop1: while (minIdx < n) {
			
			// 제일 앞 인덱스가 최소라고 생각
			int start = minIdx;
			min = price[minIdx];
			
			// 앞에 제일 앞 인덱스보다 작은 값이 있는지 확인
			boolean lowerPrice = false;
		
			// 현 minIdx보다 한 칸 앞에서부터 순회
			for (int j = start + 1; j < n; j++) {
				
				// 만약에 맨 앞보다 작은 값이 앞에 존재한다면
				if (price[j] < min) {
					
					// lowerPrice boolean을 true로 바꿔주고 
					lowerPrice = true;
					
					// 최소값과 인덱스를 갱신한다.
					min = price[j];
					minIdx = j;
					
					// 제일 작은 값이 아니라, 가장 가까운 최소값을 찾기 위해 반복문을 빠져나간다.
					break;
				}
			}
			
			// 만약 더 작은 값이 있다면
			if (lowerPrice) {

				// 맨 처음 인덱스부터 minIdx까지의 거리와
				// 맨 처음 인덱스의 가격을 곱한다.
				for (int k = start; k < minIdx; k++) {
					result += price[start] * distance[k];
				}

			} else {

				// 더 작은 값이 없다면
				// distance의 남은 모든 배열과 현재의 가격을 곱하고
				for (int k = start; k < n - 1; k++) {
					result += price[start] * distance[k];

				}
				// 가장 바깥의 while문을 빠져나간다.
				break Loop1;

			}
		}
		// 결과 출력
		System.out.println(result);

	}

}
