import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int paper = Integer.parseInt(br.readLine());
		int[][] whitePaper = new int[101][101];
		int length = 0;
		for (int p = 0; p < paper; p++) {
			st = new StringTokenizer(br.readLine());
			int cStart = Integer.parseInt(st.nextToken());
			int rStart = 100 - 10 - Integer.parseInt(st.nextToken());
			for (int r = 0; r < 10; r++) {
				for (int c = 0; c < 10; c++) {
					if (whitePaper[rStart + r][cStart + c] != 1) {
						whitePaper[rStart + r][cStart + c] = 1;
					}
				}
			}
		}

		int currR = 0, currC =0;
		int lastR = 0, lastC =0;
		int rlen = 0;
		int clen = 0;
		for (int r = 0; r < 100; r++) {
			for (int c = 1; c < 100; c++) {
				lastR = whitePaper[r][c - 1];
				currR = whitePaper[r][c];
				if(c==1&&lastR==1) rlen++; //벽면에 붙어있을 경우
				lastC = whitePaper[c-1][r];
				currC = whitePaper[c][r];
				if(c==1&&lastC==1) clen++;
				if (lastR == 0 && currR != 0) {
					rlen++;
				}
				if (lastC == 0 && currC != 0) {
					clen++;
				}

			}
		}

		length = rlen * 2 + clen * 2;
		System.out.println(length);

	}
}