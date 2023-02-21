import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Th_11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		String[] read = br.readLine().split(" ");
		int N = Integer.parseInt(read[0]);
		int M = Integer.parseInt(read[1]);
		int[] arr = new int[N+1];
		
		read = br.readLine().split(" ");
		for(int i=1; i<=N; i++) {
			// 배열 시작부터 인덱스까지의 합 넣어놓기
			arr[i] = Integer.parseInt(read[i-1]) + arr[i-1];
		}
		
		for(int i=0; i<M; i++) {
			read = br.readLine().split(" ");
			
			int l = Integer.parseInt(read[0]);
			int r = Integer.parseInt(read[1]);
			
			// 인덱스 r까지의 누적합에서 l 이전의 누적합 빼기
			sb.append(arr[r] - arr[l-1]);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
