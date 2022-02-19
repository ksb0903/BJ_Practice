package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_10546 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static HashMap<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		for(int i=0; i<N-1; i++) {
			String s = br.readLine();
			map.put(s, map.get(s)-1);
		}
		
		for(String key: map.keySet()) {
			if(map.get(key)!=0) {
				System.out.println(key);
				break;
			}
		}
	}
}
