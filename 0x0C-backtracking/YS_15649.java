import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] arr;
	static boolean[] isUsed;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 정답은 M 크기의 배열
		arr = new int[M];
		
		// isUsed 배열로 중복 확인
		isUsed = new boolean[N];
		
		// 인덱스가 0일때부터 탐색 시작
		backtracking(0);

	}

	// 인덱스 k의 값을 정하는 메소드
	public static void backtracking(int k) {
		// k == M일때, 즉 마지막 인덱스에 도달했을 때 종료
		if (k == M) {
			
			// 배열 안의 모든 요소를 출력하고 리턴
			for (int e : arr) {
				System.out.print(e + " ");
			}
			System.out.println();
			return;
		}

		// 0부터 N까지
		for (int i = 0; i < N; i++) {
			
			// 인덱스 i를 사용한 적이 없다면
			if (isUsed[i] == false) {
				
				// 정답 arr의 k번째 인덱스를 i+1로
				// 수열이 자연수로 이루어져있기 때문에 0이 아니라 1부터 시작
				arr[k] = i+1;
				
				// 사용했으니 isUsed의 i번째 인덱스는 참
				isUsed[i] = true;
				
				// 다음 k번째 인덱스의 값을 정해보자
				backtracking(k + 1);
				
				// 윗줄 재귀함수에서 도출된 값과 다른 값을 탐색하자
				// 윗줄에서 마지막 인덱스까지 채워넣었다가 다시 그 이전 단계로 돌아오기
				// 이전 단계로 돌아왔으니 isUsed의 값은 원래대로 false로 초기화한다.
				isUsed[i] = false;
			}
		}

	}

}
