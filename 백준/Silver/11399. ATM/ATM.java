import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nArr = new int[N];
		int time = 0;
		
		for(int n=0; n<N; n++) {
			nArr[n] = Integer.parseInt(st.nextToken());
		}
		
		//정렬
		Arrays.sort(nArr);
		
		for(int n=0; n<N; n++) {
			time += nArr[n]*(N-n);
		}
		
		System.out.println(time);
		
	}
}