package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1927_최소힙 {
	
	static long[] queue = new long[1000005]; // 왜 크기 이렇게해야대지,,,!?!?!?
	static int n;
	static int lastIdx = 0;
	static int parentIdx, leftChildIdx, rightChildIdx, tmpIdx;
	
	static void put(long item) {
		// 큐가 비었으면 그냥 add해주기
		if(lastIdx == 0)
			queue[++lastIdx] = item;
		
		// 큐가 안비었으면 최소힙 만들기
		else {
			// 1. 맨 마지막 위치에 삽입 후
			// 2. 부모 노드와 비교해서 부모보다 작으면 스왑
			// 3. 루트 노드까지 간다.
			queue[++lastIdx] = item; // 삽입 
			tmpIdx = lastIdx;
			
			while(true) {
				parentIdx = tmpIdx / 2; 
				
				swap(parentIdx, tmpIdx);
				
				if(parentIdx == 1) 
					break;
				
				tmpIdx = parentIdx;
			}
		}
	}
	
	static long pop() {
		// 큐가 비었으면 0 반환
		if(lastIdx == 0)
			return 0;
		// 큐가 안비었으면
		else {
			// 1. 루트노드 임시 저장 후 
			long tmp = queue[1]; // 루트노드 뺴기
			
			// 2. 루트노드에 마지막값 삽입해주고
			queue[1] = queue[lastIdx];
			queue[lastIdx--] = 0;
			
			// 3. 자식 둘 중 작은애랑 비교해서 스왑
			parentIdx = 1;
			
			// 끝까지 내려갈때까지 비교해서 스왑
			while(true) {
				leftChildIdx = parentIdx * 2;
				rightChildIdx = parentIdx * 2 + 1;
				
				// 종료조건
				if(queue[leftChildIdx] == 0) break;
				
				// 왼쪽자식이 마지막 인덱스라면
				if(leftChildIdx == lastIdx) {
					swap(parentIdx, leftChildIdx);
					
					break;
				}
				
				// 왼쪽 자식이 더 작으면 왼쪽애랑 비교
				if(queue[leftChildIdx] <= queue[rightChildIdx]) {
					swap(parentIdx, leftChildIdx);
					
					parentIdx = leftChildIdx;
				}
				// 오른쪽 자식이 더 작으면 오른쪽애랑 비교
				else if(queue[rightChildIdx] != 0){
					swap(parentIdx, rightChildIdx);
					
					parentIdx = rightChildIdx;
				}
			}
			
			return tmp;
		}
	}
	
	
	static void swap(int parentIdx, int childIdx) {
		if(queue[parentIdx] > queue[childIdx]) {
			long tmp = queue[parentIdx];
			queue[parentIdx] = queue[childIdx];
			queue[childIdx] = tmp;
		}
	}
	
	
//	static void print() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("[ ");
//		for(int i=1; i<=lastIdx; i++)
//			sb.append(queue[i]).append(" ");
//		
//		sb.append("]");
//		System.out.println(sb);
//	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0; tc<n; tc++) {
			long tmp = Long.parseLong(br.readLine());
			
			if(tmp != 0)
				put(tmp);
			else 
				sb.append(pop()).append("\n");
		}
		
		System.out.println(sb);
	}
}