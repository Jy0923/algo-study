import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static String str;
	static int q;
	static StringTokenizer st;
	static char alpha;
	static int l;
	static int r;
	static char[] strArr;
	static int[] arr;
	static int cnt;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 문자열을 입력받는다
		str = br.readLine();

		// 문자열을 문자로 쪼개서 배열로 만든다.
		strArr = str.toCharArray();

		// q를 입력받고
		q = Integer.parseInt(br.readLine());

		// 0부터 q-1까지 q개의 질문을 반복한다.
		for (int i = 0; i < q; i++) {

			// 누적합을 만들 배열을 선언한다.
			arr = new int[strArr.length];

			// 알파벳의 숫자를 세줄 cnt를 초기화해주고
			cnt = 0;

			// 한 줄을 입력받는다.
			st = new StringTokenizer(br.readLine());

			// 검색할 알파벳을 저장하고
			alpha = st.nextToken().charAt(0);

			// l과 r을 저장한다.
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			// strArr의 배열을 순회하면서
			for (int idx = 0; idx < str.length(); idx++) {

				// 찾고자 하는 알파벳의 수와 일치하면 cnt를 늘려가며 저장한다.
				if (strArr[idx] == alpha) {
					cnt++;
				}

				arr[idx] = cnt;
			}

			System.out.println(Arrays.toString(arr));

			// r 인덱스의 누적합에서 l-1 인덱스의 누적합을 빼주고
			// result에 저장한다.
			// 0일 때는 r까지의 누적합을 result에 저장한다.
			if (l == 0) {
				result = arr[r];
			} else {
				result = arr[r] - arr[l - 1];
			}

			// stringbuilder에 추가한다.
			sb.append(result + "\n");

		}
		System.out.println(sb);
	}
}
