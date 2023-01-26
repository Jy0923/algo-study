import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1. 들어올 문자의 수를 keylen으로 지정

		int keyLen = Integer.valueOf(br.readLine());

		// 2. keylen만큼의 string 배열 생성
		String[] input = new String[keyLen];

		// 3. 각 배열에 문자들 입력
		for (int i = 0; i < keyLen; i++) {
			input[i] = br.readLine();
		}

		br.close();

		// 4. 각 string 배열을 하나씩 꺼내면서 수행

		for (int i = 0; i < keyLen; i++) {

			// 5. 기본 커서의 위치는 0, 매 배열마다 문자 타입의 새로운 링크드리스트를 생성
			int cursor = 0;
			LinkedList<Character> words = new LinkedList<Character>();
			for (int j = 0; j < input[i].length(); j++) {
				// 6. <, >, -, 문자 별로 연산 지정
				switch (input[i].charAt(j)) {
				case '<':
					if (cursor != 0) {
						cursor--;
						break;

					} else {
						break;
					}

				case '>':
					if (cursor < words.size()) {
						cursor++;
						break;
					} else {
						break;
					}

				case '-':
					if (cursor != 0) {

						words.remove(cursor - 1);
						cursor--;
						break;
					} else {
						break;
					}

				default:
					if (cursor > words.size()) {
						words.add(input[i].charAt(j));
						cursor++;
						break;
					} else {
						words.add(cursor, input[i].charAt(j));
						cursor++;
						break;
					}

				}

			}

			// 7. 링크드리스트 내의 요소들을 출력
			StringBuilder sb = new StringBuilder();
			for (char c : words) {
				sb.append(c);
			}
			System.out.println(sb);

		}
	}
}
