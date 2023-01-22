
import java.util.LinkedList;
import java.util.Scanner;

public class JY_2346 {
	
	public void solution() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<int[]> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			list.add(new int[] {i+1, sc.nextInt()});
		}
		
		int[] cur;
		int curIdx = 0;
		int delta;
		
		while (!list.isEmpty()) {
			cur = list.remove(curIdx);
			delta = cur[1];
			System.out.print(cur[0] + " ");
			if (list.isEmpty()) {
				break;
			}
			if (delta > 0) {
				curIdx = (curIdx + delta - 1) % list.size();
			} else {
				curIdx = (curIdx + delta) % list.size();
			}
			if (curIdx < 0) {
				curIdx += list.size();
			}
		}
	}
	
	public static void main(String[] args) {
		new Main().solution();
	}
}