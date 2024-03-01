import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, L;
	static int[][] info;
	static int sec;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sec=0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		info = new int[L+1][2];
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			//빨강 입력
			int idx = Integer.parseInt(st.nextToken());
			info[idx][0] = Integer.parseInt(st.nextToken()); 
			//초록 입력
			info[idx][1] = Integer.parseInt(st.nextToken()); 
		}
		
		run();
		System.out.println(sec);
		
	}
	
	public static void run() {
		for(int s=1; s<L; s++) {
			sec++;
			if(info[s][0]==0) {
				continue;
			}
			if(sec%(info[s][0]+info[s][1])>=info[s][0]) {
				continue;
			}else {
				sec+=info[s][0]-(sec%(info[s][0]+info[s][1]));
			}
		}
		//L로 가기
		sec++;
	}
	
	
}