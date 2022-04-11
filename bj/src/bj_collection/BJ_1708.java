package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_1708 {
	static class Dot{
		long x, y;

		public Dot(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int N;
	static ArrayList<Dot> list = new ArrayList<>();
	static Stack<Dot> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Dot start = new Dot(40001, 40001);
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			if(start.y>b) {
				start.x = a;
				start.y = b;
			}else if(start.y==b && start.x>a) {
				start.x = a;
			}
				
			list.add(new Dot(a, b));
		}
		Collections.sort(list, new Comparator<Dot>() {

			@Override
			public int compare(Dot o1, Dot o2) {
				long ret = check(start, o1, o2);
				
				if(ret>0) {
					return -1;
				}else if(ret<0) {
					return 1;
				}else {
					
					long d1 = getDist(start, o1);
					long d2 = getDist(start, o2);
					
					if(d1>d2) return 1;
				}
				return -1;
			}
		});
		
		stack.push(start);
		for(int i=1; i<N; i++) {
			while(stack.size()>=2 && (check(stack.get(stack.size()-2), stack.get(stack.size()-1), list.get(i))<=0)) {
				stack.pop();
			}
			stack.push(list.get(i));
		}
		
		System.out.println(stack.size());
	}
	
	public static long check(Dot d1, Dot d2, Dot d3) {
		// 각도 계산
		long res = (d1.x*d2.y+d2.x*d3.y+d3.x*d1.y) - (d2.x*d1.y+d3.x*d2.y+d1.x*d3.y);
		
		if(res>0) return 1;
		else if(res<0) return -1;
		else return 0;
	}
	
	public static long getDist(Dot d1, Dot d2) {
		// 거리 계산
		return (d2.x-d1.x)*(d2.x-d1.x) + (d2.y-d1.y)*(d2.y-d1.y);
	}
}
