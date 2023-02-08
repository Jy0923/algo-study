import java.util.Scanner;

public class Th_15652 {
	
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		
		tracking(0);
		
		System.out.println(answer);
	}
	
	private static void tracking(int cnt) {
		if(cnt == M) {
			for(Integer i : arr) {
				answer.append(i).append(" ");
			}
			answer.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			//배열에 하나 이상 담겼을 때
			if(cnt >= 1) {
				// 배열에 추가될 수가 바로 이전 수보다 작으면 담지 않음
				if(i < arr[cnt-1]) {
					continue;
				}
			}
			arr[cnt] = i;
			tracking(cnt+1);
		}
	}
}