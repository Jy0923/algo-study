import java.util.Scanner;

public class Th_1912 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int[] arr = new int[N];
		int[] dy = new int[N];
		
		String[] read = sc.nextLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(read[i]);
		}
		
		dy[0] = arr[0];
		
		//두번째 인덱스부터 for문 돌꺼니까
		//첫번째 인덱스 값 넣어놓기
		int max = dy[0];
		
		for(int i=1; i<N; i++) {
			//이전의 최대값과 해당 인덱스 값을 더한값과
			//해당 인덱스 값 비교
			dy[i] = Math.max(arr[i], dy[i-1]+arr[i]);
			
			//해당 인덱스의 최대값이
			//현재 수열에서 나올 수 있는 최대값인지 비교
			max = Math.max(max, dy[i]);
		}
		
		System.out.println(max);
	}
}