import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;

		while (true) {
			str = br.readLine();
			if (str.equals(".")) {
				break;
			}
			sb.append(solve(str)).append('\n');

		}

		System.out.println(sb);

	}

	public static String solve(String str) {

		char[] stack = new char[str.length()];
		int size = 0;

		for (char val : str.toCharArray()) {
			if (val == '(' || val == '[') {
				stack[size] = val;
				size++;
			}

			else if (val == ')') {
				if (size == 0 || stack[size - 1] != '(') {
					return "no";
				}

				else {
					size--;
				}

			}

			else if (val == ']') {
				if (size == 0 || stack[size - 1] != '[') {
					return "no";
				} else {
					size--;
				}
			}
		}

		if (size != 0) {
			return "no";
		} else {
			return "yes";
		}

	}

}
// 복붙 코드
// 제출 안함
// 나중에 스스로 풀어보기
