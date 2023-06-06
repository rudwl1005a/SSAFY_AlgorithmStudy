package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/2910 )
 */
public class BJ_02910_빈도정렬 {

	static int N, C;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// map에다가 빈도 저장
		HashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (map.containsKey(num)) {
				map.replace(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		// arraylist에 저장한후 정렬
		ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return Integer.compare(map.get(b), map.get(a));
			}
		});

		// 개수만큼 출력
		StringBuilder sb = new StringBuilder();
		for (int n : list) {
			for (int i = 0; i < map.get(n); i++) {
				sb.append(n).append(" ");
			}
		}
		System.out.println(sb);

	}

}
