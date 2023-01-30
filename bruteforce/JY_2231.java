import java.util.Scanner;

public class JY_2231 {
	
	public void solution(){
		int n = new Scanner(System.in).nextInt();
		
		int answer = 0;
		String curStr;
		int curSum;
		
		for (int i = 1; i < n; i++) {
			curStr = String.valueOf(i);
			curSum = i;
			for (int j = 0; j < curStr.length(); j++) {
				curSum += Character.getNumericValue(curStr.charAt(j));
			}
			if (curSum == n) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
	public static void main(String[] args){
		new JY_2231().solution();
	}
}
