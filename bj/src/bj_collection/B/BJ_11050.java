package bj_collection.B;

import java.util.Scanner;

public class BJ_11050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(getComb(n, k));
		sc.close();
	}
	
	public static int getComb(int n, int k) {
		if(k==0 || n==k) return 1;
		
		return getComb(n-1, k) + getComb(n-1, k-1);
	}
}
