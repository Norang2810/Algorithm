import java.io.*;
import java.util.*;

public class Main {
    static int T, M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1}; // 상하좌우
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 열
            N = Integer.parseInt(st.nextToken()); // 행
            K = Integer.parseInt(st.nextToken()); // 배추 위치 개수

            map = new int[N][M];
            visited = new boolean[N][M];

            // 배추 좌표 입력
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int Count = 0;

            // DFS 호출 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        Count++; 
                    }
                }
            }

            System.out.println(Count);
        }
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            // 지도 범위 벗어나면 무시
            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

            // 배추가 있고 방문 안 한 곳만 재귀
            if (map[ny][nx] == 1 && !visited[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }
}

