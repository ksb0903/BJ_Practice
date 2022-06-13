package bj_collection.S1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_6064 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int M, N, x, y, res;
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			res = -1;
			int lcm = N * M / gcd(N, M);
			
			int tmp = x;
			for(int i=x; i<=lcm; i=i+M) {
				if(tmp%N == y%N) {
					res = i;
					break;
				}
				tmp = (tmp + M)%N;
			}
			
			bw.write(res+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int gcd(int a, int b) {
		while(b!=0) {
			int r = a%b;
			a = b;
			b = r;
		}
		
		return a;
	}
}
