import java.util.Scanner;

public class JY_1436 {
	
	public void solution() {
		int n = new Scanner(System.in).nextInt();
		int curNum = 665;
		int answer = 666;
		while (n > 0) {
			curNum += 1;
			if (String.valueOf(curNum).contains("666")) {
				answer = curNum;
				n--;
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) {
		new JY_1436().solution();
	}
}
