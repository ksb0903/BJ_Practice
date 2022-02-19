package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_15649 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M, number[], arr[];
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		for(int i=1; i<=N; i++) {
			arr[i-1] = i;
		}
		number = new int[M];
		isSelected = new boolean[N];
		
		permutation(0);
		bw.flush();
		bw.close();
	}
	
	public static void permutation(int cnt) throws IOException{
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				bw.write(number[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
		
			number[cnt] = arr[i];
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}

