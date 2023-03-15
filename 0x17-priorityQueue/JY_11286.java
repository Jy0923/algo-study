import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class JY_11286{
	
	int n, m;
	PriorityQueue<Integer> q = new PriorityQueue<>((e1, e2) -> {
		if (Math.abs(e1) == Math.abs(e2)) {
			return e1 - e2;
		} else {
			return Math.abs(e1) - Math.abs(e2);
		}
	});
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			
			m = Integer.parseInt(br.readLine());
			if (m == 0) {
				if (q.isEmpty()) {
					bw.write("0\n");
				} else {
					bw.write(q.poll() + "\n");
				}
			} else {
				q.offer(m);
			}
		}
		
		bw.flush();
	}
	public static void main(String[] args) throws Exception {
		new JY_11286().solution();
	}
	
}
