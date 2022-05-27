package bj_collection.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1107 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, min;
	static boolean btn[] = new boolean[10];

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		min = Math.abs(N - 100);

		if (M == 0) {
			String s = String.valueOf(N);
			System.out.println(Math.min(min, s.length()));
		} else {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				btn[Integer.parseInt(st.nextToken())] = true;
			}
			
			solve();
			System.out.println(min);
		}
	}

	public static void solve() {
		for (int i = 0; i <= 999999; i++) {
			String s = String.valueOf(i);
			boolean flag = false;

			for (int j = 0; j < s.length(); j++) {
				if (btn[s.charAt(j) - '0']) {
					flag = true;
					break;
				}
			}

			if (!flag) {
				min = Math.min(Math.abs(N - i) + s.length(), min);
			}
		}
	}
}
