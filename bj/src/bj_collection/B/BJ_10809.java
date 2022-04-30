package bj_collection.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10809 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
			
	public static void main(String[] args) throws IOException{
		String s = br.readLine();
		int[] alpha = new int[26];
		Arrays.fill(alpha, -1);
		for(int i=0; i<s.length(); i++) {
			int idx = s.charAt(i)-'a';
			if(alpha[idx]==-1)
				alpha[idx] = i;
		}
		
		for(int i: alpha) {
			sb.append(i + " ");
		}
		System.out.println(sb.toString());
	}
}
