package bj_collection.G1;

import java.util.Scanner;

public class BJ_1019 {
	
	static int start, end, digit, nums[];
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		start = 1;
		end = sc.nextInt();
		nums = new int[10];
		digit = 1;
		
		while(true) {
			while(start%10!=0 && start<=end) {
				count(start);
				start++;
			}
			
			while(end%10!=9 && start<=end) {
				count(end);
				end--;
			}
			
			if(start>end) break;
			
			start /= 10;
			end /= 10;
			
			for(int i=0; i<10; i++) {
				nums[i] += (end-start+1) * digit;
			}
			
			digit *= 10;
		}
		
		for(int i: nums) {
			System.out.print(i + " ");
		}
	}
	
	public static void count(int num) {
		while(num>0) {
			nums[num%10] += digit;
			num /= 10;
		}
	}
}
