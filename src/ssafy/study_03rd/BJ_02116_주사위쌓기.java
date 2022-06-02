package ssafy.study_03rd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/2116 )
 */
public class BJ_02116_주사위쌓기 {

	static int N, sum, ans; // ans : 주사위 옆면의 최대 값
	static int[][] dice;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];
		ans = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 맨 밑의 주사위
		for (int i = 0; i < 6; i++) { // i : 맨 위가 될 수 있는 숫자는 몇번째인지
			sum = 0;
			find(0, i);
		}

		System.out.println(ans);
	}

	// cnt: 몇개 뽑았는지, up: 현재 쌓여있는 주사위의 위 숫자
	private static void find(int cnt, int up) {

		// 현재 주사위의 옆면 최대값 저장
		sum += findMax(cnt, up);

		// 다 뽑았으면 계산 후 리턴
		if (cnt == N - 1) {
			ans = Math.max(ans, sum);
			return;
		}
		
		// 다음 주사위 찾기
		int nUp = -1;
		for (int i = 0; i < 6; i++) { // i : 아래가 될 수 있는 숫자는 몇번째인지
			if(dice[cnt + 1][i] == dice[cnt][up]) {
				// 반대편 저장 - 현재 주사위의 아래 숫자가 밑 주사위의 위 숫자와 같으면 현재 주사위 위를 보내줘야함
				switch(i) {
				case 0:
					nUp = 5;
					break;
				case 1:
					nUp = 3;
					break;
				case 2:
					nUp = 4;
					break;
				case 3:
					nUp = 1;
					break;
				case 4:
					nUp = 2;
					break;
				case 5:
					nUp = 0;
					break;
				}
				break;
			}
		}
		
		find(cnt + 1, nUp);
	}

	private static int findMax(int d, int up) {

		int max = Integer.MIN_VALUE;

		if (up == 0 || up == 5) {
			max = Math.max(max, dice[d][1]);
			max = Math.max(max, dice[d][2]);
			max = Math.max(max, dice[d][3]);
			max = Math.max(max, dice[d][4]);
		} else if (up == 1 || up == 3) {
			max = Math.max(max, dice[d][0]);
			max = Math.max(max, dice[d][2]);
			max = Math.max(max, dice[d][4]);
			max = Math.max(max, dice[d][5]);
		} else if (up == 2 || up == 4){
			max = Math.max(max, dice[d][0]);
			max = Math.max(max, dice[d][1]);
			max = Math.max(max, dice[d][3]);
			max = Math.max(max, dice[d][5]);
		}

		return max;
	}

}
