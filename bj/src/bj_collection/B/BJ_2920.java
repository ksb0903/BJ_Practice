package bj_collection.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2920 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		String line = br.readLine().replace(" ", "");
		String asc = "12345678";
		String desc = "87654321";
		
		if(line.equals(asc)) System.out.println("ascending");
		else if(line.equals(desc)) System.out.println("descending");
		else System.out.println("mixed");
	}
}
