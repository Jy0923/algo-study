import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class JY_10773 {
	
	public void solution() throws IOException {
		Scanner sc = new Scanner(System.in);
		int n, k;
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			k = sc.nextInt();
			if (k == 0) {
				stack.pop();
			} else {
				stack.push(k);
			}
		}
		
		for (int e : stack) {
			result += e;
		}
		System.out.println(result);
	}
	
	public static void main(String[] args) throws IOException {
		new JY_10773().solution();
	}
}
