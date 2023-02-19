import java.util.Scanner;

public class JY_1541{
	
	public void solution() throws Exception {	
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String[] parsing = input.split("-");
		int answer = 0;
		for (String strInt : parsing[0].split("\\+")) {
			answer += Integer.parseInt(strInt);
		}
		if (parsing.length >= 2) {
			for (int i = 1; i < parsing.length; i++) {
				for (String strInt : parsing[i].split("\\+")) {
					answer -= Integer.parseInt(strInt);
				}
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {
		new JY_1541().solution();
	}
}
