import java.util.Scanner;

public class main {
	static Scanner sc = new Scanner(System.in);

	static int num = sc.nextInt();

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		sb.append((int) (Math.pow(2, num) - 1)).append('\n');

		Hanoi(num, 1, 2, 3);
		System.out.println(sb);

	}

	public static void Hanoi(int num, int start, int mid, int to) {
		if (num == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}

		Hanoi(num - 1, start, to, mid);
		sb.append(start + " " + to + "\n");
		Hanoi(num - 1, mid, start, to);

	}

}
// 코드는 블로그에서 그대로 복붙이고 하노이의 탑이랑 재귀함수에 대해 이해하는데 중점을 뒀습니다.
// 재귀함수 손으로 따라가면서 풀어봤는데 쉽지 않네요,,
