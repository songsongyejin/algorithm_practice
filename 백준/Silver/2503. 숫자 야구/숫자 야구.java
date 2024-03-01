import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[][] minanswer;
	static int ans, N;
	static boolean[] youngFind;
	static int[] currY;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		minanswer= new String[N][];
		ans = 0;
		youngFind = new boolean[10];
		currY = new int[3];
		//입력 받기
		for(int n=0; n<N; n++) {
			minanswer[n] = br.readLine().split(" ");
		}
		
		find(0);
		System.out.println(ans);
		
		
	}
	
	public static void find(int idx) {
		if(idx>=3) {
			ispossible();
			return;
		}
		
		for(int i=1; i<=9; i++) {
			if(youngFind[i]) continue;
			
			//사용한다
			youngFind[i] = true;
			currY[idx] = i;
			find(idx+1);
			youngFind[i] = false;
			
		}
		
		
	}

	public static void ispossible() {
		
		for(int i=0; i<N; i++) {
			int currS = 0;
			int currB = 0;
			for(int j=0; j<3; j++) {
				//j=영수 숫자의 인덱스
				for(int k=0; k<3; k++) {
					//k=민혁이가 답한 숫자의 인덱스
					if(currY[j]==(minanswer[i][0].charAt(k)-'0')) {
						if(k==j) {
							currS++;
							continue;
						}
						currB++;
					}
				}
			}
			if(currS!=Integer.parseInt(minanswer[i][1])||currB!=Integer.parseInt(minanswer[i][2]))return;
		}
		
		//for문을 나왔다는건 성립한다는 것.
		ans++;
		
	}
	
}