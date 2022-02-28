package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_1764 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M;
	static HashSet<String> set = new HashSet<>();
	static ArrayList<String> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		
		for(int i=0; i<M; i++) {
			String s = br.readLine();
			if(set.contains(s)) list.add(s);
		}
		
		Collections.sort(list);
		int size = list.size();
		bw.write(size+"\n");
		for(int i=0; i<size; i++) {
			bw.write(list.get(i)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
