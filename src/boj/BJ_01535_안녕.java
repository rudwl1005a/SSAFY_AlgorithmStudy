package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S2 ( https://www.acmicpc.net/problem/1535 )
 * 부분집합 (브루트포스 알고리즘)
 */
public class BJ_01535_안녕 {

	static int N, L[], J[], ans;
	static boolean selected[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		L = new int[N]; // 잃는 체력
		J = new int[N]; // 얻는 기쁨

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}

		selected = new boolean[N];
		solve(0, 100, 0);
		
		System.out.println(ans);
	}

	private static void solve(int cnt, int hp, int happy) {
		if(hp <= 0) return;
		if(cnt == N) {
			ans = Math.max(ans, happy);
			return;
		}
		
		selected[cnt] = true;
		solve(cnt + 1, hp - L[cnt], happy + J[cnt]);
		
		selected[cnt] = false;
		solve(cnt + 1, hp, happy);
	}

}
