import java.util.PriorityQueue;
import java.util.Scanner;

public class Th_1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		PriorityQueue<Meeting> pq = new PriorityQueue<>();
		
		int lastTime = 0;
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			pq.offer(new Meeting(start, end));
		}
		
		while(!pq.isEmpty()) {
			Meeting curMeeting = pq.poll();
			int start = curMeeting.start;
			int end = curMeeting.end;
			
			System.out.println(start + " " + end);
			
			if(start >= lastTime) {
				lastTime = end;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	private static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			//끝나는 시간 같으면
			if(this.end == o.end) {
				//시작시간 오름차순
				return o.start - this.start;
			}
			return this.end - o.end;
		}
	}
}