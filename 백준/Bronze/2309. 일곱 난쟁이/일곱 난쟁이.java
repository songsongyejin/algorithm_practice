import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] nArr = new int[9];
		int sum = 0;
		for(int i=0; i<9; i++) {
			nArr[i] = Integer.parseInt(br.readLine());
			sum += nArr[i];
		}
		
		//정렬
		Arrays.sort(nArr);
		
		//앞에서부터 두명씩 빼고 계산
		a: for(int i=0; i<9; i++) {
			sum-=nArr[i];
			for(int j=i+1; j<9; j++) {
				sum-=nArr[j];
				if(sum<100) {
					//뒤에 j를 진행할 필요 없음
					//원복 후 i를 증가
					sum+=nArr[j]+nArr[i];
					continue a;
				}
				if(sum==100) {
					for(int k=0; k<9; k++) {
						if(k!=i&&k!=j) {
							sb.append(nArr[k]).append("\n");
						}
					}
					System.out.println(sb);
					break a;
				}
				//원복
				sum+=nArr[j];
			}
			sum+=nArr[i];
		}
		
	}
}