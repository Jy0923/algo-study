import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class JY_10866 {
	
	int n, num;
	LinkedList<Integer> q = new LinkedList<>();
	String[] cmds;
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			cmds = br.readLine().split(" ");
			if (cmds.length == 1) {
				if (cmds[0].equals("empty")) {
					if (q.isEmpty()) {
						bw.write("1\n");
					} else {
						bw.write("0\n");
					}
				} else if (cmds[0].equals("front")) {
					if (q.isEmpty()) {
						bw.write("-1\n");
					} else {
						bw.write(q.peekFirst() + "\n");
					}
				} else if(cmds[0].equals("back")) {
					if (q.isEmpty()) {
						bw.write("-1\n");
					} else {
						bw.write(q.peekLast() + "\n");
					}
				} else if (cmds[0].equals("size")) {
					bw.write(q.size() + "\n");
				} else if (cmds[0].equals("pop_front")) {
					if (q.isEmpty()) {
						bw.write("-1\n");
					} else {
						bw.write(q.pollFirst() + "\n");
					}
				} else if(cmds[0].equals("pop_back")) {
					if (q.isEmpty()) {
						bw.write("-1\n");
					} else {
						bw.write(q.pollLast() + "\n");
					}
				}

			} else {
				num = Integer.parseInt(cmds[1]);
				if (cmds[0].equals("push_front")) {
					q.offerFirst(num);
				} else {
					q.offerLast(num);
				}
			}
		}
		bw.flush();
	}

	public static void main(String[] args) throws IOException {
		new JY_10866().solution();
	}
}
