package bj_collection;

import java.util.Scanner;

public class BJ_11444 {
	static long[][] adj = {{1,1},{1,0}};
	static long[][] start = {{1},{0}};
	static final int MOD = 1000000007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		
		if(n==1) {
			System.out.println(1);
		}else {
			System.out.println(multi(power(adj, n-1), start)[0][0]);
		}
	}
	
	public static long[][] multi(long[][] a, long[][]b){
		long[][] tmp = new long[2][b[0].length];
		for(int i=0; i<2; i++) {
			for(int j=0; j<b[0].length; j++) {
				long sum = 0;
				for(int k=0; k<2; k++) {
					sum += a[i][k] * b[k][j];
				}
				tmp[i][j] = sum % MOD;
			}
		}
		return tmp;
	}
	
	public static long[][] power(long[][] arr, long n){
		if(n==1) return arr;
		else if(n%2==0) {
			return power(multi(arr, arr), n/2);
		}else {
			return multi(power(arr, n-1), arr);
		}
	}
}
