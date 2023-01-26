package linkedListed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bk_5397_ {
	static final int MX = 1_000_001;
	static char[] dat = new char[MX];
	static int[] pre = new int[MX];
	static int[] nxt = new int[MX];
	static int unused = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int cursor;
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String pw = br.readLine();
			cursor = 0;
			Arrays.fill(pre, -1);
			Arrays.fill(nxt, -1);

			for (int i = 0; i < pw.length(); i++) {
				if (pw.charAt(i) == '-') { // 문자가 커서 왼쪽에 위치시 삭제
					if (pre[cursor] != -1) {
						erase(cursor);
						cursor = pre[cursor];
					}
				} else if (pw.charAt(i) == '<') { // 커서 왼쪽 이동
					if (pre[cursor] != -1) {
						cursor = pre[cursor];
					}
				} else if (pw.charAt(i) == '>') { // 커서 오른쪽 이동
					if (nxt[cursor] != -1) {
						cursor = nxt[cursor];
					}
				} else { // 문자 입력
					insert(cursor, pw.charAt(i));
					if (nxt[cursor] != -1)
						cursor = nxt[cursor];
				}

			}

			unused = 1;
			printAll(sb).append('\n');
		}
		System.out.println(sb);
		br.close();
	}

	static void insert(int idx, char ch) {
		dat[unused] = ch; // 새로운 원소
		pre[unused] = idx; // 삽입할 위치 주소
		nxt[unused] = nxt[idx]; // 삽입할 위치의 nxt 값
		if (nxt[idx] != -1) // 맨 마지막 원소일 경우
			pre[nxt[idx]] = unused;

		nxt[idx] = unused;
		unused++;
	}

	static void erase(int idx) {
		nxt[pre[idx]] = nxt[idx]; // 이전 위치의 nxt를 삭제할 위치의 nxt로 변경
		if (nxt[idx] != -1) // 만약, 배열 끝이 아니라면,
			pre[nxt[idx]] = pre[idx]; // 다음 위치의 pre를 삭제할 위치의 pre로 변경ㄷ
	}

	static StringBuilder printAll(StringBuilder sb) {
		int cur = nxt[0];
		while (cur != -1) {
			sb.append(dat[cur]);
			cur = nxt[cur];
		}
		return sb;
	}

	// 이번주 강의 영상에서 소개한 야매연결리스트로 구현해서 풀어보았슴다...
	// 혼자 구현은 아직 어려워서 영상 따라가면서 구현했고, 그래서 뒤에 언더바 추가했습니다.

}
