package bj_collection.S3;

import java.math.BigInteger;
import java.util.Scanner;

public class BJ_2407 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		BigInteger b1 = BigInteger.ONE;
		BigInteger b2 = BigInteger.ONE;
		
		for(int i=0; i<m; i++) {
			b1 = b1.multiply(new BigInteger(String.valueOf(n-i)));
			b2 = b2.multiply(new BigInteger(String.valueOf(i+1)));
		}
		
		BigInteger result = b1.divide(b2);
		System.out.println(result);
	}
}
