package silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1018 {
	public static void main(String[] args) throws IOException {
		
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        String str = br.readLine();
	        int n = Integer.parseInt(str.split(" ")[0]);
	        int m = Integer.parseInt(str.split(" ")[1]);
	        
	        String[] jimin = new String[n];
	        
	        for(int i=0; i<n; i++) 
	        	jimin[i] = br.readLine();
	        
	        
	        int minCnt = Integer.MAX_VALUE;
	        
	        for(int i=0; i<n-7; i++) {
	        	for(int j=0; j<n-7; j++) {
	        		
	        		int oddB = 0;
	        		int evenB = 0;
	        		int oddW = 0;
	        		int evenW = 0;
	        		
	        		for(int k=0; k<8; k++) {
	        			for(int x=0; x<8; x++) {
	        				
	        				if(jimin[i+k].charAt(j+x) == 'B') {
	        					if((i+k+j+x) % 2 == 0)
	        						evenB++;
	        					else
	        						oddB++;
	        				} else if(jimin[i+k].charAt(j+x) == 'W') {
	        					if((i+j+k+x) % 2 == 0)
	        						evenW++;
	        					else
	        						oddW++;
	        				}
	        			}
	        		}
	        		if(minCnt > oddB + evenW || minCnt > oddW + evenB)
	        			minCnt = Math.min(oddB + evenW, oddW + evenB);
	        	}
	        }
	        System.out.println(minCnt);
		
	}
	
}
