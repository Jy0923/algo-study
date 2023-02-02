import java.util.Scanner;

public class Th_15651 {
	static int N; // 1부터 N까지의 자연수
	static int M; // 배열의 길이
	static int[] arr; // 배열
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
		//배열 완성되면 StringBuilder에 담기
		if(cnt == M) {
			for(Integer i : arr) {
				answer.append(i).append(" ");
			}
			answer.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			arr[cnt] = i;
			tracking(cnt+1);
		}
	}
}