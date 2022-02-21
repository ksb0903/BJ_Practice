package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2784 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static String[] words = new String[6];
	static boolean[] isSelected = new boolean[6];
	static char[][] puzzle = new char[3][3];
	static boolean flag;
			
	public static void main(String[] args) throws IOException{
		for(int i=0; i<6; i++) {
			words[i] = br.readLine();
		}
		
		perm(0);
		if(!flag) bw.write("0");
		bw.flush();
		bw.close();
	}
	
	public static void perm(int cnt) throws IOException {
		if(cnt==3) {
			String[] notSelected = new String[3];
			int idx=0;
			for(int i=0; i<6; i++) {
				if(!isSelected[i]) {
					notSelected[idx++] = words[i];
				}
			}
			
			String[] vertical = new String[3];
			for(int i=0; i<3; i++) {
				String s = "";
				for(int j=0; j<3; j++) {
					s = s.concat(String.valueOf(puzzle[j][i]));
				}
				vertical[i] = s;
			}
			Arrays.sort(vertical);
			
			for(int i=0; i<3; i++) {
				if(!vertical[i].equals(notSelected[i])) {
					return;
				}
			}
			
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					bw.write(puzzle[i][j]);
				}
				bw.write("\n");
			}
			flag = true;
			return;
		}
		
		for(int i=0; i<6; i++) {
			if(flag) return;
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			puzzle[cnt] = words[i].toCharArray();
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
}
