package bj_collection.S2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_6603 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int K, S[], selected[];
	
	public static void main(String[] args) throws IOException{
		while(true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			
			if(K==0) break;
			
			S = new int[K];
			selected = new int[6];
			for(int i=0; i<K; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0, 0);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void comb(int cnt, int prev) throws IOException{
		if(cnt==6) {
			for(int x: selected) {
				bw.write(x + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=prev; i<K; i++) {
			selected[cnt] = S[i];
			comb(cnt+1, i+1);
		}
	}
}
