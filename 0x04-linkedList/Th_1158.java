import java.util.LinkedList;
import java.util.Scanner;

public class Th_1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int remove = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<>(); // N번까지의 정수를 담은 연결리스트
		
		//리스트 값 할당
		for(int i=1; i<=N; i++)
			list.add(i);
		
		int[] answer = new int[N]; //요세푸스 순열을 담을 배열
		int idx = 0; //요세푸스 순열의 인덱스
		int removeIdx = 0; //연결리스트에서 제거할 인덱스
		
		//연결리스트의 값이 모두 삭제 될 때 까지 반복
		while(!list.isEmpty()) {
			//제거할 인덱스 구하기
			removeIdx = (removeIdx + remove - 1) % list.size();
			
			//제거할 값 요세푸스 배열에 추가
			answer[idx++] = list.get(removeIdx);
			//값 제거
			list.remove(removeIdx);
		}
		
		
		System.out.print("<");
		for(int i=0; i<N; i++) {
			if(i == N-1)
				System.out.print(answer[i]);
			else
				System.out.print(answer[i]+", ");
		}
		System.out.print(">");
	}
}
