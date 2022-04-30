package bj_collection.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17281 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, max, sequence[];
	static int[][] player;
	static boolean[] isSelected = new boolean[9];
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		sequence = new int[8];
		player = new int[9][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				player[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0);
		System.out.println(max);
	}
	
	public static void perm(int cnt) {
		if(cnt==8) {
			int[] order = new int[9];
			for(int i=0; i<9; i++) {
				if(i<3) order[i] = sequence[i];
				else if(i==3) order[3] = 0;
				else order[i] = sequence[i-1];
			}
			max = Math.max(max, getScore(order));
			
			return;
		}
		
		for(int i=1; i<9; i++) {
			// 2번 선수부터 9번 선수까지의 순서를 정함
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			sequence[cnt] = i;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
	
	public static int getScore(int[] order) {
		int inning = 0, score = 0, seq = 0;
		int[] run = {0, 1, 1, 2, 1, 2, 2, 3};
		while(inning<N) {
			int out = 0, base = 0;
			
			while(out<3) {
				switch(player[order[seq]][inning]) {
				case 0:
					out++;
					break;
				case 1:
					base = base<<1;
					base = base|1;
					break;
				case 2:
					base = base<<2;
					base = base|2;
					break;
				case 3:
					base = base<<3;
					base = base|4;
					break;
				case 4:
					score = score + run[base] + 1;
					base = 0;
					break;
				}
				
				if(base>7) {
					int b = base>>3;
					b = b & 7;
					score += run[b];
				}
				base = base&7;
				if(seq==8) seq=0;
				else seq++;
			}
			inning++;
		}
		
		return score;
	}
}
