package bj_collection.S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_10845 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int N, back;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(s.equals("push")) {
				back = Integer.parseInt(st.nextToken());
				queue.offer(back);
			}else if(s.equals("pop")) {
				if(queue.isEmpty()) bw.write(-1+"\n");
				else bw.write(queue.poll()+"\n");
			}else if(s.equals("empty")) {
				if(queue.isEmpty()) bw.write(1+"\n");
				else bw.write(0+"\n");
			}else if(s.equals("size")) {
				if(queue.isEmpty()) bw.write(0+"\n");
				else bw.write(queue.size()+"\n");
			}else if(s.equals("front")) {
				if(queue.isEmpty()) bw.write(-1+"\n");
				else bw.write(queue.peek()+"\n");
			}else if(s.equals("back")) {
				if(queue.isEmpty()) bw.write(-1+"\n");
				else bw.write(back+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
