package bj_collection.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14426 {
	
	static int N, M;
	static String S[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = new String[N];
		for(int i=0; i<N; i++) {
			S[i] = br.readLine();
		}
		
		int cnt = 0;
		
		for(int i=0; i<M; i++) {
			String c = br.readLine();
			
			for(int j=0; j<N; j++) {
				if(check(c, S[j])) {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	public static boolean check(String c, String s) {
		
		for(int i=0; i<c.length(); i++) {
			if(c.charAt(i)!=s.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
}
