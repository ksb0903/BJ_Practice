package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2239 {
	static boolean endFlag = false;
	static int[][] arr = new int[10][10];
	static boolean[] nums = new boolean[10];
	static ArrayList<int[]> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<=9; i++) {
			String s = br.readLine();
			for(int j=1; j<=9; j++) {
				arr[i][j] = (int)(s.charAt(j-1)-'0');
				if(arr[i][j]==0) list.add(new int[] {i, j});
			}
		}
		
		dfs(0);
	}
	
	public static void dfs(int idx) {
		if(idx==list.size()) {
			StringBuilder sb = new StringBuilder();
			for(int i=1; i<=9; i++) {
				for(int j=1; j<=9; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
			endFlag = true;
			return;
		}
		
		int[] point = list.get(idx);
		int x = point[0];
		int y = point[1];
		
		for(int k=1; k<=9; k++) {
			if(endFlag) return;
			
			arr[x][y] = k;
			if(checkCol(x, y, k) && checkRow(x, y, k) && checkBox(x, y, k)) {
				dfs(idx+1);
			}
		}
		
		arr[x][y] = 0;
	}
	
	public static boolean checkCol(int row, int col, int value) {
		for(int c=1; c<=9; c++) {
			if(c==col) continue;
			
			if(arr[row][c]==value) return false;
		}
		
		return true;
	}
	
	public static boolean checkRow(int row, int col, int value) {
		for(int r=1; r<=9; r++) {
			if(r==row) continue;
			
			if(arr[r][col]==value) return false;
		}
		
		return true;
	}
	
	public static boolean checkBox(int row, int col, int value) {
		int startR = (row-1)/3*3+1;
		int startC = (col-1)/3*3+1;
		
		for(int r=startR; r<startR+3; r++) {
			for(int c=startC; c<startC+3; c++) {
				if(r==row && c==col) continue;
				
				if(arr[r][c]==value) return false;
			}
		}
		
		return true;
	}
}
