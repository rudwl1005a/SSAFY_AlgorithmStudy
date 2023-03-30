package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/2108 )
 */
public class BJ_02108_통계학 {

	static int N, avg, mid, most, range;
	static double sum;
	static ArrayList<Integer> list = new ArrayList<>();
	static HashMap<Integer, Integer> hashmap = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			sum += n;
			list.add(n);
		}

		Collections.sort(list);

		// 최대 최소 구하기
		int max = Collections.max(list);
		int min = Collections.min(list);

		if (max < 0 && min < 0) {
			min = Math.abs(min);
		} else if (max > 0 && min > 0) {
			min = min * -1;
		} else {
			max = Math.abs(max);
			min = Math.abs(min);
		}

		// 문제에서 원하는 통계값 구하기
		avg = (int) Math.round(sum / N); // 산술평균 : N개의 수들의 합을 N으로 나눈 값
		mid = list.get(N / 2); // 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
		range = max + min; // 범위 : N개의 수들 중 최댓값과 최솟값의 차이

		most = 0; // 최빈값 : N개의 수들 중 가장 많이 나타나는 값
		for (int num : list) {
			hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
		}

		int nums = 0;
		for (int key : hashmap.values()) {
			nums = Math.max(nums, key);
		}

		list.clear();
		for (int key : hashmap.keySet()) {
			if (hashmap.get(key) == nums) {
				list.add(key);
			}
		}

		Collections.sort(list);
		if (list.size() >= 2) { // 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
			most = list.get(1);
		} else {
			most = list.get(0);
		}

		System.out.println(avg);
		System.out.println(mid);
		System.out.println(most);
		System.out.println(range);

	}

}
