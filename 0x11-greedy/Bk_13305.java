package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_13305 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] liters = new long[N];
		long[] distance = new long[N - 1];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N - 1; i++) {
			distance[i] = Long.parseLong(input[i]);
		}

		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			liters[i] = Long.parseLong(input[i]);
		}
		
		long minVal = liters[0]; // 리터당 최소 가격
		long sum = liters[0] * distance[0]; // 무조건 처음엔 기름을 넣어야 함
		
		for(int i=1; i<N-1; i++){
	        // 현재 기름 값이 최솟값이면 인덱스, 값 변경
	        if(liters[i] < minVal){
	            minVal = liters[i];
	        }
	        sum += minVal * distance[i];
	    }
		
		System.out.println(sum);
	}

}
