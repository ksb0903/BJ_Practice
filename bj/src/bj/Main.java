package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int answer;
			
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		int arr[] = new int[N+1];
		Arrays.fill(arr, Integer.MIN_VALUE);
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++) {
			int x = Integer.parseInt(st.nextToken());
			arr[x] = 0;
			queue.offer(x);
		}
		while(!queue.isEmpty()) {
			int x = queue.poll();
			for(int i=0; i<=(int)(Math.log(N)+1); i++) {
				int nx = x^(1<<i);
				if(nx>N||arr[nx]!=Integer.MIN_VALUE) continue;
				arr[nx] = arr[x]+1;
				queue.offer(nx);
				answer = Math.max(answer, arr[nx]);
			}
		}
		
		System.out.println(answer);
	}
}
