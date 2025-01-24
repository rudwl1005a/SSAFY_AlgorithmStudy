package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_09555_대회장소준비 {

    static int T, N, M, map[][];
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st1.nextToken());
                }
            }
            bw.write(solve() + "\n");
        }

        br.close();
        bw.close();
    }

    private static int solve() {

        // 인접한 같은학교 출신의 팀을 가지는 학교의 id 리스트
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 이미 체크한 학교는 건너뜀
                if(map[i][j] != -1 || !list.contains(map[i][j])) {
                    for (int d = 0; d < 8; d++) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];

                        if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == -1 || map[i][j] != map[ny][nx]) continue;
                        if(!list.contains(map[i][j])) list.add(map[i][j]);
                    }
                }
            }
        }

        return list.size();
    }
}
