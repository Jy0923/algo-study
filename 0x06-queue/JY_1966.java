import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class JY_1966{
	
	int t, n, curIdx, cnt;
	LinkedList<Integer> list;
	LinkedList<Integer> sortedList;
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			curIdx = Integer.parseInt(st.nextToken());
			
			list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				list.offer(Integer.parseInt(st.nextToken()));
			}
			
			sortedList = new LinkedList<>(list);
			sortedList.sort(Collections.reverseOrder());
			
			cnt = 1;
			while (true) {
				if (sortedList.peek() == list.peek()) {
					if (curIdx == 0) {
						break;
					} else {
						sortedList.poll();
						list.poll();
						curIdx--;
						cnt++;
					}
				} else {
					list.offer(list.poll());
					if (curIdx == 0) {
						curIdx = list.size() - 1;
					} else {
						curIdx--;
					}
				}
			}
			System.out.println(cnt);
		}
	
	}

	public static void main(String[] args) throws IOException {
		new JY_1966().solution();
	}
}
