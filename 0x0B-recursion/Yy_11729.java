import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yy_11729 {

	static int cnt = 0;
	static StringBuilder sb = new StringBuilder(); // 출력시간 절감위해 생성
	
	// 하노이탑
	public static void hanoi(int n, int start, int mid, int end) {
		
		cnt++;  // 함수 호출될 때마다 카운트++
		
		if(n == 1) {
			sb.append(start + " " + end + "\n");
			return;
		}
		
		// 1. 1 ~ n-1번 탑을 1에서 2으로 옮긴다.
		// 2. n번 탑을 		  1에서 3으로 옮긴다.
		// 3. 1 ~ n-1번 탑을 2에서 3으로 옮긴다.
		hanoi(n-1, start, end, mid);
		sb.append(start + " " + end + "\n");
		hanoi(n-1, mid, start, end);
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		hanoi(n, 1, 2, 3);
		System.out.println(cnt);
		System.out.print(sb);
	}	
	
}
