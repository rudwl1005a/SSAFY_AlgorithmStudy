package study_02nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 실버5 ( https://www.acmicpc.net/problem/1018 )
 */
public class BJ_01018_체스판다시칠하기 {
	
	static char[][] B = { {'B','W','B','W','B','W','B','W'},
						  {'W','B','W','B','W','B','W','B'},
						  {'B','W','B','W','B','W','B','W'},
						  {'W','B','W','B','W','B','W','B'},
						  {'B','W','B','W','B','W','B','W'},
						  {'W','B','W','B','W','B','W','B'},
						  {'B','W','B','W','B','W','B','W'},
						  {'W','B','W','B','W','B','W','B'}};
	
	static char[][] W = { {'W','B','W','B','W','B','W','B'},
						  {'B','W','B','W','B','W','B','W'},
						  {'W','B','W','B','W','B','W','B'},
						  {'B','W','B','W','B','W','B','W'},
						  {'W','B','W','B','W','B','W','B'},
						  {'B','W','B','W','B','W','B','W'},
						  {'W','B','W','B','W','B','W','B'},
						  {'B','W','B','W','B','W','B','W'}};
	
	static int N, M, min;
	static char[][] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new char[N][M];
		min = Integer.MAX_VALUE;
		input = new char[N][];
		for(int i=0; i<N; i++) {
			input[i] = br.readLine().toCharArray();
		}
		
		// 로직
		for(int i=0; i<N-7; i++) {
			for(int j=0; j<M-7; j++) {
				min = Math.min(checkDiff(i,j,'B'), min);
				min = Math.min(checkDiff(i,j,'W'), min);
			}
		}
		
		// 출력
		System.out.println(min);
		
	}
	
	public static int checkDiff(int x, int y, char c) {
		int cnt = 0;
		if(c == 'B') {
			for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++) {
					if(B[i][j] != input[x+i][y+j]) cnt++;
				}
			}			
		} else {
			for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++) {
					if(W[i][j] != input[x+i][y+j]) cnt++;
				}
			}
		}
		return cnt;
	}

}
