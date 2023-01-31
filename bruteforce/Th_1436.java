import java.util.Scanner;

public class Th_1436 {
	public static void main(String[] args) {
		String markOfBeast = "666";
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cnt = 1;
		int num = 666;
		
		while(cnt != N) {
			String tmp = String.valueOf(++num);
			if(tmp.contains(markOfBeast))
				cnt++;
		}
		
		System.out.println(num);
	}
}
