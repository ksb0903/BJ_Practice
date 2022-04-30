package bj_collection.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, A[], op[], max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		op = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(1, A[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void solve(int idx, int num) {
		if(idx==N) {
			max = Math.max(max, num);
			min	= Math.min(min, num);
			return;
		}
		int new_num = 0;
		
		for(int i=0; i<4; i++) {
			if(op[i]==0) continue;
			
			switch(i) {
			case 0: 
				new_num = num + A[idx];
				op[i]--;
				solve(idx+1, new_num);
				op[i]++;
				break;
			case 1:
				new_num = num - A[idx];
				op[i]--;
				solve(idx+1, new_num);
				op[i]++;
				break;
			case 2:
				new_num = num * A[idx];
				op[i]--;
				solve(idx+1, new_num);
				op[i]++;
				break;
			case 3:
				if(num>=0) {
					new_num = num / A[idx];
				}else {
					new_num = ((num*-1)/A[idx])*-1;
				}
				op[i]--;
				solve(idx+1, new_num);
				op[i]++;
				break;
			}
		}
	}
}
