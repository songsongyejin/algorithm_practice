import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int paper = Integer.parseInt(br.readLine());
		int[][] whitePaper = new int[100][100];
		int area = 0;
		for (int p = 0; p < paper; p++) {
			st = new StringTokenizer(br.readLine());
			int cStart = Integer.parseInt(st.nextToken());
			int rStart = 100-10-Integer.parseInt(st.nextToken());
			for (int r = 0; r < 10; r++) {
				for (int c = 0; c < 10; c++) {
					if(whitePaper[rStart+r][cStart+c]!=1) {
						whitePaper[rStart+r][cStart+c]=1;
						area++;
					}
				}
			}
		}
		System.out.println(area);

	}
}