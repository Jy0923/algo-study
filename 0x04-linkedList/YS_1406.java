import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 1. 문자들을 구성할 링크드리스트 words와 ListIterator를 생성
		LinkedList<Character> words = new LinkedList<Character>();
		ListIterator<Character> iter = words.listIterator();
		// 2. 처음 주어진 단어는 word
		String word = br.readLine();
		// 3. word 안의 문자들을 words 리스트 안에 입력
		for (int i = 0; i < word.length(); i++) {
			iter.add(word.charAt(i));
		}

		// 4. iterator의 커서를 가장 뒤로
		while (iter.hasNext()) {
			iter.next();
		}

		// 5. 들어올 명령어의 수를 num으로
		int num = Integer.valueOf(br.readLine());

		// 6. iterator를 이용하여 커서를 움직이고 문자 삭제 및 추가
		for (int i = 0; i < num; i++) {
			String order = br.readLine();
			switch (order) {
			case "L":
				if (iter.hasPrevious()) {
					iter.previous();
					continue;
				} else {
					continue;
				}
			case "D":
				if (iter.hasNext()) {
					iter.next();
					continue;
				} else {
					continue;
				}
			case "B":
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
					continue;
				} else {
					continue;
				}
			default:
				iter.add(order.charAt(2));
				continue;
			}

		}

		// 7. 결과물을 출력
		for (char c : words) {
			sb.append(c);
		}
		System.out.println(sb);

	}
}
// 배열 -> 링크드리스트로 구현 -> 시간초과 -> stringbuilder 로 바꿔봤지만 시간 초과 -> iterator 순으로 삽질했습니다