package bj_collection.B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_13420 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static final String CORRECT = "correct\n";
	static final String WRONG = "wrong answer\n";
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			char oper = st.nextToken().charAt(0);
			long b = Long.parseLong(st.nextToken());
			st.nextToken();
			long c = Long.parseLong(st.nextToken());
			
			switch(oper) {
			case '+':
				if(a+b==c) bw.write(CORRECT);
				else bw.write(WRONG);
				break;
			case '-':
				
				if(a-b==c) bw.write(CORRECT);
				else bw.write(WRONG);
				break;
			case '*':
				if(a*b==c) bw.write(CORRECT);
				else bw.write(WRONG);
				break;
			case '/':
				if(a/b==c) bw.write(CORRECT);
				else bw.write(WRONG);
				break;
			}
		}
		bw.flush();
		bw.close();
	}
}
