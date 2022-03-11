package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5525 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		String P = getP(N);
		
		int[] pi = getPI(P);
		System.out.println(getKMP(S, P, pi));
	}
	
	public static int getKMP(String s, String p, int[] pi) {
		int tLen = s.length();
		int pLen = p.length();
		int j = 0, cnt = 0;
		
		for(int i=0; i<tLen; i++) {
			while(j>0 && s.charAt(i)!=p.charAt(j)) j = pi[j-1];
			if(s.charAt(i)==p.charAt(j)) {
				if(j==pLen-1) {
					cnt++;
					j = pi[j];
				}else {
					j++;
				}
			}
		}
		
		return cnt;
	}
	
	public static int[] getPI(String p) {
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
	
	public static String getP(int n) {
		StringBuilder sb = new StringBuilder("I");
		for(int i=0; i<n; i++) {
			sb.append("OI");
		}
		
		return sb.toString();
	}
}