package bj_collection.S1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_4929 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int len1, len2, arr1[], arr2[];
	
	public static void main(String[] args) throws IOException{
		while(true) {
			st = new StringTokenizer(br.readLine());
			len1 = Integer.parseInt(st.nextToken());
			
			if(len1==0) break;
			
			arr1 = new int[len1];
			for(int i=0; i<len1; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			len2 = Integer.parseInt(st.nextToken());
			
			arr2 = new int[len2];
			for(int i=0; i<len2; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			
			bw.write(solve() + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int solve() {
		int ans = 0;
		int idx1 = 0;
		int idx2 = 0;
		int sum1 = 0;
		int sum2 = 0;
		
		while(idx1<len1 || idx2<len2) {
			if(idx1==len1) {
				sum2 += arr2[idx2++];
			}else if(idx2==len2) {
				sum1 += arr1[idx1++];
			}else {
				if(arr1[idx1] > arr2[idx2]) {
					sum2 += arr2[idx2++];
				}else if(arr1[idx1] < arr2[idx2]) {
					sum1 += arr1[idx1++];
				}else {
					ans += Math.max(sum1, sum2);
					ans += arr1[idx1];
					sum1 = 0;
					sum2 = 0;
					idx1++;
					idx2++;
				}
			}
		}
		
		ans += Math.max(sum1, sum2);
		return ans;
	}
}
