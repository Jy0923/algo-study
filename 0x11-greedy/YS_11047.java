import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	// n과 k를 입력받는다.
	int n = Integer.parseInt(st.nextToken());
	int value = Integer.parseInt(st.nextToken());
	
	// 동전의 수를 저장할 cnt를 선언한다.
	int cnt = 0;
	
	// 동전의 배열을 선언하고 저장한다.
	int[] coin = new int[n];
	for (int i = 0; i < n ; i++) {
		coin[i] = Integer.parseInt(br.readLine());
	}

	
	// 배열의 끝에서부터 나눈 몫을 저장한다.
	// 나머지가 발생하면 해당 나머지로 value 값을 갱신한다.
	for(int i = n-1 ; i >= 0; i--) {
			cnt += value / coin[i];
			value = value % coin[i];
		}
	
	// 동전의 수를 출력한다.
	System.out.println(cnt);
	}	

	
}
