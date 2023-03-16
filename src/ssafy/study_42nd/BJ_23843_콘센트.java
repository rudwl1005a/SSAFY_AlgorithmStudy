package ssafy.study_42nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/23843 )
 */
public class BJ_23843_콘센트 {

	static int N, M, ans;
	static Socket socket[];
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}

		socket = new Socket[M];
		for (int i = 0; i < M; i++) {
			socket[i] = new Socket(0, false);
		}
		
		while (!pq.isEmpty()) {
			for (int i = 0; i < M; i++) {
				if (socket[i].charging) continue;
				if (!pq.isEmpty()) {
					socket[i].remain = pq.poll();
					socket[i].charging = true;
				}
			}

			for (int i = 0; i < M; i++) {
				if (socket[i].charging) {
					socket[i].remain--;
					if (socket[i].remain == 0) {
						socket[i].charging = false;
					}
				}
			}

			ans++;
		}

		int remain = 0;
		for (int i = 0; i < M; i++) {
			if (!socket[i].charging) continue;
			remain = Math.max(remain, socket[i].remain);
		}
		ans += remain;

		System.out.println(ans);
	}

	static class Socket {
		int remain;
		boolean charging;

		public Socket(int remain, boolean charging) {
			super();
			this.remain = remain;
			this.charging = charging;
		}
	}

}
