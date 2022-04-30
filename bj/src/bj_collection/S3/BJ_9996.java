package bj_collection.S3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

public class BJ_9996 {
	static int N;
	static String pattern[], files[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		pattern = br.readLine().split("\\*");
		files = new String[N];
		for(int i=0; i<N; i++) {
			files[i] = br.readLine();
			if(Pattern.matches("^" + pattern[0] + ".*" + pattern[1] +"$", files[i])) {
				bw.write("DA\n");
			}else {
				bw.write("NE\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
