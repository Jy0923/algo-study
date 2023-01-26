import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class JY_11729 {
	
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public void hanoii(int from, int mid, int to, int n) throws IOException {
		if (n == 1) {
			bw.write(from + " " + to + "\n");
			return;
		}
		hanoii(from, to, mid, n-1);
		bw.write(from + " " + to + "\n");
		hanoii(mid, from, to, n-1);
	}
	
	public void solution() throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println((int)Math.pow(2, n) - 1);
		hanoii(1, 2, 3, n);
		bw.flush();
	}
	
	public static void JY_11729(String[] args) throws Exception{
		new Main().solution();
	}
}
