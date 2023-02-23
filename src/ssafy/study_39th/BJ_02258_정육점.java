package ssafy.study_39th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/2258 )
 */
public class BJ_02258_정육점 {

	static int N, M, ans;
	static PriorityQueue<Meat> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 덩어리의 개수
		M = Integer.parseInt(st.nextToken()); // 필요한 고기의 양
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int kg = Integer.parseInt(st.nextToken());
			int won = Integer.parseInt(st.nextToken());
			pq.add(new Meat(kg, won));
		}

		boolean flag = false;
		ans = Integer.MAX_VALUE;
		int weight = 0; // 고기의 무게 합
		int money = 0; // 고기의 가격 합
		int last = -1; // 이전 가격
		while (!pq.isEmpty()) {
			Meat meat = pq.poll();
			if (last == meat.won) {
				money += meat.won;
			} else {
				last = meat.won;
				money = meat.won;
			}
			weight += meat.kg;

			if (weight >= M) { // 무게가 충족된다면
				flag = true;
				ans = Math.min(ans, money);
			}
		}

		System.out.println(flag ? ans : -1);

	}

	static class Meat implements Comparable<Meat> {
		int kg, won; // 무게, 가격

		public Meat(int kg, int won) {
			super();
			this.kg = kg;
			this.won = won;
		}

		@Override
		public int compareTo(Meat o) { // 가격순으로 정렬
			return this.won == o.won ? o.kg - this.kg : this.won - o.won;
		}

	}

}
