package bj_collection.S4;

import java.io.IOException;
import java.util.Scanner;

public class BJ_13699 {
	static int N;
	static long t[];
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		if(N==0) {
			System.out.println(1);
			return;
		}
		
		t = new long[N+1];
		t[0] = 1;
		t[1] = 1;
		
		for(int i=2; i<=N; i++) {
			for(int j=0; j<i; j++) {
				t[i] += t[j] * t[i-1-j];
			}
		}
		
		System.out.println(t[N]);
		sc.close();
	}
}
