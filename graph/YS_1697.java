import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] map = new int[100002];
		Arrays.fill(map, -1);
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		map[n] = 0;
		

		while(map[k] == -1) {
			int index = queue.poll();
			int[] arr = {index - 1, index + 1, index * 2};
			for (int next : arr) {
				if(next < 0 || next > 100000) continue;
				if (map[next] != -1) continue;
				map[next] = map[index] + 1;
				queue.offer(next);
			}
		}
		System.out.println(map[k]);
		
		
	}
}
