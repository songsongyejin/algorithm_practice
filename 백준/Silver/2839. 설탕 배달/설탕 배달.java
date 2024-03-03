import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		int ans = -1;
		
		int max5 = N/5;
		
		for(int i=max5; i>=0; i--) {
			if((N-(5*i))%3==0){
				ans = i + ((N-(5*i))/3);
				break;
			}
		}
		System.out.println(ans);
		
	}
}