import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class JY_1021{
	
	int n, m, answer, curIdx;
	LinkedList<Integer> q = new LinkedList<>();
	ListIterator<Integer> iter;
	int[] seq;
			
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		seq = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < n+1; i++) {
			q.offerLast(i);
		}
		
		answer = 0;
		for (int i = 0; i < m; i++) {
			curIdx = q.indexOf(seq[i]);
			if (curIdx <= q.size()/2) {
				while (q.peekFirst() != seq[i]) {
					q.offerLast(q.pollFirst());
					answer++;
				}
				q.pollFirst();
			} else {
				while (q.peekFirst() != seq[i]) {
					q.offerFirst(q.pollLast());
					answer++;
				}
				q.pollFirst();
			}
		}
		
		System.out.println(answer);
		
	}

	public static void main(String[] args) throws IOException {
		new JY_1021().solution();
	}
}
