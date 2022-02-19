package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_11720 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int N;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		char[] nums = new char[N];
		int sum=0;
		
		nums = br.readLine().toCharArray();
		
		for(char c: nums) {
			sum+=(int)(c-'0');
		}
		
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}
