package bj_collection.S2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_15666 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M;
	static int[] nums, res;
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		res = new int[M];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		perm(0, 0);
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			bw.write(it.next()+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void perm(int cnt, int pre) throws IOException{
		if(cnt==M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; i++) {
				sb.append(res[i] + " ");
			}
			set.add(sb.toString());
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(nums[i]<pre) continue;
			
			res[cnt] = nums[i];
			perm(cnt+1, nums[i]);
		}
	}
}
