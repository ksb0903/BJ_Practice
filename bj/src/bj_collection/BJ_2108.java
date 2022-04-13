package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2108 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[8001];
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
	
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			sum += input;
			max = Math.max(max, input);
			min = Math.min(min, input);
			arr[input+4000]++;
		}
		
		int median = 0;
		ArrayList<Integer> modeList = new ArrayList<>();
		int mode_cnt = 0;
		int idx = 0;

		for(int i=min+4000; i<=max+4000; i++) {
			if(arr[i]>0) {
				if(idx<(N+1)/2) {
					idx += arr[i];
					median = i-4000;
				}
				
				if(mode_cnt<arr[i]) {
					modeList = new ArrayList<>();
					mode_cnt = arr[i];
					modeList.add(i-4000);
				}else if(mode_cnt==arr[i]) {
					modeList.add(i-4000);
				}
			}
		}
		
		System.out.println((int)Math.round((double)sum/N));
		System.out.println(median);
		if(modeList.size()==1) {
			System.out.println(modeList.get(0));
		}else {
			System.out.println(modeList.get(1));
		}
		System.out.println(max-min);
	}
}
