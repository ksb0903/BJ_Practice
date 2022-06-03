package bj_collection.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1826 {

	public static class GasStation implements Comparable<GasStation> {
		int distance, fuel;

		public GasStation(int distance, int fuel) {
			super();
			this.distance = distance;
			this.fuel = fuel;
		}

		@Override
		public int compareTo(GasStation o) {
			if (this.fuel == o.fuel) {
				return o.distance - this.distance;
			}
			return o.fuel - this.fuel;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, L, P;
	static GasStation[] list;
	static PriorityQueue<GasStation> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		list = new GasStation[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[i] = new GasStation(a, b);
		}

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		Arrays.sort(list, new Comparator<GasStation>() {
			@Override
			public int compare(GasStation o1, GasStation o2) {
				return o1.distance - o2.distance;
			}
		});

		System.out.println(solve());
	}

	public static int solve() {
		int now = 0;
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			while (true) {
				int dist = list[i].distance - now;

				if (P >= dist) {
					pq.add(list[i]);
					break;
				} else {
					if(pq.isEmpty()) return -1;
					
					GasStation poll = pq.poll();

					if (poll.distance > now) {
						P = P - (poll.distance - now) + poll.fuel;
						now = poll.distance;
					} else {
						P += poll.fuel;
					}
					cnt++;
				}
			}
		}
		
		while(P + now < L) {
			if(pq.isEmpty()) return -1;
			
			GasStation poll = pq.poll();

			if (poll.distance > now) {
				P = P - (poll.distance - now) + poll.fuel;
				now = poll.distance;
			} else {
				P += poll.fuel;
			}
			cnt++;
		}

		return cnt;
	}
}
