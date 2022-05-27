package bj_collection.S5;

import java.util.Scanner;

public class BJ_21966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		char[] S = sc.next().toCharArray();
		
		if(N<=25) {
			for(int i=0; i<N; i++) {
				System.out.print(S[i]);
			}
		}else {
			boolean flag = false;
			
			for(int i=11; i<N-12; i++) {
				if(S[i]=='.') {
					flag = true;
					break;
				}
			}
			
			if(flag) {
				for(int i=0; i<9; i++) {
					System.out.print(S[i]);
				}
				for(int i=0; i<6; i++) {
					System.out.print(".");
				}
				for(int i=N-10; i<N; i++) {
					System.out.print(S[i]);
				}
			}else {
				for(int i=0; i<11; i++) {
					System.out.print(S[i]);
				}
				for(int i=0; i<3; i++) {
					System.out.print(".");
				}
				for(int i=N-11; i<N; i++) {
					System.out.print(S[i]);
				}
			}
		}
		
		sc.close();
	}
}
