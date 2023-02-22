import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Th_11866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numberOfPeople = sc.nextInt(); //사람의 수
		int removeCount = sc.nextInt(); //제거할 사람의 순서
		int[] josephus = new int[numberOfPeople]; //제거되는 순서를 담음 배열
		
		Queue<Integer> personQueue = new LinkedList<>(); //사람들을 담은 queue
		
		//queue에 사람들 추가
		for(int i=1; i<=numberOfPeople; i++) {
			personQueue.offer(i);
		}
		
		int idx = 0; //josephus배열 인덱스
		while(!personQueue.isEmpty()) { //queue가 빌 때까지 반복
			for(int cnt=0; cnt<removeCount-1; cnt++) { //removeCount까지
				int person = personQueue.poll(); //맨앞의 사람을
				personQueue.offer(person); //맨뒤로
			}
			josephus[idx++] = personQueue.poll(); //romoveCount가 되면 queue에서 제거해서 josephus에 추가
		}
		
		//출력할 문장을 담을 StringBuilder
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i=0; i<numberOfPeople; i++) {
			if(i == numberOfPeople-1) sb.append(josephus[i] + ">");
			else sb.append(josephus[i] + ", ");
		}
		//출력
		System.out.println(sb);
	}
}