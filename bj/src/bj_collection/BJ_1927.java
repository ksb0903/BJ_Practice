package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BJ_1927 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int N;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int cmd = Integer.parseInt(br.readLine());
			
			if(cmd==0) {
				if(pq.size()==0) {
					bw.write("0\n");
				}else {
					bw.write(pq.poll()+"\n");
				}
			}else {
				pq.offer(cmd);
			}
		}
		bw.flush();
		bw.close();
	}
}
