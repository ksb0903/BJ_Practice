package bj_collection.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16235 {
	
	static class Tree{
		int x, y, age;

		public Tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}
	
	static int N, M, K, A[][], nutrient[][];
	static List<Tree> trees = new LinkedList<>();
	static Queue<Tree> dead = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N+1][N+1];
		nutrient = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				nutrient[i][j] = 5;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			trees.add(new Tree(x, y, z));
		}
		
		for(int i=0; i<K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		
		System.out.println(trees.size());
	}
	
	public static void spring() {
		Iterator<Tree> iter = trees.iterator();
		
		while(iter.hasNext()) {
			Tree t = iter.next();
			if(nutrient[t.x][t.y] >= t.age) {
				nutrient[t.x][t.y] -= t.age;
				t.age++;
			}else {
				dead.offer(t);
				iter.remove();
			}
		}
	}
	
	public static void summer() {
		while(!dead.isEmpty()) {
			Tree t = dead.poll();
			nutrient[t.x][t.y] += t.age/2;
		}
	}
	
	public static void fall() {
		int[][] deltas = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
		
		List<Tree> baby = new LinkedList<>();
		
		for(Tree t: trees) {
			if(t.age%5==0) {
				
				for(int d=0; d<8; d++) {
					int nx = t.x + deltas[d][0];
					int ny = t.y + deltas[d][1];
					
					if(nx>=1 && ny>=1 && nx<=N && ny<=N) {
						baby.add(new Tree(nx, ny, 1));
					}
				}
			}
		}
		
		trees.addAll(0, baby);
	}
	
	public static void winter() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				nutrient[i][j] += A[i][j];
			}
		}
	}
}
