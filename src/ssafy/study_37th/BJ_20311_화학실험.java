package ssafy.study_37th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/20311 )
 */
public class BJ_20311_화학실험 {

	static int N, K, ans[];
	static PriorityQueue<Cylinder> pq = new PriorityQueue<>();
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 시험관의 개수
		K = Integer.parseInt(st.nextToken()); // 색깔의 종류 수
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= K; i++) {
			pq.add(new Cylinder(i, Integer.parseInt(st.nextToken())));
		}

		ans = new int[N];
		Cylinder prev = new Cylinder(0, 0);
		Cylinder temp = new Cylinder(0, 0);
		int cnt = 0;
		while (true) {
			Cylinder now = pq.peek();
			if (now.idx == prev.idx) { // 전의 시험관이랑 같은 것이라면 temp에 저장 후 다음 것 확인
				temp = now;
				pq.poll();
			} else { // 전의 시험관이랑 다르다면 넣어주기
				ans[cnt++] = now.idx;
				prev = now;
				pq.poll();
				if (temp.idx != 0) { // temp에 저장된 것이 있다면 pq에 추가
					pq.add(temp);
					temp = new Cylinder(0, 0); // temp 초기화
				}
				if (now.num - 1 != 0) { // num이 0이 아니라면 pq에 다시 추가
					pq.add(new Cylinder(now.idx, now.num - 1));
				}
			}

			if (cnt == N) { // N개 다 채웠다면 break
				flag = true;
				break;
			}
			if (pq.isEmpty()) { // N개 채우지 않았는데 넣을 시험관이 떨어졌다면 break
				break;
			}
		}

		if (flag) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(ans[i]).append(" ");
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}

	}

	static class Cylinder implements Comparable<Cylinder> {
		int idx, num;

		public Cylinder(int idx, int num) {
			super();
			this.idx = idx;
			this.num = num;
		}

		@Override
		public int compareTo(Cylinder o) {
			return this.num == o.num ? this.idx - o.idx : o.num - this.num;
		}

	}

}
