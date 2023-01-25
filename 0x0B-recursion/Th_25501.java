import java.util.Scanner;

public class Th_25501 {
	static int cnt;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			String S = sc.next();
			cnt = 0;
			int is = isPalindrome(S);
			
			System.out.println(is + " " + cnt);
		}
    }
	
    public static int recursion(String s, int l, int r){
        cnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}
