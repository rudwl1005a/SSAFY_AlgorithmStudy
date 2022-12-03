package ssafy.study_18th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/2262 )
 */
public class BJ_02262_토너먼트만들기 {

	static int N, diff, max;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		diff = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			list.add(tmp);
		}

		max = N;
		for (int i = 0; i < N - 1; i++) {
			int idx = list.indexOf(max);
			if (idx == 0) {
				diff += list.get(idx) - list.get(idx + 1);
			} else if (idx == list.size() - 1) {
				diff += list.get(idx) - list.get(idx - 1);
			} else {
				diff += Math.min(list.get(idx) - list.get(idx + 1), list.get(idx) - list.get(idx - 1));
			}
			list.remove(idx);
			max--;
		}
		
		System.out.println(diff);
	}
}
