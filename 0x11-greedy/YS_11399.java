import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	StringTokenizer st = new StringTokenizer(br.readLine());
	int[] waitingPeople = new int[n];
	int[] prefix = new int[n];
	
	// 사람들의 배열을 입력받는다.
	for(int i = 0 ; i < n ; i++) {
		waitingPeople[i] = Integer.parseInt(st.nextToken());
	}
	
	// 정렬한다.
	Arrays.sort(waitingPeople);
	
	// 누적합의 0번 인덱스는 대기열 배열의 0번 인덱스와 같다.
	prefix[0] = waitingPeople[0];
	
	// 배열의 모든 값을 더하기 위해 cnt 변수를 선언하고
	int cnt = prefix[0];
	
	// 1번 인덱스부터 채워넣어준다.
	// 동시에 cnt에 값들도 더해준다.
	for(int i = 1 ; i < n ; i++) {
		prefix[i] = prefix[i - 1] + waitingPeople[i];
		cnt += prefix[i];
	}
  // 결과 출력
	System.out.println(cnt);
	
	
}
}
