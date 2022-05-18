package bj_collection.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2138 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, now[], target[], min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		now = new int[N];
		target = new int[N];
		
		String s = br.readLine();
		for(int i=0; i<N; i++) {
			now[i] = (int)s.charAt(i)-'0';
		}
		
		s = br.readLine();
		for(int i=0; i<N; i++) {
			target[i] = (int)s.charAt(i)-'0';
		}
		
		nopress();
		press();
		
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
	
	public static void nopress() {
		// 첫 번째 버튼을 누르지 않는 경우
		int[] copy = now.clone();
		int cnt = 0;
		
		for(int i=0; i<N-1; i++) {
			if(copy[i]!=target[i]) {
				pressBtn(i+1, copy);
				cnt++;
			}
		}
		
		for(int i=0; i<N; i++) {
			if(copy[i]!=target[i]) {
				return;
			}
		}
		
		min = Math.min(min, cnt);
	}
	
	public static void press() {
		// 첫 번째 버튼을 누르는 경우
		int[] copy = now.clone();
		pressBtn(0, copy);
		int cnt = 1;
		
		for(int i=0; i<N-1; i++) {
			if(copy[i]!=target[i]) {
				pressBtn(i+1, copy);
				cnt++;
			}
		}
		
		for(int i=0; i<N; i++) {
			if(copy[i]!=target[i]) {
				return;
			}
		}
		
		min = Math.min(min, cnt);
	}
	
	public static void pressBtn(int idx, int[] arr) {
		if(idx==0) {
			arr[idx] = (arr[idx]+1)%2;
			arr[idx+1] = (arr[idx+1]+1)%2;
		}else if(idx==N-1) {
			arr[idx-1] = (arr[idx-1]+1)%2;
			arr[idx] = (arr[idx]+1)%2;
		}else {
			arr[idx-1] = (arr[idx-1]+1)%2;
			arr[idx] = (arr[idx]+1)%2;
			arr[idx+1] = (arr[idx+1]+1)%2;
		}
	}
}
