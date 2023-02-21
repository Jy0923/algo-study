package prefixSum.silver.no16139;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 인간-컴퓨터 상호작용
public class No16139_3 {
	
	static int[] arr;
	static int[][] prefixSum;
	static StringTokenizer st;
	static int a;
	static int q, l, r;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		// 소문자 a 는 96 부터 소문자 z는 122까지
		// 알파벳 소문자로만 구성되어 있으니 1 ~ 26으로 바꿔주겠음
		arr = new int[str.length()];
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(str.charAt(i));
			arr[i] -= 96; // a: 1 , z: 26
		}
		
		// a ~ z : 행
		// str의 0번부터 n번까지 해당 알파벳의 개수 : 열
		prefixSum = new int[26+1][str.length()+1];
		
		// 누적합 배열의 행에는 해당 알파벳의 int형
		// 열에는 해당 알파벳의 위치에 카운트
		for(int i=0; i<arr.length; i++) {
			prefixSum[arr[i]][i+1]++;
		}
		
		for(int i=1; i<prefixSum.length; i++) {
			for(int j=1; j<prefixSum[i].length; j++) {
				prefixSum[i][j] += prefixSum[i][j-1];
			}
		}
		
		// 잘 들어갔나 확인
//		for(int i=0; i<prefixSum.length; i++) {
//			System.out.println((char)(i+96));
//			System.out.println(Arrays.toString(prefixSum[i]));
//		}
		
		q = Integer.parseInt(br.readLine());

		for(int tc=0; tc<q; tc++) {
			st = new StringTokenizer(br.readLine());
			a = st.nextToken().charAt(0) - 96;
			l = Integer.parseInt(st.nextToken())+1; // prefixSum은 n+1이라서 편하게 +1함
			r = Integer.parseInt(st.nextToken())+1;
			
			sb.append(prefixSum[a][r] - prefixSum[a][l-1]).append("\n");
		}
		
		System.out.println(sb);
	}
}

 