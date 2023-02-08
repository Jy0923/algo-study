import java.util.Scanner;

public class JY_9663{

	int n;
	boolean[] isused;
	int[] queenPos;
	int cnt;
	
	public boolean checkDiag(int k, int pos) {
		for (int i = 0; i < k; i++) {
			if ((k+pos) == (i + queenPos[i])) {
				return false;
			}
			if ((k-pos) == (i-queenPos[i])) {
				return false;
			}
		}
		return true;
	}
	
	public void backtracking(int k) {
		if (k == n) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!isused[i] && checkDiag(k, i)) {
				isused[i] = true;
				queenPos[k] = i;
				backtracking(k+1);
				isused[i] = false;
			}
		}
	}
	
	
	public void solution() {
		n = new Scanner(System.in).nextInt();
		isused = new boolean[n];
		queenPos = new int[n];
		backtracking(0);
		System.out.println(cnt);
	}
	
	public static void main(String[] args) {
		new JY_9663().solution();
	}

}
