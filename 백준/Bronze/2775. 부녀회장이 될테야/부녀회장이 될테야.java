import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int maxN = 14;
		int maxK = 14;
		
		//dp 배열 구하기
		int[][] dp = new int[maxK+1][maxN+1];
		
		for(int i=1; i<=maxN; i++) {
			dp[0][i] = i;
		}
		
		for(int i=1; i<=maxK; i++) {
			for(int j=1; j<=maxN; j++) {
				if(j==1) {
					dp[i][j] = dp[i-1][j];
					continue; //1호는 동일
				}
				dp[i][j] = dp[i][j-1]+dp[i-1][j]; //이전 호수 + 아래층의 인원수
			}
		}
		
		//입력 받기
		//test case 수
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[k][n]);
		}
		
	}
}