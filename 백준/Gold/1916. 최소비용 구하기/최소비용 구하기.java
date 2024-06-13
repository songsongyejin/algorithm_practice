import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
		
		static class Node{
			int c; //city
			int price;

			public Node(int c, int price) {
				this.c = c;
				this.price = price;
			}
			
		}
		
		
		public static List<Node>[] city;
		public static int N, M;
		public static int startPoint;
		public static int endPoint;
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		M = Integer.parseInt(br.readLine()); // 버스의 개수
		
		city = new ArrayList[N+1];
		//초기화
		for(int n=1; n<=N; n++) {
			city[n] = new ArrayList<>();
		}
		
		//입력받기
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			city[s].add(new Node(e,p));
		}
		st = new StringTokenizer(br.readLine());
		
		startPoint = Integer.parseInt(st.nextToken()); //시작점
		endPoint = Integer.parseInt(st.nextToken()); //끝점
		
		//----입력 완료----
		
		System.out.println(dijkstra());
		
	}
	
	public static int dijkstra() {
		
		boolean[] visited = new boolean[N+1];
		
		int[] dist = new int[N+1];
		for(int i=0; i<=N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[startPoint] = 0;
//		int nowCity = startPoint;
		
		while(true) {
			int findSmall = Integer.MAX_VALUE;
			int nowCity = startPoint;
			
			//방문하지 않은 것 중 최소값 찾기
			for(int i=1; i<=N; i++) {
				if(visited[i]) continue;
				if(dist[i]<findSmall) {
					findSmall = dist[i];
					nowCity = i;
				}
			}
			
			if(nowCity==endPoint) return dist[nowCity];
			
			//방문 처리
			visited[nowCity] = true;
			
			//갱신할 수 있는 값 갱신
			for(Node node : city[nowCity]) {
				int sum = dist[nowCity] + node.price; //현재 위치를 거쳐 연결된 곳을 가는 것에 대한 비용
				if(sum<dist[node.c]) dist[node.c] = sum; //현재 위치를 거쳐서 가는 것이 더 작으면 갱신
			}
			
			
		}
		
	}
}