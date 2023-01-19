import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1. 단어 두 개를 입력받고 각각 first와 second로 선언
		String first = br.readLine();
		String second = br.readLine();

		br.close();

		// 2. 문자 배열 두 개를 선언하고 각 배열에 단어 하나하나를 입력
		char[] firstChar = new char[first.length()];
		char[] secondChar = new char[first.length()];
		for (int i = 0; i < first.length(); i++) {
			firstChar[i] = first.charAt(i);
		}
		for (int i = 0; i < second.length(); i++) {
			secondChar[i] = second.charAt(i);
		}

		// 3. 첫 단어의 문자 중 둘째 단어의 문자와 같은 갯수
		int firstCount = 0;
		int secondCount = 0;
		for (char e : firstChar) {
			for (char x : secondChar) {
				if (e == x) {
					firstCount += 1;
					break;
				}
			}

		}

		// 4. 둘째 단어의 문자 중 첫째 단어의 문자와 같은 갯수
		for (char e : secondChar) {
			for (char x : firstChar) {
				if (e == x) {
					secondCount += 1;
					break;
				}
			}
		}

		// 5. 같은 문자의 갯수가 더 적은 쪽으로 애너그램이 성립하며 나머지 글자들을 제거.
		int result = 0;
		if (firstCount >= secondCount) {
			result = first.length() + second.length() - (secondCount * 2);
		} else {
			result = first.length() + second.length() - (firstCount * 2);
		}
		System.out.println(result);

	}
}
