import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class JY_1927{
	
	int n, m;
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			m = Integer.parseInt(br.readLine());
			if (m == 0) {
				if (minHeap.isEmpty()) {
					bw.write("0\n");
				} else {
					bw.write(minHeap.poll() + "\n");
				}
			} else {
				minHeap.offer(m);
			}
		}
		bw.flush();
	}
	
	public static void main(String[] args) throws Exception {
		new JY_1927().solution();
	}
}
