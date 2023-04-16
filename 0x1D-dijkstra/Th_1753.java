import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	
	static int numOfVer, numOfEdge, startVer;
	static ArrayList<ArrayList<Edge>> edgeList;
	static boolean[] isVisited;
	static int[] minValue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] read = br.readLine().split(" ");
		
		numOfVer = Integer.parseInt(read[0]);
		numOfEdge = Integer.parseInt(read[1]);
		startVer = Integer.parseInt(br.readLine());
		
		isVisited = new boolean[numOfVer+1];
		minValue = new int[numOfVer+1];
		Arrays.fill(minValue, Integer.MAX_VALUE);
		
		edgeList = new ArrayList<>();
		for(int i=0; i<=numOfVer; i++) {
			edgeList.add(new ArrayList<>());
		}
		
		for(int i=0; i<numOfEdge; i++) {
			read = br.readLine().split(" ");
			int from = Integer.parseInt(read[0]);
			int to = Integer.parseInt(read[1]);
			int value = Integer.parseInt(read[2]);
			
			edgeList.get(from).add(new Edge(to, value));
		}
		
		getMinFromStartVertex(startVer);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=numOfVer; i++) {
			if(i == startVer) {
				sb.append(0+"\n");
			} else if(minValue[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(minValue[i]+"\n");
			}
		}
		System.out.println(sb);
	}
	
	private static void getMinFromStartVertex(int startVertex) {
		PriorityQueue<Edge> edgeQue = new PriorityQueue<>();
		edgeQue.offer(new Edge(startVertex, 0));
		
		while(!edgeQue.isEmpty()) {
			Edge cur = edgeQue.poll();
			
			if(isVisited[cur.to]) continue;
			isVisited[cur.to] = true;
			
			if(cur.value > minValue[cur.to]) continue;
			minValue[cur.to] = cur.value;
			
			for(Edge edge : edgeList.get(cur.to)) {
				edgeQue.offer(new Edge(edge.to, edge.value + minValue[cur.to]));
			}
		}
	}
	
	private static class Edge implements Comparable<Edge>{
		int to, value;

		public Edge(int to, int value) {
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {
			return this.value - o.value;
		}
	}
}