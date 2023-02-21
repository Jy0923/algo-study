import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int mx = 51;
	static char[] stack;
	static int top;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		loop1:
		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			stack = new char[mx];

			top = -1;
			for (int j = 0; j < str.length(); j++) {
				push(str.charAt(j));
			}

			int right = 0;
			int left = 0;
			char character;

			for (int k = 0; k < str.length(); k++) {
				if (right < 0) {
					break;
				}
				character = pop();
				if (character == ')') {
					right++;

				} else if (character == '(') {
					right--;

				}

			
			}

			if (right != left) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}

		}
	}

	private static char pop() {
		top--;
		return stack[top + 1];
	}

	private static void push(char x) {
		stack[++top] = x;

	}
}
