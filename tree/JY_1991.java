import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	
	int n, p, l, r;
	char[] lc;
	char[] rc;
	
	public void pre(int i) {
		sb.append((char)(i + 'A'));
		if (lc[i] != '.') {			
			pre(lc[i] - 'A');
		}
		if (rc[i] != '.') {
			pre(rc[i] - 'A');
		}
	}
	
	public void in(int i) {
		if (lc[i] != '.') {			
			in(lc[i] - 'A');
		}
		sb.append((char)(i + 'A'));
		if (rc[i] != '.') {
			in(rc[i] - 'A');
		}
	}
	
	public void post(int i) {
		if (lc[i] != '.') {			
			post(lc[i] - 'A');
		}
		if (rc[i] != '.') {
			post(rc[i] - 'A');
		}
		sb.append((char)(i + 'A'));
	}
	
	public void solution() throws Exception {
		n = Integer.parseInt(br.readLine());
		lc = new char[n];
		rc = new char[n];
		
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			p = input[0] - 'A';
			lc[p] = input[2];
			rc[p] = input[4];
		}
		
		pre(0);
		sb.append("\n");
		in(0);
		sb.append("\n");
		post(0);
		
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
