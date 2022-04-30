package bj_collection.S3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_1929 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int M, N;
	static boolean[] arr;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new boolean[N+1];
		arr[1] = true;
		
		for(int i=2; i<N+1; i++) {
			if(arr[i]==false) {
				if(i*i>1000000) break;
				for(int j=i*i; j<N+1; j=j+i) {
					arr[j]=true;
				}
			}
		}
		
		for(int i=M; i<=N; i++) {
			if(!arr[i]) bw.write(i+"\n");
		}
		bw.flush();
		bw.close();
	}
	
}
