package bj_collection;

import java.util.Scanner;

public class BJ_2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int[][] apart = new int[k+1][n+1];
			
			for(int i=1; i<=n; i++) {
				apart[0][i] = i;
			}
			
			for(int i=1; i<=k; i++) {
				for(int j=1; j<=n; j++) {
					apart[i][j] = apart[i-1][j] + apart[i][j-1];
				}
			}
			
			System.out.println(apart[k][n]);
		}
	}
}
