package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_9489 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, K, kIdx;
	static int[] nums;
	static Node[] tree;
	
	static class Node{
		int idx, parent;
		
		public Node(int idx, int parent) {
			this.idx = idx;
			this.parent = parent;
		}
	}
	
	public static void main(String[] args) throws IOException{
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			if(N==0 && K==0) {
				bw.flush();
				bw.close();
				break;
			}
			
			st = new StringTokenizer(br.readLine());
			nums = new int[N+1];
			nums[0]=-1;
			tree = new Node[N+1];
			for(int i=1; i<=N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				if(nums[i]==K) kIdx=i;
			}
			tree[0] = new Node(-1, -1);
			makeTree(1, -1);
			bw.write(countCousin()+"\n");
		}
	}
	
	public static int countCousin() {
		int count=0;
		for(int i=1; i<=N; i++) {
			if(tree[i].parent != tree[kIdx].parent && tree[tree[i].parent].parent == tree[tree[kIdx].parent].parent) {
				count++;
			}
		}
		return count;
	}
	
	public static void makeTree(int idx, int parent) {
		if(idx>N) return;
		if(nums[idx]!=nums[idx-1]+1) parent++;
		
		tree[idx] = new Node(nums[idx], parent);
		makeTree(idx+1, parent);
	}
}
