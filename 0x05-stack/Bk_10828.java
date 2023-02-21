package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bk_10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		Stack<Integer> stack = new Stack<>();

		String str = "";
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			if (str.equals("pop")) {
				if (!stack.empty()) {
					sb.append(stack.peek() + "\n");
					stack.pop();
				} else
					sb.append(-1 + "\n");
			} else if (str.equals("size")) {
				sb.append(stack.size() + "\n");
			} else if (str.equals("empty")) {
				if (stack.isEmpty())
					sb.append(1 + "\n");
				else
					sb.append(0 + "\n");
			} else if (str.equals("top")) {
				if (!stack.empty()) {
					sb.append(stack.peek() + "\n");
				} else
					sb.append(-1 + "\n");
			} else {
				int num = Integer.parseInt(str.split(" ")[1]);
				stack.push(num);
			}
		}
		
		System.out.println(sb);
	}

}
