package ssafy.study_27th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/2109 )
 */
public class BJ_02109_순회강연 {

	static int N, ans;
	static boolean select[] = new boolean[10001];
	static PriorityQueue<Lecture> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pq.offer(new Lecture(p, d));
		}

		while (!pq.isEmpty()) {
			Lecture lecture = pq.poll();
			for (int i = lecture.d; i > 0; i--) { // d일부터 1일까지 역순으로 가능한지 판별
				if (!select[i]) {
					select[i] = true;
					ans += lecture.p;
					break;
				}
			}
		}

		System.out.println(ans);

	}

	static class Lecture implements Comparable<Lecture> {
		int p, d;

		public Lecture(int p, int d) {
			super();
			this.p = p;
			this.d = d;
		}

		@Override
		public int compareTo(Lecture o) {
			return o.p - this.p;
		}

	}
}
