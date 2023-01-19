package dailyWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class editor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 주말까지 조금 더 수정해서 다시 올리겠습니다.
		
		String base = br.readLine();
		String keyLen = br.readLine();
		String[] input = new String[Integer.valueOf(keyLen)];
		for (int i = 0; i < Integer.valueOf(keyLen); i++) {
			input[i] = br.readLine();
		}

		br.close();

		for (int i = 0; i < base.length(); i++) {
			char[] baseStr = new char[base.length()];
			baseStr[i] = base.charAt(i);
		}

		for (int i = 0; i < base.length(); i++) {
			int cursor = base.length();
			if (input[i] == "L") {
				if (cursor == 0) {
					continue;
				} else {
					cursor--;
				}
			}
			if (input[i] == "D") {
				if (cursor == base.length()) {
					continue;
				} else {
					cursor++;
				}
			}
			if (input[i] == "B") {
				if (cursor == 0) {
					continue;
				} else {
					input[cursor - 1] = null;
				}
			}
			if (input[i].charAt(0) == 'P') {
				input[cursor] = String.valueOf(input[i].charAt(2));
				cursor++;
			}
			input[cursor] = String.valueOf(input[i]);
			cursor++;

		}
		System.out.println(input);

	}

}
