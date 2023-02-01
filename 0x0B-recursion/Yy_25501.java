import java.util.Scanner;

public class Yy_25501 {
	// 재귀의귀재귀의귀재귀의귀재
	
	// 집가서 더풀어보고 수정할예정
	
	static int cnt = 0;
	
    public static int recursion(String s, int l, int r){
        // 메서드 호출될때마다 cnt++
    	cnt++;
    	
    	if(l >= r) {
    		return 1;
    	}
        else if(s.charAt(l) != s.charAt(r)) {
        	return 0;
        }
        else {
        	return recursion(s, l+1, r-1);
        }
    	
    }
    
    
    public static int isPalindrome(String s){
    	
    	// String s의 첫 인덱스[0]와 마지막 인덱스[s.length()-1]부터 확인
        return recursion(s, 0, s.length()-1);
    }
    
    
    public static void main(String[] args){
    	
    	Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt(); 	sc.nextLine();
    	
    	for(int i=0; i<t; i++) {
    		String s = sc.nextLine();
    		
    		System.out.printf("%d %d\n", isPalindrome(s), cnt);
    		
    		cnt = 0; // 다음 반복위해 초기화
    	}
    	
    }
	
    
}
