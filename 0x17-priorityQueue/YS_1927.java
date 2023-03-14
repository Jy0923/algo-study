import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static long[] heap = new long[1000005];
	static int size = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < n; i++) {
			long j = Long.parseLong(br.readLine());
			if(j == 0) {
				System.out.println(pop());

			} else {
				push(j);
			}
			
		}
	}

	static void push(long x) {
		heap[++size] = x;
		int index = size;
		while (index != 1) {
			int parent = index / 2;
			if (heap[index] >= heap[parent])
				break;

			long temp = heap[index];
			heap[index] = heap[parent];
			heap[parent] = temp;
			index = parent;

		}
	}

	static long pop() {
		if (size == 0) {
			return 0;
		}
		
		long result = heap[1];
		heap[1] = heap[size--];

		heap[size+1] = 0;
		int index = 1;

		while (index * 2 <= size) {
			int leftChild = index * 2;
			int rightChild = (index*2) + 1;
			int minChild = leftChild;
			if(rightChild <= size && heap[rightChild] < heap[leftChild])
				minChild = rightChild;
			if(heap[index] <= heap[minChild]) break;
			long temp = heap[index];
			heap[index] = heap[minChild];
			heap[minChild] = temp;
			index = minChild;
			
			
		}
		return result;

	}


}
