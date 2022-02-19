package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_18870 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, cnt;
	static int[][] arr;
	static int[] tmp;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		tmp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = i;
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		arr[0][2] = 0;
		
		for(int i=1; i<N; i++) {
			if(arr[i][0]==arr[i-1][0])
				arr[i][2] = arr[i-1][2];
			else
				arr[i][2] = arr[i-1][2]+1;
			
			tmp[arr[i][1]]=arr[i][2];
		}
		
		for(int t: tmp) {
			bw.write(t + " ");
		}
		bw.flush();
		bw.close();
	}
}
