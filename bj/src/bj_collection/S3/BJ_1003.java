package bj_collection.S3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_1003 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int T, N, count0, count1;
	static int[][] fibo;
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			N = Integer.parseInt(br.readLine());
			if(N==0) {
				bw.write(1 + " " + 0 + "\n");
			}else if(N==1) {
				bw.write(0 + " " + 1 + "\n");
			}else {
				fibo = new int[N+1][2];
				fibo[0][0] = 1;
				fibo[0][1] = 0;
				fibo[1][0] = 0;
				fibo[1][1] = 1;
				
				for(int i=2; i<=N; i++) {
					fibo[i][0] = fibo[i-2][0]+fibo[i-1][0];
					fibo[i][1] = fibo[i-2][1]+fibo[i-1][1];
				}
				
				bw.write(fibo[N][0] + " " + fibo[N][1] + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
