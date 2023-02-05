import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int size;
	static int[] arr;
	static int[] operatorNum;
	static ArrayList<Character> operatorChar;
	static char[] operatorArr;
	static boolean[] isUsed;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		
		// 숫자 배열 arr 선언
		arr = new int[size];
		
		// 입력받은 연산자의 숫자
		operatorNum = new int[4];
		
		// 중복 체크를 위한 isUsed 배열
		isUsed = new boolean[size - 1];
		
		// 연산자 순서를 담을 operatorArr 배열
		operatorArr = new char[size - 1];
		
		// 입력받은 연산자의 숫자를 char 리스트로
		// 리스트를 쓰는 이유는 리스트 안에 값을 가지고 있는지 확인하는 contains 메소드를 쓰기 위함
		operatorChar = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 토크나이저를 두번 써주는 이유??
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			operatorNum[i] = Integer.parseInt(st.nextToken());
		}

		// operatorChar 리스트에 연산자 캐릭터를 입력한다.
		for (int i = 0; i < 4; i++) {
			switch (i) {
			case 0:
				for (int j = 0; j < operatorNum[0]; j++) {
					operatorChar.add('+');
				}
				continue;
			case 1:
				for (int j = 0; j < operatorNum[1]; j++) {
					operatorChar.add('-');
				}
				continue;
			case 2:
				for (int j = 0; j < operatorNum[2]; j++) {
					operatorChar.add('*');
				}
				continue;
			case 3:
				for (int j = 0; j < operatorNum[3]; j++) {
					operatorChar.add('/');
				}
				continue;
			}
		}

		backTracking(0);
		System.out.println(max);
		System.out.println(min);
	}

	public static void backTracking(int k) {
		// 종료조건
		// 깊이가 size-1에 도달했을 때
		// operatorArr에 있는 연산자에 따라 계산을 진행한다.
		if (k == (size-1)) {
			int result = arr[0];
			for (int i = 0; i < operatorArr.length; i++) {
				switch (operatorArr[i]) {
				case '+':
					result += arr[i + 1];
					continue;
				case '-':
					result -= arr[i + 1];
					continue;
				case '*':
					result *= arr[i + 1];
					continue;
				case '/':
					if (result < 0) {
						result *= -1;
						result = result / arr[i + 1];
						result *= -1;
					} else {
						result = result / arr[i + 1];
					}
				}
			}
			
			// 최댓값,최솟값 갱신
			
			if (result > max) {
				max = result;
			}
			if (result < min) {
				min = result;
			}
			return;
		}

		for (int i = 0; i < operatorChar.size(); i++) {
			if (!isUsed[i]) {
				operatorArr[k] = operatorChar.get(i);
				isUsed[i] = true;
				backTracking(k + 1);
				isUsed[i] = false;
			}
		}

	}

}