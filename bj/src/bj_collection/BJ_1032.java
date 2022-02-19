package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1032 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		char[][] S = new char[N][];
		for(int i=0; i<N; i++) {
			S[i] = br.readLine().toCharArray(); 
		}
		
		if(N!=1) {
			for(int i=0; i<S[0].length; i++) {
				for(int j=1; j<N; j++) {
					if(S[j][i]!=S[0][i]) {
						S[0][i]='?';
						break;
					}
				}
			}
		}
		
		for(char c:S[0]) {
			System.out.print(c);
		}
	}
}
