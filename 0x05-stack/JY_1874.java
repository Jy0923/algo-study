import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class JY_1874 {

	int n;
	int[] arr;
	int cnt, cur;
	Stack<Integer> stack = new Stack<>();
	ArrayList<Character> list = new ArrayList<>();
	
	public void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		cnt = 0;
		cur = 1;
		boolean check = false;
		while (true) {
			if (stack.isEmpty()) {
				stack.push(cur++);
				list.add('+');
			} else if (stack.peek() == arr[cnt]) {
				stack.pop();
				cnt++;
				list.add('-');
				if (cnt == n) {
					check = true;
					break;
				}
			} else if (arr[cnt] > stack.peek()) {
				stack.push(cur++);
				list.add('+');
			} else {
				break;
			}
		}
		
		if (check) {
			for (char e : list) {
				System.out.println(e);
			}			
		} else {
			System.out.println("NO");
		}
	}
	
	public static void main(String[] args) throws IOException {
		new JY_1874().solution()
	}
}
