package bj_collection.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16472 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		int alpha[] = new int[26];
		int start = 0;
		int end = 0;
		int cnt = 0;
		int max = Integer.MIN_VALUE;
		
		while(end<S.length()) {
			int x = (int)(S.charAt(end) - 'a');
			alpha[x]++;
			if(alpha[x]==1) cnt++;
			
			while(cnt>N) {
				int y = (int)(S.charAt(start) - 'a');
				alpha[y]--;
				
				if(alpha[y]==0) cnt--;
				
				start++;
			}
			
			max = Math.max(max, end-start+1);
			end++;
			
		}
		
		System.out.println(max);
	}
}
