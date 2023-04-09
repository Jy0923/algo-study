import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static ArrayList<ArrayList<Integer>> edgeList;
	static int[] parentArr;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] read;
		
		int N = Integer.parseInt(br.readLine());

		parentArr = new int[N+1];
		isVisited = new boolean[N+1];
		edgeList = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			edgeList.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<N-1; i++) {
			read = br.readLine().split(" ");
			
			int vertex1 = Integer.parseInt(read[0]);
			int vertex2 = Integer.parseInt(read[1]);
			
			edgeList.get(vertex1).add(vertex2);
			edgeList.get(vertex2).add(vertex1);
		}
		
		getParent();
		
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<=N; i++) {
			sb.append(parentArr[i]+"\n");
		}
		System.out.println(sb);
	}
	
	private static void getParent() {
		Queue<Integer> que = new LinkedList<>();
		que.offer(1);
		isVisited[1] = true;
		
		while(!que.isEmpty()) {
			int curNode = que.poll();
			
			for(Integer next : edgeList.get(curNode)) {
				if(isVisited[next]) continue;
				isVisited[curNode] = true;
				parentArr[next] = curNode;
				que.offer(next);
			}
			
		}
	}
}