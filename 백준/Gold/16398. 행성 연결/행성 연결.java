import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //행성의 수
		long[][] price = new long[N][N]; //플로우 관리비용 
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				price[r][c] = Long.parseLong(st.nextToken());
			}
		}
		//----입력완료----
		
		int[] visited = new int[N];
		long totalPrice = 0;
		long[] minPrice = new long[N];
		Arrays.fill(minPrice, Long.MAX_VALUE);
		minPrice[0] = 0;
		
		for(int r=0; r<N-1; r++) {
			//간선 선택 개수
			
			long min = Long.MAX_VALUE;
			int idx = -1;
			for(int c=0; c<N; c++) {
				if(visited[c]==1) continue; 
				if(minPrice[c]<min) {
					min=minPrice[c];
					idx=c;
				}
			}
			
			for(int c=0; c<N; c++) {
				if(visited[c]==0&&price[idx][c]<minPrice[c]&&c!=idx) {
					minPrice[c] = price[idx][c];
				}
			}
			
			visited[idx]=1;
		}
		
		for(int r=0; r<N; r++) {
			totalPrice += minPrice[r];
		}
		System.out.println(totalPrice);
		
	}
}