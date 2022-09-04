package ssafy.study_26th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/19582 )
 * 200년간 폐관수련했더니 PS 최강자가 된 건에 대하여
 */
public class BJ_19582_200년간폐간수련 {

	static int N;
	static Node[] input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		input = new Node[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			input[i] = new Node(x, p);
		}
		
		// 일단 모든 대회를 참석해본다
		int cnt = -1;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if(sum > input[i].x) {
				cnt = i;
				break;
			}
			sum += input[i].p;
		}
		
		// 모든 대회에 참석이 가능하면
		if(cnt == -1) {
			System.out.println("Kkeo-eok");
			return;
		}
		
		// 처음으로 가능하지 않았던 cnt번째 대회를 제외하고 모든 대회 참석해보기
		sum = 0;
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			if(i == cnt) continue;
			if(sum > input[i].x) {
				flag = false;
				break;
			}
			sum += input[i].p;
		}
		
		// cnt번째 대회를 제외하고 모든 대회가 참석 가능하면
		if(flag) {
			System.out.println("Kkeo-eok");
			return;
		}
		
		// cnt번째 대회를 참가할 수 있도록 cnt이전에 상금이 가장 큰 대회 불참해보기
		int maxCnt = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < cnt; i++) {
			if(max < input[i].p) {
				max = input[i].p;
				maxCnt = i;
			}
		}
		
		sum = 0;
		flag = true;
		for (int i = 0; i < N; i++) {
			if(i == maxCnt) continue;
			if(sum > input[i].x) {
				flag = false;
				break;
			}
			sum += input[i].p;
		}
		
		if(flag) System.out.println("Kkeo-eok");
		else System.out.println("Zzz");

	}

	static class Node {
		int x, p; // x:상금 합 제한, p:획득 상금

		public Node(int x, int p) {
			super();
			this.x = x;
			this.p = p;
		}

	}

}
