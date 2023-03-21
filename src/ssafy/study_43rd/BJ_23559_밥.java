package ssafy.study_43rd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/23559 )
 */
public class BJ_23559_밥 {

	static int N, X, ans;
	static PriorityQueue<Bab> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 학식 먹어야하는 날
		X = Integer.parseInt(st.nextToken()); // 가지고 있는 돈

		// 우선 1000원짜리를 모두 먹는다고 가정
		int money = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int five = Integer.parseInt(st.nextToken()); // 5000원짜리 메뉴의 맛
			int one = Integer.parseInt(st.nextToken()); // 1000원짜리 메뉴의 맛
			pq.add(new Bab(five, one));
			money += 1000;
			ans += one;
		}

		// 정렬된 순으로 1000원짜리 메뉴를 5000원 짜리로 바꿈
		while(!pq.isEmpty()) {
			Bab now = pq.poll();
			
			// 1000원짜리 메뉴가 더 맛있다면 진행 x
			if(now.one > now.five) continue;
			
			money += 4000;
			if(money > X) break; // 돈이 안되면 그만둠
			
			ans -= now.one;
			ans += now.five;
		}
		
		System.out.println(ans);
	}

	static class Bab implements Comparable<Bab> {
		int five, one;

		public Bab(int five, int one) {
			super();
			this.five = five;
			this.one = one;
		}

		@Override
		public int compareTo(Bab o) { // 5000원짜리 메뉴와 1000원짜리 메뉴의 차이가 큰 순으로 정렬
			int dif1 = this.five - this.one;
			int dif2 = o.five - o.one;
			return dif2 == dif1 ? this.one - o.one : dif2 - dif1;
		}

	}

}
