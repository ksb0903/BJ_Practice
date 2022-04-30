package bj_collection.S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_2609 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int A, B;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		bw.write(getGCD(A, B) + "\n");
		bw.write(getLCM(A, B) + "\n");
		bw.flush();
		bw.close();
	}
	
	public static int getGCD(int a, int b) {
		while(b!=0) {
			int tmp=b;
			b=a%b;
			a=tmp;
		}
		
		return a;
	}
	
	public static int getLCM(int a, int b) {
		return a*b/getGCD(a, b);
	}
}
