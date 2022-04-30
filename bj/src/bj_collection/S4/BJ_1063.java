package bj_collection.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1063 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[] king, stone;
	static int N;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		king = st.nextToken().toCharArray();
		stone = st.nextToken().toCharArray();
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			String cmd = br.readLine();
			
			move(king, cmd);
			if(king[0]==stone[0] && king[1]==stone[1]) {
				move(stone, cmd);
			}
			if(king[0]==stone[0] && king[1]==stone[1]) {
				move(king, reverseCmd(cmd));
			}
		}
		System.out.println(String.valueOf(king));
		System.out.println(String.valueOf(stone));
	}
	
	public static String reverseCmd(String cmd) {
		if(cmd.equals("R")) return "L";
		else if(cmd.equals("L")) return "R";
		else if(cmd.equals("T")) return "B";
		else if(cmd.equals("B")) return "T";
		else if(cmd.equals("RT")) return "LB";
		else if(cmd.equals("LT")) return "RB";
		else if(cmd.equals("RB")) return "LT";
		else if(cmd.equals("LB")) return "RT";
		return "";
	}
	
	public static void move(char[] obj, String cmd) {
		if(cmd.equals("R")) {
			if(obj[0]!='H') {
				obj[0] = (char)(obj[0]+1);
			}
		}else if(cmd.equals("L")) {
			if(obj[0]!='A') {
				obj[0] = (char)(obj[0]-1);
			}
		}else if(cmd.equals("B")) {
			if(obj[1]!='1') {
				obj[1] = (char)(obj[1]-1);
			}
		}else if(cmd.equals("T")) {
			if(obj[1]!='8') {
				obj[1] = (char)(obj[1]+1);
			}
		}else if(cmd.equals("RT")) {
			if(obj[0]!='H' && obj[1]!='8') {
				obj[0] = (char)(obj[0]+1);
				obj[1] = (char)(obj[1]+1);
			}
		}else if(cmd.equals("LT")) {
			if(obj[0]!='A' && obj[1]!='8') {
				obj[0] = (char)(obj[0]-1);
				obj[1] = (char)(obj[1]+1);
			}
		}else if(cmd.equals("RB")) {
			if(obj[0]!='H' && obj[1]!='1') {
				obj[0] = (char)(obj[0]+1);
				obj[1] = (char)(obj[1]-1);
			}
		}else if(cmd.equals("LB")) {
			if(obj[0]!='A' && obj[1]!='1') {
				obj[0] = (char)(obj[0]-1);
				obj[1] = (char)(obj[1]-1);
			}
		}
	}
}
