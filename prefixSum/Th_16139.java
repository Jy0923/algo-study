import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Th_16139 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder(); //정답 저장할 스트링빌더

		char find; //찾는 문자
		String[] read;
		char[] str = br.readLine().toCharArray(); //받은 문자열
		int[][] cnt = new int[26][str.length+1]; //알파벳마다 누적합
		boolean[] check = new boolean[26]; //알파벳이 문자열에 있는지
		
		//check 배열 만들어주기
		for(char c : str) {
			check[c - 97] = true;
		}
		
		//cnt 배열 만들어주기
		for(int i=0; i<26; i++) {
			if(!check[i]) continue;
			
			int findCnt = 0;
			
			for(int j=1; j<=str.length; j++) {
				if(str[j-1] == (char)(i+97)) {
					findCnt++;
				}
				
				cnt[i][j] = findCnt;
			}
		}
			
		//테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			read = br.readLine().split(" ");
			
			find = read[0].charAt(0); // 찾는 문자
			int l = Integer.parseInt(read[1]) + 1; //시작
			int r = Integer.parseInt(read[2]) + 1; //끝
			
			sb.append((cnt[find-97][r] - cnt[find-97][l-1]) +"\n");
		}
		
		System.out.println(sb);
	}
}