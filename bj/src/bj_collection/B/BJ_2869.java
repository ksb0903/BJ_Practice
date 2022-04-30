package bj_collection.B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_2869 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int A, B, V;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		double day = (V-B)/(A-B);
		
		if((V-B)%(A-B)!=0) day=(int)(day+1);
		
		bw.write((int)day+"");
		bw.flush();
		bw.close();
	}
}
