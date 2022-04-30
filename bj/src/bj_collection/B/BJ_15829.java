package bj_collection.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_15829 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int L;
	static char[] s;
	
	public static void main(String[] args) throws IOException{
		L = Integer.parseInt(br.readLine());
		s = br.readLine().toCharArray();
		long hash=0;
		int prime = 1234567891;
		long r=1;
		for(int i=0; i<L; i++) {
			hash += (((int)s[i]-96)*r)%prime;
			r = (r*31)%prime;
		}
		System.out.println(hash%prime);
	}
}
