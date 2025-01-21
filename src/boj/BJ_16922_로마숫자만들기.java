package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 백준 S3 ( https://www.acmicpc.net/problem/16922 )
 * 수학, 구현, 브루트포스 알고리즘, 조합론, 백트래킹
 */
public class BJ_16922_로마숫자만들기 {

    static List<Integer> list;
    static int N;
    static int[] roma = new int[] {1, 5, 10, 50}; // 로마 숫자값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        solve(0, 0, 0);

        bw.write(list.size() + "");

        bw.flush();
        bw.close();
    }

    private static void solve(int i, int sum, int idx) {

        if (i == N) {
            if (!list.contains(sum)) {
                list.add(sum);
            }
            return;
        }

        for(int j = idx; j < 4; j++) {
            int temp = sum + roma[j];
            solve(i + 1, temp, j);
        }

    }
}
