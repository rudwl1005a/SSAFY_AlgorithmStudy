package boj;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 S4 ( https://www.acmicpc.net/problem/25550 )
 * 수학
 */
public class BJ_25550_택배색칠 {

    static int N, M;
    static long ans, map[][];;
    static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
    static int[] dx = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new long[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Long.parseLong(st.nextToken());
            }
        }

        // 풀이
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                // 사방에서 가장 낮은 택배 기준
                if(map[i][j] < 1) continue;
                long min = map[i][j] - 1;
                for(int d = 0; d < 4; d++) {
                    int ny = i + dy[d];
                    int nx = j + dx[d];
                    min = Math.min(min, map[ny][nx]);
                }
                ans += min;
            }
        }

        bw.write(ans + "");

        bw.flush();
        bw.close();
    }
}
