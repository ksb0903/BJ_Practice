package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16916 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String pattern = br.readLine();
		
		int[] pi = getPi(pattern);
		if(getKMP(text, pattern, pi)) System.out.println(1);
		else System.out.println(0);
	}
	
	public static boolean getKMP(String t, String p, int[] pi) {
		int tLen = t.length();
		int pLen = p.length();
		int j = 0;
		
		for(int i=0; i<tLen; i++) {
			while(j>0 && t.charAt(i)!=p.charAt(j)) j = pi[j-1];
			if(t.charAt(i)==p.charAt(j)) {
				if(j==pLen-1) {
					return true;
				}else {
					j++;
				}
			}
		}
		
		return false;
	}
	
	public static int[] getPi(String p) {
		int len = p.length();
		int[] pi = new int[len];
		int j = 0;
		
		for(int i=1; i<len; i++) {
			while(j>0 && p.charAt(i)!=p.charAt(j)) j = pi[j-1];
			if(p.charAt(i)==p.charAt(j)) {
				j++;
				pi[i] = j;
			}
		}
		return pi;
	}
}
