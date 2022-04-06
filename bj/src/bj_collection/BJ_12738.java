package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_12738 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> list = new ArrayList<>();
		list.add(Integer.MIN_VALUE);
		
		int N = Integer.parseInt(br.readLine());
		int x = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			x = Integer.parseInt(st.nextToken());
			
			if(list.get(list.size()-1) < x) {
				list.add(x);
			}else {
				int left = 1;
				int right = list.size()-1;
				
				while(left<right) {
					int mid = (left+right)/2;
					if(list.get(mid) < x) {
						left = mid+1;
					}else {
						right = mid;
					}
				}
				list.set(right, x);
			}
		}
		
		bw.write(list.size()-1 + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
