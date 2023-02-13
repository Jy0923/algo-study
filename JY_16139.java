import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JY_16139 { 
	
	BufferedReader br;
	BufferedWriter bw;
	String s;
	int q;
	int[][] prefix;
	int alpha;
	int l;
	int r;
	StringTokenizer st;
	
	public void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		s = br.readLine();
		prefix = new int[s.length()+1][26];
		for (int i = 1; i < s.length()+1; i++) {
			prefix[i] = Arrays.copyOf(prefix[i-1], 26);
			prefix[i][((int) s.charAt(i-1)) - 97]++;
		}
		q = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			alpha = ((int) st.nextToken().charAt(0)) - 97;
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			bw.write(prefix[r+1][alpha] - prefix[l][alpha] + "\n");
		}
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException {
		new JY_16139().solution();
	}
	
}
