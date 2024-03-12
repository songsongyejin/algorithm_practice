import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r, c, ans;
	static char[][] arr;
//	static int[][] W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new char[r][c];

//		W = new int[2][2];

		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		ans = 0;
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(arr[i][j]=='L') {
					bfs(i,j);
				}
			}
		}
		
		System.out.println(ans);
	}


	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs(int k, int h) {
		Queue<Integer> rQue = new LinkedList<>();
		Queue<Integer> cQue = new LinkedList<>();
		int[][] visit = new int[r][c];
		rQue.offer(k);
		cQue.offer(h);
		visit[rQue.peek()][cQue.peek()]=-1;
		while (!rQue.isEmpty() && !cQue.isEmpty()) {
			int cr = rQue.poll();
			int cc = cQue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(nr>=0&&nc>=0&&nr<r&&nc<c&&arr[nr][nc]=='L'&&visit[nr][nc]==0) { 
					if(visit[cr][cc]==-1) { //붙어있는 경우 
						visit[nr][nc] = 1;
//						System.out.println("여기");
					}else {
						visit[nr][nc] = visit[cr][cc]+1;
					}
					rQue.offer(nr);
					cQue.offer(nc);
					ans = Math.max(ans, visit[nr][nc]);
				}
			}

		}

	}

}