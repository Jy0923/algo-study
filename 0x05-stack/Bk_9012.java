package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bk_9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());

		String str;
		for (int i = 0; i < T; i++) {
			str = br.readLine();
			Stack<Character> st = new Stack<Character>();
			sb.append(solution(str.toCharArray(), st) + "\n");
		}
		
		System.out.println(sb);

	}

	private static String solution(char[] str, Stack<Character> st) {
		String answer = "YES";

		for (int i = 0; i < str.length; i++) {
			if (str[i] == '(')
				st.push('(');
			else {
				if (st.empty()) {
					answer = "NO";
					break;
				} else
					st.pop();
			}

		}
		if (!st.empty())
			answer = "NO";

		return answer;
	}

}
