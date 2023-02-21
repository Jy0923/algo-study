import java.util.LinkedList;
import java.util.Scanner;

public class JY_2164 {
	
	int n;
	LinkedList<Integer> q = new LinkedList<>();
	
	public void solution() {
		n = new Scanner(System.in).nextInt();
		for (int i = 1; i < n+1; i++) {
			q.offerLast(i);
		}
		while (q.size() > 1) {
			q.pollFirst();
			q.offerLast(q.pollFirst());
		}
		System.out.println(q.peekFirst());
	}
	
	public static void main(String[] args) {
		new JY_2164().solution();
	}
}
