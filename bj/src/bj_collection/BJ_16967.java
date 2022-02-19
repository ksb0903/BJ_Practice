package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_16967 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int H, W, X, Y;
	static int[][] A, B;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		A = new int[H][W];
		B = new int[H+X][W+Y];
		
		for(int i=0; i<H+X; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W+Y; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=X; i<H+X; i++) {
			for(int j=Y; j<W+Y; j++) {
				A[i-X][j-Y] = B[i][j];
			}
		}
		
		for(int i=H-X-1; i>=0; i--) {
			for(int j=W-Y-1; j>=0; j--) {
				A[i][j] -= A[i+X][j+Y];
			}
		}
		
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				bw.write(A[i][j] + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
}
