package boj;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 S3 ( https://www.acmicpc.net/problem/261690 )
 * 그래프 이론, 그래프 탐색, 깊이 우선 탐색, 백트래킹
 */
public class BJ_26169_세번이내에사과를먹자 {

    static int r, c, map[][];
    static boolean visited[][], ans;

    static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
    static int[] dx = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new int[5][5];
        visited = new boolean[5][5];
        
        // 입력
        StringTokenizer st;
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited[r][c] = true;
        doEat(r, c, 0, 0);

        if(ans) {
            bw.write("1");
        } else {
            bw.write("0");
        }

        bw.flush();
        bw.close();
    }

    private static void doEat(int r, int c, int cnt, int eat) {
        // 이미 사과 먹을 수 있는 경우의 수 발견했거나 4번 이동했으면 리턴
        if(ans || cnt == 4) return;
        // 3번 이하 이동했을 때 사과 2개 이상 먹었으면 true
        if(cnt <= 3 && eat >= 2) {
            ans = true;
            return;
        }

        for(int d = 0; d < 4; d++) {
            int ny = r + dy[d];
            int nx = c + dx[d];

            if(ny < 0 || nx < 0 || ny >= 5 || nx >= 5 || map[ny][nx] == -1 || visited[ny][nx]) continue;
            visited[ny][nx] = true;
            if(map[ny][nx] == 1) {
                doEat(ny, nx, cnt+1, eat+1);
            } else {
                doEat(ny, nx, cnt+1, eat);
            }
            visited[ny][nx] = false;
        }
    }
}
