import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String str="";
		for(int t=1; t<=T; t++) {
			str=br.readLine();
			int total = 0;
			for(int s=0; s<str.length(); s++) {
				int cntO =0;
				while(s<str.length() && str.charAt(s)=='O') {
					total += ++cntO;
					s++;
				}
			}
			
			System.out.println(total);
		}
		
	}
}