import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numOfCal = sc.nextInt();
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		int cur;
		for(int i=0; i<numOfCal; i++) {
			cur = sc.nextInt();
			
			if(cur == 0) {
				if(que.size() == 0) sb.append(0 + "\n");
				else sb.append(que.poll() + "\n");
			} else {
				que.offer(cur);
			}
		}
		System.out.println(sb);
	}
}