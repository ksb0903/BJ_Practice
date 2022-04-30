package bj_collection.S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_11650 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N;
	static int[][] dots;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		dots = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			dots[i][0] = Integer.parseInt(st.nextToken());
			dots[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(dots, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return o1[1]-o2[1];
				}else return o1[0]-o2[0];
			}
		});
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++) {
				bw.write(dots[i][j] + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
}
