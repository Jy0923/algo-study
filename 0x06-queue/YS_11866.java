import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		
		int[] arr = new int[n];
		int temp;
		int cnt = 0;
		int idx = 0;
		
		while(queue.size() != 0) {
			temp = queue.poll();
			cnt++;
			if (cnt == k) {
				arr[idx++] = temp;
				cnt = 0;
				continue;
			} else {
				queue.offer(temp);
			}
			
		}


		
		for (int element : queue) {
			arr[idx++] = element;
		}
		
		
		String result = Arrays.toString(arr);
		result = result.replace("[", "<");
		result = result.replace("]", ">");
		System.out.println(result);
		
	}
}
