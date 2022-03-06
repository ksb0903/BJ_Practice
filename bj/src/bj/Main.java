package bj;

import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nums[] = new int[3];
		nums[0] = sc.nextInt();
		nums[1] = sc.nextInt();
		nums[2] = sc.nextInt();
		
		Arrays.sort(nums);
		int sameCnt = 1;
		int sameIdx = 0;
		for(int i=1; i<3; i++) {
			if(nums[i]==nums[i-1]) {
				sameCnt++;
				sameIdx = i;
			}
		}
		
		if(sameCnt==1) {
			System.out.println(nums[2]*100);
		}else if(sameCnt==2) {
			System.out.println(nums[sameIdx]*100+1000);
		}else {
			System.out.println(nums[0]*1000+10000);
		}
	}
}