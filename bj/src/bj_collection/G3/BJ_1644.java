package bj_collection.G3;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_1644 {
	static boolean prime[];
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N==1) {
			System.out.println(0);
			return;
		}
		prime = new boolean[N+1];
		getPrime(N);
		
		System.out.println(solve(N));
		sc.close();
	}
	
	public static int solve(int n) {
		int cnt = 0;
		int to = 0;
		int size = list.size();
		int sum = 0;
		
		for(int from=0; from<size; from++) {
			while(to<size && sum<n) {
				sum += list.get(to++);
			}
			if(sum==n) cnt++;
			sum -= list.get(from);
		}
		
		return cnt;
	}
	
	public static void getPrime(int n) {
		prime[0] = prime[1] = true;
		
		for(int i=2; i*i<=n; i++) {
			if(prime[i]) continue;
			
			for(int j=i*i; j<=n; j+=i) prime[j] = true;
		}
		
		for(int i=2; i<=n; i++) {
			if(!prime[i]) list.add(i);
		}
	}
}
