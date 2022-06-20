package bj_collection.S1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_11286 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1)==Math.abs(o2)) {
					return o1 - o2;
				}
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x==0) {
				if(pq.size()==0) {
					bw.write("0\n");
				}else {
					bw.write(pq.poll() + "\n");
				}
			}else {
				pq.add(x);
			}
		}
		
		bw.flush();
		bw.close();
	}
}
