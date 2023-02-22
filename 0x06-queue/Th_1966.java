import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Th_1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCases = sc.nextInt();
		
		for(int tc=0; tc<testCases; tc++) {
			int numberOfPaper = sc.nextInt(); //문서의 개수
			int targetIdx = sc.nextInt(); //찾는 문서의 인덱스
			
			Queue<Paper> paperQueue = new LinkedList<>(); //문서를 담을  큐
			TreeMap<Integer, Integer> priorityMap =
					new TreeMap<>(Collections.reverseOrder()); //중요도를 오름차순으로 담을 맵
			
			//문서 정보 입력 받기
			for(int idx=0; idx<numberOfPaper; idx++) {
				int priority = sc.nextInt(); //현재 문서의 중요도
				
				priorityMap.put(priority, priorityMap.getOrDefault(priority, 0) + 1);
				paperQueue.offer(new Paper(priority, idx));
			}
			
			int cnt = 1; //인쇄 순서
			while(true) {
				Paper curPaper = paperQueue.poll(); //현재 문서
				int curPriority = curPaper.priority;
				int curIdx = curPaper.idx;
				
				if(curPriority != priorityMap.firstKey()) { //남은 문서 중에 중요도가 더 높은 문서가 있다면
					paperQueue.offer(curPaper); //맨 뒤로
					
				} else {
					if(curIdx == targetIdx) break; //현재 인돼되는 문서가 찾는 문서라면 종료
					
					priorityMap.put(curPriority, priorityMap.get(curPriority)-1);
					if(priorityMap.get(curPriority) == 0) { //해당 중요도의 문서가 모두 인쇄됐다면
						priorityMap.remove(curPriority); //맵에서 제거
					}
					cnt++; //인쇄 순서 추가
				}
			}
			//출력
			System.out.println(cnt);
		}
	}
	
	private static class Paper{
		int priority;
		int idx;
		
		public Paper(int priority, int idx) {
			this.priority = priority;
			this.idx = idx;
		}
	}
}