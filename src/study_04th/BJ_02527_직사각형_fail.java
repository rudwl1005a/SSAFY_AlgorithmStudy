package study_04th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/2527 )
 */
public class BJ_02527_직사각형_fail {
	// fail -> 다시 한번 풀어보기

	static int[][] square;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			square = new int[2][4]; // 0 : x, 1 : y, 2 : p, 3 : q
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					square[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int r1 = where(square[1][0], square[1][1]);
			int r2 = where(square[1][2], square[1][3]);

			// 두 점이 어디있는지에 따라 판단
			if(r1 == 1) {
				if(r2 == 1) {
					CorD(square[1][0], square[1][1], square[1][2], square[1][3]);
				} else if(r2 == 2 || r2 == 3) {
					BorD(square[1][0], square[1][1], square[1][2], square[1][3]);
				}
			} else if(r1 == 2) {
				BorD(square[1][0], square[1][1], square[1][2], square[1][3]);
			} else if(r1 == 3) {
				CorD(square[1][0], square[1][1], square[1][2], square[1][3]);
			} else if(r1 == 4) {
				if(r2 == 2 || r2 == 3 || r2 == 5 || r2 == 6) {
					System.out.println("a");
				} else if(r2 == 1 || r2 == 4) {
					BorD(square[1][0], square[1][1], square[1][2], square[1][3]);
				}
			} else if(r1 == 5) {
				System.out.println("a");
			} else if(r1 == 6) {
				BorD(square[1][0], square[1][1], square[1][2], square[1][3]);
			} else if(r1 == 7) {
				if(r2 == 1 || r2 == 4 || r2 == 8 || r2 == 9) {
					BorD(square[1][0], square[1][1], square[1][2], square[1][3]);
				} else if(r2 == 7) {
					CorD(square[1][0], square[1][1], square[1][2], square[1][3]);
				} else if(r2 == 2 || r2 == 3 || r2 == 5 || r2 == 6) {
					System.out.println("a");
				}
			} else if(r1 == 8) {
				if(r2 == 2 || r2 == 3 || r2 == 5 || r2 == 6) {
					System.out.println("a");
				} else if(r2 == 8 || r2 == 9) {
					BorD(square[1][0], square[1][1], square[1][2], square[1][3]);
				}
			} else if(r1 == 9) {
				if(r2 == 6) {
					BorD(square[1][0], square[1][1], square[1][2], square[1][3]);
				} else if(r2 == 9) {
					CorD(square[1][0], square[1][1], square[1][2], square[1][3]);
				}
			}
			
		}

	}

	private static void CorD(int a1, int b1, int a2, int b2) {
		if(b1 == square[0][3] && a2 == square[0][0]) {
			System.out.println("c");
			return;
		} else if(a1 == square[0][2] && b1 == square[0][3]) {
			System.out.println("c");
			return;
		} else if(a2 == square[0][0] && b2 == square[0][1]) {
			System.out.println("c");
			return;
		} else if(a1 == square[0][2] && b2 == square[0][1]) {
			System.out.println("c");
			return;
		}
		
		// 꼭지점이 아니면
		System.out.println("d");
	}

	private static void BorD(int a1, int b1, int a2, int b2) {
		if(a1 == square[0][0] || a2 == square[0][0]) {
			System.out.println("b");
			return;
		} else if(a1 == square[0][2] || a2 == square[0][2]) {
			System.out.println("b");
			return;
		} else if(b1 == square[0][1] || b2 == square[0][1]) {
			System.out.println("b");
			return;
		} else if(b1 == square[0][3] || b2 == square[0][3]) {
			System.out.println("b");
			return;
		}
		
		// 변이 하나라도 안겹치면
		System.out.println("d");
	}

	// 첫번째 사각형을 기준으로 9등분 했을때 위에서부터
	// 1 | 2 | 3
	// ---------
	// 4 | 5 | 6
	// ---------
	// 7 | 8 | 9
	private static int where(int a, int b) {
		if (square[0][3] <= b) {
			if (square[0][0] > a) {
				return 1;
			} else if (square[0][0] <= a && square[0][2] > a) {
				return 2;
			} else if (square[0][2] <= a) {
				return 3;
			}
		} else if (square[0][1] <= b && square[0][3] > b) {
			if (square[0][0] > a) {
				return 4;
			} else if (square[0][0] <= a && square[0][2] > a) {
				return 5;
			} else if (square[0][2] <= a) {
				return 6;
			}
		} else if (square[0][1] > b) {
			if (square[0][0] > a) {
				return 7;
			} else if (square[0][0] <= a && square[0][2] > a) {
				return 8;
			} else if (square[0][2] <= a) {
				return 9;
			}
		}

		return -1; // 오류
	}

}

// [첫번째 점, 두번째 점] - 나올 수 있는 경우
// 				[1,1] - c, d
// 		[1,2] - b, d
// 		[1,3] - b, d
// 		[2,2] - b, d
// 		[2,3] - b, d
// 				[3,3] - c, d

// 		[4,1] - b, d
// [4,2] - a
// [4,3] - a
// 		[4,4] - b, d
// [4,5] - a
// [4,6] - a
// [5,2] - a
// [5,3] - a
// [5,5] - a
// [5,6] - a
// 		[6,3] - b, d
// 		[6,6] - b, d

// 		[7,1] - b, d
// [7,2] - a
// [7,3] - a
// 		[7,4] - b, d
// [7,5] - a
// [7,6] - a
// 				[7,7] - c, d
// 		[7,8] - b, d
// 		[7,9] - b, d
// [8,2] - a
// [8,3] - a
// [8,5] - a
// [8,6] - a
// 		[8,8] - b, d
// 		[8,9] - b, d
// 		[9,3] - b, d
//		[9,6] - b, d
// 				[9,9] - c, d