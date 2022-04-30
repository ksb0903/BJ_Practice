package bj_collection.S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_1620 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M;
	static HashMap<String, String> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i<=N; i++) {
			String s = br.readLine();
			map.put(s, String.valueOf(i));
			map.put(String.valueOf(i), s);
		}
		
		for(int i=0; i<M; i++) {
			bw.write(map.get(br.readLine())+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}
