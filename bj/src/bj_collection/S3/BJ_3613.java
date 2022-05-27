package bj_collection.S3;

import java.util.Scanner;

public class BJ_3613 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		StringBuilder sb = new StringBuilder();
		
		boolean isC = false;
		boolean isJ = false;
		boolean flag = false;
		
		if(s.charAt(0)=='_' || (s.charAt(0)>=65 && s.charAt(0)<=90)) {
			sb.append("Error!");
		}else if(s.charAt(s.length()-1)=='_'){
			sb.append("Error!");
		}else {
			for(int i=0; i<s.length(); i++) {
				if(flag) {
					flag = false;
					if(s.charAt(i)>=65 && s.charAt(i)<=90 || s.charAt(i)=='_') {
						isJ = true;
					}
					
					sb.append((char)(s.charAt(i)-32));
					
					continue;
				}
				
				if(s.charAt(i)=='_') {
					isC = true;
					flag = true;
				}else if(s.charAt(i)>=65 && s.charAt(i)<=90) {
					isJ = true;
					sb.append("_" + (char)(s.charAt(i)+32));
				}else {
					sb.append(s.charAt(i));
				}
			}
		}
		
		if(isC && isJ) {
			sb.setLength(0);
			sb.append("Error!");
		}
		
		sc.close();
		System.out.println(sb.toString());
	}
}
