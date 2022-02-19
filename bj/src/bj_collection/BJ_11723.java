package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11723 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int M;
	static int[] set = new int[21];
	
	public static void main(String[] args) throws IOException{
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("add")) {
				int e = Integer.parseInt(st.nextToken());
				set[e]=1;
			}else if(cmd.equals("check")) {
				int e = Integer.parseInt(st.nextToken());
				if(set[e]==1) bw.write(1+"\n");
				else bw.write(0+"\n");
			}else if(cmd.equals("remove")) {
				int e = Integer.parseInt(st.nextToken());
				set[e] = 0;
			}else if(cmd.equals("toggle")) {
				int e = Integer.parseInt(st.nextToken());
				if(set[e]==1) set[e]=0;
				else set[e]=1;
			}else if(cmd.equals("all")) {
				Arrays.fill(set, 1);
			}else if(cmd.equals("empty")) {
				Arrays.fill(set, 0);
			}
		}
		bw.flush();
		bw.close();
	}
}
