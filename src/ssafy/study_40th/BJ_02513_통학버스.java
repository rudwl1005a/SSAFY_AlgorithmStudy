package ssafy.study_40th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/2513 )
 */
public class BJ_02513_통학버스 {

	static int N, K, S, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 아파트 단지 수
		K = Integer.parseInt(st.nextToken()); // 통학버스 정원
		S = Integer.parseInt(st.nextToken()); // 학교의 위치

		PriorityQueue<Apart> left = new PriorityQueue<>((a1, a2) -> a1.n - a2.n); // 단지 위치 기준 오름차순 정렬
		PriorityQueue<Apart> right = new PriorityQueue<>((a1, a2) -> a2.n - a1.n); // 단지 위치 기준 내림차순 정렬

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			if (n < S) { // 학교 기준 왼쪽에 있다면
				left.add(new Apart(n, p));
			} else { // 학교 기준 오른쪽에 있다면
				right.add(new Apart(n, p));
			}
		}

		while (!left.isEmpty()) {
			int cnt = 0; // 현재 버스 이동 중 태운 학생 수
			Apart cur = left.poll();
			if (cur.p <= K - cnt) { // 현재 버스에 다 태울 수 있다면
				cnt += cur.p; // 우선 버스에 태우고
				// 오면서 남는 인원 버스에 태우기
				while (!left.isEmpty() && cnt < K) {
					Apart add = left.poll();
					if (add.p <= K - cnt) {
						cnt += add.p;
					} else {
						left.add(new Apart(add.n, add.p - (K - cnt)));
						cnt = S;
					}
				}
			} else { // 현재 버스에 다 태울 수 없다면
				left.add(new Apart(cur.n, cur.p - (K - cnt))); // 꽉채울때까지 태우고 남는 인원 다시 pq에 넣어주기
				cnt = K; // 꽉채움
			}

			// 한번 이동은 제일 먼 아파트기준 *2
			ans += (S - cur.n) * 2;
		}

		while (!right.isEmpty()) {
			int cnt = 0; // 현재 버스 이동 중 태운 학생 수
			Apart cur = right.poll();
			if (cur.p <= K - cnt) { // 현재 버스에 다 태울 수 있다면
				cnt += cur.p; // 우선 버스에 태우고
				// 오면서 남는 인원 버스에 태우기
				while (!right.isEmpty() && cnt < K) {
					Apart add = right.poll();
					if (add.p <= K - cnt) {
						cnt += add.p;
					} else {
						right.add(new Apart(add.n, add.p - (K - cnt)));
						cnt = K;
					}
				}
			} else { // 현재 버스에 다 태울 수 없다면
				right.add(new Apart(cur.n, cur.p - (K - cnt))); // 꽉채울때까지 태우고 남는 인원 다시 pq에 넣어주기
				cnt = K; // 꽉채움
			}

			// 한번 이동은 제일 먼 아파트기준 *2
			ans += (cur.n - S) * 2;
		}

		System.out.println(ans);
	}

	static class Apart {
		int n, p; // n위치, p학생수

		public Apart(int n, int p) {
			super();
			this.n = n;
			this.p = p;
		}

	}

}
