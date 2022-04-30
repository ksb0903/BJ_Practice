package bj_collection.S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1059 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int L, N, left, right, count;
	static int[] set, nums, arr;
	
	public static void main(String[] args) throws IOException{
		L = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[2];
		set = new int[L];
		for(int i=0; i<L; i++) {
			set[i] = Integer.parseInt(st.nextToken());
		}
		N = Integer.parseInt(br.readLine());
		
		Arrays.sort(set);
		
		for(int i=0; i<L; i++) {
			if(set[i]==N) break;
			
			if(set[i]>N) {
				if(i==0) {
					left = 1;
					right = set[i]-1;
					break;
				}else {
					left = set[i-1]+1;
					right = set[i]-1;
					break;
				}
			}
		}
		nums = new int[right-left+1];
		for(int i=0; i<=right-left; i++) {
			nums[i] = left+i;
		}
		comb(0, 0);
		System.out.println(count);
	}
	
	public static void comb(int cnt, int start) {
		if(cnt==2) {
			if(arr[0]<=N && arr[1]>=N) {
				count++;
			}
			return;
		}
		
		for(int i=start; i<nums.length; i++) {
			arr[cnt] = nums[i];
			comb(cnt+1, i+1);
		}
	}
}
