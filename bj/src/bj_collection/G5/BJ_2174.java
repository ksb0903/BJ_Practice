package bj_collection.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2174 {
	static class Robot {
		int num, x, y;
		char dir;

		public Robot(int num, int x, int y, char dir) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int A, B, N, M, map[][];
	static Robot[] robots;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[B + 1][A + 1];
		robots = new Robot[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			robots[i] = new Robot(i, x, y, d);
			map[y][x] = i;
		}

		boolean flag = true;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			char cmd = st.nextToken().charAt(0);
			int cnt = Integer.parseInt(st.nextToken());

			if(!operate(num, cmd, cnt)) {
				flag = false;
				break;
			}
		}
		
		if(flag) System.out.println("OK");
	}

	public static boolean operate(int num, char cmd, int cnt) {
		while(cnt>0) {
			if(cmd=='R') {
				switch(robots[num].dir) {
				case 'W':
					robots[num].dir = 'N';
					break;
				case 'E':
					robots[num].dir = 'S';
					break;
				case 'S':
					robots[num].dir = 'W';
					break;
				case 'N':
					robots[num].dir = 'E';
					break;
				}
			}else if(cmd=='L') {
				switch(robots[num].dir) {
				case 'W':
					robots[num].dir = 'S';
					break;
				case 'E':
					robots[num].dir = 'N';
					break;
				case 'S':
					robots[num].dir = 'E';
					break;
				case 'N':
					robots[num].dir = 'W';
					break;
				}
			}else {
				int prevx = robots[num].x;
				int prevy = robots[num].y;
				
				switch(robots[num].dir) {
				case 'W':
					robots[num].x--;
					break;
				case 'E':
					robots[num].x++;
					break;
				case 'S':
					robots[num].y--;
					break;
				case 'N':
					robots[num].y++;
					break;
				}
				
				if(robots[num].x<1 || robots[num].y<1 || robots[num].x>A || robots[num].y>B) {
					System.out.println("Robot " + num + " crashes into the wall");
					return false;
				}else if(map[robots[num].y][robots[num].x]!=0) {
					System.out.println("Robot " + num + " crashes into robot " + map[robots[num].y][robots[num].x]);
					return false;
				}else {
					map[robots[num].y][robots[num].x] = num;
					map[prevy][prevx] = 0;
				}
			}
			
			cnt--;
		}
		
		return true;
	}
}
