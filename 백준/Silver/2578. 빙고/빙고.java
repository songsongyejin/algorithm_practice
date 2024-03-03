import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//빙고 최소 12개임
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] bingo = new int[5][5];
		int[][] numInfo = new int[26][2];
		for(int r=0; r<5; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<5; c++) {
				int num = Integer.parseInt(st.nextToken());
				numInfo[num][0]=r;
				numInfo[num][1]=c;
			}
		}
		int cnt = 0;
		a: for(int r=0; r<5; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<5; c++) {
				cnt++;
				int num = Integer.parseInt(st.nextToken());
				bingo[numInfo[num][0]][numInfo[num][1]] = 1;
				if(cnt>=12&&ispossible(bingo)) {
				//최소 12개 이상이어야 빙고가 생성됨
					System.out.println(cnt);
					 break a;
				}
			}
		}
	}

	static boolean ispossible(int[][] bingo) {
		int bNum=0;
		int nr=0;
		int nc=0;
		
		//대각선 탐색
		int[] dr = {1,1};
		int[] dc = {1,-1};
		for(int i=0; i<2; i++) {
			while(nr>=0&&nr<5&&nc>=0&&nc<5&&bingo[nr][nc]==1) {
				nr += dr[i];
				nc += dc[i];
			}
			if((nr==5&&nc==5)||(nr==5&&nc==-1)) {
				bNum++;
			}
			nr = 0;
			nc = 4;
		}
		//행 탐색
		b:for(int r=0; r<5; r++) {
			for(int c =0; c<5; c++) {
				if(bingo[r][c]!=1) continue b;
			}
			bNum++;
			if(bNum>=3) return true;
		}
		//열탐색
		c:for(int c=0; c<5; c++) {
			for(int r =0; r<5; r++) {
				if(bingo[r][c]!=1) continue c;
			}
			bNum++;
			if(bNum>=3) return true;
		}
		
		
		return false;
	}
}