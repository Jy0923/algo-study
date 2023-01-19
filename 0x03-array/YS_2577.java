import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
                            // A, B, C를 인자로 받음
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

                            // A, B, C를 곱하고 결과값을 문자열로 변환
		int num = (A * B * C);
		String str = String.valueOf(num);

                            // 각 숫자를 나타낼 배열 number와 결과값 내의 각 char를 나타낼 multiple 배열 선언
		int[] number = new int[10];
		char[] multiple = new char[str.length()];

                            // multiple 배열에 각 숫자를 순서대로 입력
		for (int i = 0; i < str.length(); i++) {
			multiple[i] = str.charAt(i);
		}
                            // multiple 안의 인자들의 개수대로 number 배열에 추가
		for (char e : multiple) {
			switch (e) {
			case '0':
				number[0] += 1;
				break;
			case '1':
				number[1] += 1;
				break;
			case '2':
				number[2] += 1;
				break;
			case '3':
				number[3] += 1;
				break;
			case '4':
				number[4] += 1;
				break;
			case '5':
				number[5] += 1;
				break;
			case '6':
				number[6] += 1;
				break;
			case '7':
				number[7] += 1;
				break;
			case '8':
				number[8] += 1;
				break;
			case '9':
				number[9] += 1;
				break;
			}
		}

                            // number 배열 내의 인자들 출력
		for (int e : number) {
			System.out.println(e);
		}

	}
}
