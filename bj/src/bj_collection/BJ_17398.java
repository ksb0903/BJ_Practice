package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17398 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, Q;
	static long res;
	static int[] p, mList[], qList, size;
	static boolean[] uList;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		p = new int[N+1];
		mList = new int[M+1][2];
		qList = new int[Q+1];
		uList = new boolean[M+1];
		size = new int[N+1];
		Arrays.fill(size, 1);
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			mList[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		
		for(int i=1; i<=Q; i++) {
			int tmp = Integer.parseInt(br.readLine());
			qList[Q-i+1] = tmp;
			uList[tmp] = true;
		}
		
		makeSet();
		
		for(int i=1; i<=M; i++) {
			if(!uList[i]) {
				int a = mList[i][0];
				int b = mList[i][1];
				unionSet(a, b);
			}
		}
		
		for(int i=1; i<=Q; i++) {
			res += getCost(qList[i]);
		}
		System.out.println(res);
	}
	
	public static int getCost(int idx) {
		int a = mList[idx][0];
		int b = mList[idx][1];
		
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==bRoot) return 0;
		
		int cost = size[aRoot]*size[bRoot];
		unionSet(a, b);
		return cost;
	}
	
	public static void makeSet() {
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
	}
	
	public static int findSet(int x) {
		if(x==p[x]) return x;
		else return p[x] = findSet(p[x]);
	}
	
	public static void unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==bRoot) return;
		
		if(size[aRoot]<size[bRoot]) {
			int tmp = aRoot;
			aRoot = bRoot;
			bRoot = tmp;
		}
		
		p[bRoot] = aRoot;
		size[aRoot] += size[bRoot];
	}
}
