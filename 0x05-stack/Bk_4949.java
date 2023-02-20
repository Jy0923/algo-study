package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bk_4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] arr = null;

		while (true) {
			arr = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<Character>();
			// 종료 조건
			if (arr[0] == '.')
				break;

			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] == '.')
					break;

				if (arr[i] == '(')
					stack.push('(');
				if (arr[i] == '[')
					stack.push('[');
				if (arr[i] == ']') {
					if (!stack.isEmpty() && stack.peek() == '[')
						stack.pop();
					else {
						sb.append("no\n");
						break;
					}
				}
				if (arr[i] == ')') {
					if (!stack.isEmpty() && stack.peek() == '(')
						stack.pop();
					else {
						sb.append("no\n");
						break;
					}
				}

				if (stack.isEmpty() && i == arr.length - 2)
					sb.append("yes\n");
				else if (!stack.isEmpty() && i == arr.length - 2)
					sb.append("no\n");
			}
		}

		System.out.println(sb);
	}

}
