package boj;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 S4 ( https://www.acmicpc.net/problem/29733 )
 */
public class BJ_29733_3차원지뢰찾기 {

    static int R, C, H;
    static char map[][][];

    static int[] dy = { -1, -1, -1, 0, 0, 0, 1, 1, 1 }; // 사방
    static int[] dx = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][R][C];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < R; j++) {
                map[i][j] = br.readLine().toCharArray();
            }
        }

        // 풀이
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if(map[i][j][k] == '*') sb.append("*");
                    else sb.append(findMines(i, j, k));
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static String findMines(int z, int y, int x) {
        int ans = 0;
        // 인접한 칸에서 지뢰 있는지 찾기
        for (int i = -1; i < 2; i++) {
            for (int d = 0; d < 9; d++) {
                if(i == 0 && d == 4) continue; // 자기 자신
                int ny = y + dy[d];
                int nx = x + dx[d];
                int nz = z + i;
                if(nx < 0 || ny < 0 || nz < 0 || nx >= C || ny >= R || nz >= H || map[nz][ny][nx] == '.') continue;
                ans++;
            }
        }
        return Integer.toString(ans%10); // 10으로 나눈 나머지 리턴
    }
}
