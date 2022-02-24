package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_15686 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, min = Integer.MAX_VALUE;
	static int[] select;
	static int[][] dist;
	static ArrayList<int[]> house = new ArrayList<>(); // 집 목록
	static ArrayList<int[]> chicken = new ArrayList<>(); // 치킨집 목록
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				char c = st.nextToken().charAt(0);
				if(c=='1') {
					house.add(new int[] {i, j});
				}else if(c=='2') {
					chicken.add(new int[] {i, j});
				}
			}
		}
		select = new int[M];
		dist = new int[chicken.size()][house.size()];
		getDist();
		comb(0, 0);
		System.out.println(min);
	}
	
	public static void getDist() {
		// 각 치킨집에서 각 집까지의 거리를 저장
		for(int i=0; i<chicken.size(); i++) {
			for(int j=0; j<house.size(); j++) {
				dist[i][j] = Math.abs(chicken.get(i)[0]-house.get(j)[0]) + Math.abs(chicken.get(i)[1]-house.get(j)[1]);
			}
		}
	}
	
	public static void comb(int cnt, int start) {
		if(cnt==M) {
			// M개의 치킨집 조합을 구성하여 거리 계산
			int sum=0;
			
			for(int i=0; i<house.size(); i++) {
				int nearest=Integer.MAX_VALUE;
				for(int j=0; j<M; j++) {
					nearest = Math.min(nearest, dist[select[j]][i]);
				}
				sum+=nearest;
			}
			
			min = Math.min(min, sum);
			return;
		}
		
		for(int i=start, size=chicken.size(); i<size; i++) {
			select[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
}
