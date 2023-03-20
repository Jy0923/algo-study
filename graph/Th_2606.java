package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2606_바이러스 {
	
	static int numOfCum;
	static int numOfCon;
	
	static ArrayList<ArrayList<Integer>> network;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		numOfCum = sc.nextInt();
		numOfCon = sc.nextInt();
		sc.nextLine();
		
		network = new ArrayList<>();
		for(int i=0; i<=numOfCum; i++) {
			network.add(new ArrayList<Integer>());
		}
		
		String[] read;
		for(int i=0; i<numOfCon; i++) {
			read = sc.nextLine().split(" ");
			
			int a = Integer.parseInt(read[0]);
			int b = Integer.parseInt(read[1]);
			
			network.get(a).add(b);
			network.get(b).add(a);
		}
		
		System.out.println(BFS());
	}
	
	private static int BFS() {
		int infected = 0;
		
		Queue<Integer> que = new LinkedList<>();
		que.offer(1);
		
		boolean[] isInfected = new boolean[numOfCum+1];
		isInfected[1] = true;
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			
			for(Integer next : network.get(cur)) {
				if(isInfected[next]) continue;
				isInfected[next] = true;
				que.offer(next);
				infected++;
			}
		}
		return infected;
	}
}
