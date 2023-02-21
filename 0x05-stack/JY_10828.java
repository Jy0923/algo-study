import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class JY_10828 {

	int n, num;
	String[] lst;
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			lst = br.readLine().split(" ");
			if (lst.length == 2) {
				stack.push(Integer.parseInt(lst[1]));
			} else {
				if (lst[0].equals("top")) {
					if (stack.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(stack.peek());
					}
				} else if (lst[0].equals("size")) {
					System.out.println(stack.size());
				} else if (lst[0].equals("empty")) {
					if (stack.isEmpty()) {
						System.out.println(1);
					} else {
						System.out.println(0);
					}
				} else if (lst[0].equals("pop")) {
					if (stack.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(stack.pop());
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		new JY_10828().solution();
	}
}
