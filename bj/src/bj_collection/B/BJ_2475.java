package bj_collection.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2475 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		int res=0;
		for(int i=0; i<5; i++) {
			res += (int)Math.pow(Double.parseDouble(st.nextToken()), 2);
		}
		
		System.out.println(res%10);
	}
}
