package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/20291 )
 */
public class BJ_20291_파일정리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String[] file = br.readLine().split("\\.");
			if (map.containsKey(file[1])) {
				map.replace(file[1], map.get(file[1]) + 1);
			} else {
				map.put(file[1], 1);
			}
		}

		ArrayList<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		for (String key : list) {
			sb.append(key).append(" ").append(map.get(key)).append("\n");
		}
		System.out.println(sb);
	}

}
