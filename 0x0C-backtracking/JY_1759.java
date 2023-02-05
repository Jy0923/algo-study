import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class JY_1759 {
	
	Set<Character> aeiou = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int l;
	int c;
	char[] candidate;
	char[] arr;
	boolean[] isused;
	int cntMo = 0;
	int cntJa = 0;
	
	public void backtracking(int k) throws IOException {
		if (k == l) {
			if (cntMo >= 1 && cntJa >= 2) {
				for (int i = 0; i < l; i++) {
					bw.write(arr[i]);
				}
				bw.newLine();
			}
			return;
		}
		
		char start = 'a';
		if (k != 0) {
			start = arr[k-1];
		}
		for (int i = 0; i < c; i++) {
			if (isused[i] == false && candidate[i] >= start){
				boolean isMo = aeiou.contains(candidate[i]);
				isused[i] = true;
				arr[k] = candidate[i];
				if (isMo) {
					cntMo++;
				} else {
					cntJa++;
				}
				backtracking(k+1);
				if (isMo) {
					cntMo--;
				} else {
					cntJa--;
				}
				isused[i] = false;
			}
		}
	}
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new char[l];
		candidate = new char[c];
		isused = new boolean[c];
		for (int i = 0; i < c; i++) {
			candidate[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(candidate);
		backtracking(0);
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException {
		new JY_1759().solution();
	}
}
