import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Th_2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> que = new LinkedList<>();
		
		int N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			que.offer(i);
		}
		
		int cnt = 0;
		while(que.size() != 1) {
			if(cnt % 2 == 0) {
				que.poll();
			} else {
				int num = que.poll();
				que.offer(num);
			}
			cnt++;
		}
		
		System.out.println(que.poll());
	}
}