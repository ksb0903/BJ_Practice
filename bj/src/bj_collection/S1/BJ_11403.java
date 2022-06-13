package bj_collection.S1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_11403 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N, matrix[][];
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		floyd();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				bw.write(matrix[i][j] + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void floyd() {
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(matrix[i][j]==0) {
						if(matrix[i][k]==1 && matrix[k][j]==1) {
							matrix[i][j] = 1;
						}
					}
				}
			}
		}
	}
}
