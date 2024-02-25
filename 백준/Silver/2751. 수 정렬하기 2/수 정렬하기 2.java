import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] num = new int[N];

		for (int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(br.readLine());
		}

		// 힙 만들기
		for (int n = N / 2 - 1; n >= 0; n--) {
			heapify(num, N, n);
		}

		// 힙 정렬
		for (int n = 0; n < N - 1; n++) {
			int lastIdx = N - 1 - n;
			int tmp = num[lastIdx];
			num[lastIdx] = num[0];
			num[0] = tmp;
			heapify(num, lastIdx, 0);
		}

		// 출력
		StringBuilder sb = new StringBuilder();
		for (int n = 0; n < N; n++) {
			sb.append(num[n]).append("\n");
		}
		System.out.println(sb);

	}

	static void heapify(int[] num, int N, int n) {
		int p = n;
		int ch = p * 2 + 1;
		if (ch + 1 < N && num[ch] < num[ch + 1]) {
			ch++;
		}

		while (ch < N && num[p] < num[ch]) {
			int tmp = num[p];
			num[p] = num[ch];
			num[ch] = tmp;

			p = ch;
			ch = p * 2 + 1;
			if (ch + 1 < N && num[ch] < num[ch + 1]) {
				ch++;
			}
		}
	}

}