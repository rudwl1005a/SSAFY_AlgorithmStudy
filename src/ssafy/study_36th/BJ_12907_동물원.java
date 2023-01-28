package ssafy.study_36th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/12907 )
 */
public class BJ_12907_동물원 {

	static int N, num[], ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 동물의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[41]; // count[i] : 자기보다 큰 동물이 i만큼 있다고 말한 동물의 개수
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			num[n]++;
		}

		int sum = 0;
		ans = 1;
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			if (num[i] == 2) { // 동물의 개수가 2라면
				if (flag) { // i보다 작은 수에서 키큰 동물이 1이 존재했을 때, i에서 2가 나올수는 없다
					break;
				} else { // 가능한 조합의 수 *2
					ans *= 2;
				}
			} else if (num[i] == 1) { // 동물의 개수가 1이라면
				flag = true;
			} else { // 이외는 가능하지 않다
				break;
			}
			sum += num[i]; // 총 동물의 개수 확인하기 위해
		}

		if (flag) ans *= 2;
		System.out.println(sum != N ? 0 : ans);
	}

}
