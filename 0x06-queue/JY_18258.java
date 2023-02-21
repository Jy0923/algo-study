import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class JY_18258 {
	
	int n;
	LinkedList<Integer> q = new LinkedList<>();
	String[] input;
	
	public void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			if (input.length == 1) {
				if (input[0].equals("empty")) {
					if (q.isEmpty()) {
						bw.write("1\n");
					} else {
						bw.write("0\n");
					}
				} else if (input[0].equals("pop")) {
					if (q.isEmpty()) {
						bw.write("-1\n");
					} else {
						bw.write(q.pollLast() + "\n");
					}
				} else if (input[0].equals("size")) {
					bw.write(q.size() + "\n");
				} else if (input[0].equals("front")) {
					if (q.isEmpty()) {
						bw.write("-1\n");
					} else {
						bw.write(q.peekLast() + "\n");
					}
				} else if (input[0].equals("back")) {
					if (q.isEmpty()) {
						bw.write("-1\n");
					} else {
						bw.write(q.peekFirst() + "\n");
					}
				}
			} else {
				q.offerFirst(Integer.parseInt(input[1]));
			}
		}
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException {
		new JY_18258().solution();
	}
}

