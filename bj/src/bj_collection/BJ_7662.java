package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_7662 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static TreeMap<Integer, Integer> treemap;
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int K = Integer.parseInt(br.readLine());
			treemap = new TreeMap<>();
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				
				if(cmd=='I') {
					treemap.put(num, treemap.getOrDefault(num, 0)+1);
				}else { // D
					if(treemap.isEmpty()) continue;
					
					if(num==1) {
						int max = treemap.lastKey();
						if(treemap.get(max)==1) {
							treemap.remove(max);
						}else {
							treemap.put(max, treemap.get(max)-1);
						}
					}else { // -1
						int min = treemap.firstKey();
						if(treemap.get(min)==1) {
							treemap.remove(min);
						}else {
							treemap.put(min, treemap.get(min)-1);
						}
					}
				}
			}
			
			if(treemap.isEmpty()) {
				bw.write("EMPTY\n");
			}else {
				bw.write(treemap.lastKey() + " " + treemap.firstKey() + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
