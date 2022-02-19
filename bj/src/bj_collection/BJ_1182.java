package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1182 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, S, count, selectCnt;
	static int[] nums;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];
		isSelected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		subSet(0, 0);
		System.out.println(count);
	}
	
	public static void subSet(int cnt, int sum) {
		if(cnt==N) {
			if(sum==S && selectCnt!=0) {
				count++;
			}
			return;
		}
		
		isSelected[cnt] = true;
		selectCnt++;
		subSet(cnt+1, sum+nums[cnt]);
		isSelected[cnt] = false;
		selectCnt--;
		subSet(cnt+1, sum);
	}
}
