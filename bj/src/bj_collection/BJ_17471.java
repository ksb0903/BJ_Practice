package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17471 {
	static int N, min, pop[];
	static LinkedList<LinkedList<Integer>> list = new LinkedList<>();
	static boolean[] selected;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		pop = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<=N; i++) {
			list.add(new LinkedList<>());
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<n; j++) {
				list.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		min = Integer.MAX_VALUE;
		for(int i=1; i<=N/2; i++) {
			selected = new boolean[N+1];
			perm(0, 1, i);
		}
		
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
	
	public static void perm(int cnt, int start, int selectCnt) {
		if(cnt==selectCnt) {
			LinkedList<Integer> s = new LinkedList<>();
			LinkedList<Integer> ns = new LinkedList<>();
			
			for(int i=1; i<=N; i++) {
				if(selected[i]) {
					s.add(i);
				}else {
					ns.add(i);
				}
			}
			if(bfs(s)&&bfs(ns)) {
				min = Math.min(min, getPop(s, ns));
			}
			return;
		}
		
		for(int i=start; i<=N; i++) {
			selected[i] = true;
			perm(cnt+1, i+1, selectCnt);
			selected[i] = false;
		}
	}
	
	public static int getPop(LinkedList<Integer> s, LinkedList<Integer> ns) {
		int pop1 = 0;
		int pop2 = 0;
		
		for(int i=0; i<s.size(); i++) {
			pop1 += pop[s.get(i)];
		}
		for(int i=0; i<ns.size(); i++) {
			pop2 += pop[ns.get(i)];
		}
		
		return Math.abs(pop1-pop2);
	}
	
	public static boolean bfs(LinkedList<Integer> s) {
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[N+1];
		q.offer(s.get(0));
		visited[s.get(0)] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(int x: list.get(poll)) {
				if(!visited[x] && s.contains(x)) {
					q.offer(x);
					visited[x] = true;
					cnt++;
				}
			}
		}
		if(cnt!=s.size()) return false;
		
		return true;
	}
}
