package bj_collection.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_7568 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int p[][] = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			p[i][0] = Integer.parseInt(st.nextToken());
			p[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			int rank = 1;
			for(int j=0; j<N; j++) {
				if(p[i][0]<p[j][0] && p[i][1]<p[j][1]) rank++;
			}
			
			System.out.print(rank+" ");
		}
	}
}
