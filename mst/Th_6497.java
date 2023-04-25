import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
	
	static int numOfHouse, numOfRoad, spendMoney, totalMoney;
	
	static ArrayList<ArrayList<int[]>> roadList;
	
	static int[] parentArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] read;
		StringBuilder answer = new StringBuilder();
		
		while(true) {
			read = br.readLine().split(" ");
			numOfHouse = Integer.parseInt(read[0]);
			numOfRoad = Integer.parseInt(read[1]);
			
			if(numOfHouse == 0) break;
			
			totalMoney = 0;
			spendMoney = 0;
			
			parentArr = new int[numOfHouse];
			for(int i=0; i<numOfHouse; i++) {
				parentArr[i] = i;
			}
			
			PriorityQueue<Road> roadQue = new PriorityQueue<>();
			
			for(int i=0; i<numOfRoad; i++) {
				read = br.readLine().split(" ");
				
				int city1 = Integer.parseInt(read[0]);
				int city2 = Integer.parseInt(read[1]);
				int length = Integer.parseInt(read[2]);
				
				totalMoney += length;
				
				roadQue.add(new Road(city1, city2, length));
			}
			
			while(!roadQue.isEmpty()) {
				Road curRoad = roadQue.poll();
				
				int city1 = curRoad.city1;
				int city2 = curRoad.city2;
				int length = curRoad.length;
				
				if(find(city1) == find(city2)) {
					continue;
				}
				
				spendMoney += length;
				union(city1, city2);
			}
			
			answer.append((totalMoney - spendMoney) + "\n");
		}
		System.out.println(answer);
		br.close();
	}
	
	private static int find(int a) {
		if(parentArr[a] == a) {
			return a;
		} else  {
			return parentArr[a] = find(parentArr[a]);
		}
	}
	
	private static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if(parentA != parentB) {
			if(parentA < parentB) {
				parentArr[parentB] = parentA;
			} else {
				parentArr[parentA] = parentB;
			}
		}
	}
	
	private static class Road implements Comparable<Road>{
		int city1, city2, length;

		public Road(int city1, int city2, int length) {
			this.city1 = city1;
			this.city2 = city2;
			this.length = length;
		}

		@Override
		public int compareTo(Road o) {
			return this.length - o.length;
		}
	}
}