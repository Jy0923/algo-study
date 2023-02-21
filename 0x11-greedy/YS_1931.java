import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 회의의 수 n을 입력받는다.
	int n = Integer.parseInt(br.readLine());
	
	// 회의 시간을 나타낼 2차원 배열을 선언한다.
	int[][] meetings = new int[n][1];
	
	// n번 돌면서 값을 입력받는다.
	for (int i = 0 ; i < n; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 각 회의를 넣을 배열을 새로 만들고
		int[] meetingElement = new int[2];
		
		// 값들을 넣어준다. 
 		meetingElement[0] = Integer.parseInt(st.nextToken());
		meetingElement[1] = Integer.parseInt(st.nextToken());
		
		
		// 이 배열을 meetings에 넣어준다.
		meetings[i] = meetingElement;
	}

	// 회의실 배열을 정렬하는데 끝나는 시간 기준으로 오름차순
	// 끝나는 시간이 같으면 시작하는 시간이 빠른 순으로 정렬한다.
	Arrays.sort(meetings, new Comparator<int[]>() {
		@Override
		// compare 메소드는 두 값을 비교하는
		public int compare(int[] o1, int[] o2) {
			
			// 두 배열의 두 번째 인자, 회의실 배열의 끝나는 시간이 같으
			if (o1[1] == o2[1]) {
				
				// 첫번째 인자가 더 크면 교환하고(큰수가 뒤로 간다)
				return o1[0] - o2[0];
			} else {
				
				// 아니면 두번째 인자가 더 클 때 교환한다.(큰 수가 뒤로 간다)
				return o1[1] - o2[1];
			}
		}
	});
	
	// 회의의 수를 나타낼 ans를 선언하
	int ans = 0;
	
	// 회의가 끝나는 시간을 나타낼 t를 선언한다.
	int t = 0;
	
	// 0부터 n-1까지 돌면
	for (int i = 0; i < n; i++) {
		
		// 만약 진행중인 회의가 끝나는 시간이 현 인덱스의 시작 시간보다 뒤라
		if (t > meetings[i][0]) {
			
			// 이번 인덱스는 넘어간다.
			continue;
		}
		
		// 그렇지 않으면 회의의 수를 더하
		ans++;
		
		// 회의가 끝나는 시간을 이번 인덱스의 끝나는 시간으로 설정한다.
		t = meetings[i][1];
	}
	
	// 정답을 출력한다.
	System.out.println(ans);


	
	
}
}
