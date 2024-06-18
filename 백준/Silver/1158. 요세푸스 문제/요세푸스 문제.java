import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//초기화
		List<Integer> list = new LinkedList<>();
		for(int n=0; n<N; n++) {
			list.add(n+1);
		}
		
		int idx = 0;
		
		while(N>1) {
			idx += K-1;
			if(idx>=N) {
				idx %= N;
			}
			sb.append(list.get(idx)).append(", ");
			list.remove(idx);
			N--;
		}
		sb.append(list.get(0)).append(">");
		System.out.println(sb);
		
	}
}