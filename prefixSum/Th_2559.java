import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Th_2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] read = br.readLine().split(" ");
		
		int N = Integer.parseInt(read[0]);
		int K = Integer.parseInt(read[1]);
		
		int max = Integer.MIN_VALUE;
		int[] arr = new int[N+1];
		
		read = br.readLine().split(" ");
		
		for(int i=1; i<=N; i++) {
			// 누적합 넣기
			arr[i] = arr[i-1] + Integer.parseInt(read[i-1]);
			
			// 인덱스가 K보다 크거나 같으면
			if(i >= K) {
				// 연속적인 K일수의 합이랑 max 비교
				max = Math.max(max, arr[i] - arr[i-K]);
			}
		}
		
		System.out.print(max);
	}
}