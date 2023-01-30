package ssafy.study_36th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1027 )
 */
public class BJ_01027_고층건물 {

	static int N, arr[], visible[], ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		/*
		 * 건물은 서로 볼 수 있다 -> 인덱스 증가하는 방향으로만 검사해도 된다
		 * 현재 기울기보다 다음 기울기가 커야만 보인다
		 */
		visible = new int[N];
		for (int i = 0; i < N - 1; i++) {
			visible[i]++; // 바로 옆 건물은 무조건 보임
			visible[i+1]++;
			double now = arr[i+1] - arr[i];
			for (int j = i+2; j < N; j++) {
				double next = (double)(arr[j] - arr[i]) / (j - i);
				if(next <= now) continue; // 건물이 보이지 않으면 건너뜀
				now = next;
				visible[i]++;
				visible[j]++;
			}
		}
		
		ans = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, visible[i]);
		}
		
		System.out.println(ans);
		
	}
	
	/* 틀린 버전
	static int N, arr[], ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		ans = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				boolean flag = true;
				if (i > j) {
					double slope1 = (double) (arr[j] - arr[i]) / (j - i); // 원래 기울기
					for (int k = 1; k < i - j; k++) {
						double slope2 = (double) (arr[j + k] - arr[i]) / (j + k - i); // j와 i사이의 점과의 기울기
						if (slope1 <= slope2) { // 기울기가 증가하면 안된다
							flag = false;
							break;
						}
					}
					if (flag) cnt++;
				} else {
					double slope1 = (double) (arr[j] - arr[i]) / (j - i); // 원래 기울기
					for (int k = 1; k < j - i; k++) {
						double slope2 = (double) (arr[i + k] - arr[i]) / k; // i와 j사이의 점과의 기울기
						if (slope2 <= slope1) { // 기울기가 감소하면 안된다
							flag = false;
							break;
						}
					}
					if (flag) cnt++;
				}
			}
			ans = Math.max(ans, cnt);
		}

		System.out.println(ans);
	}
	*/

}
