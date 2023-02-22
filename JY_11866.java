import java.util.LinkedList;
import java.util.Scanner;

public class JY_11866{
	
	public void solution() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		LinkedList<Integer> q = new LinkedList<>();
		for (int i = 1; i < n+1; i++) {
			q.add(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int curIdx = k-1;
		while (q.size() > 1) {
			sb.append(q.remove(curIdx));
			if (q.size() >= 1) {
				sb.append(", ");
			}
			curIdx = ((curIdx-1) + k) % q.size();
		}
		sb.append(q.poll()).append(">");
		System.out.println(sb.toString());
		
	}

	public static void main(String[] args) {
		new JY_11866().solution();
	}
}
