import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		int maxH = 0; // 지도에서 가장 높은 높이

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > maxH) {
					maxH = map[i][j];
				}
			}
		}

		int answer = 1; 

		
		for (int h = 0; h <= maxH; h++) {
			visited = new boolean[N][N];
			int count = 0; // 현재 비 높이에서의 안전 영역 개수

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 아직 방문 X, 물에 잠기지 않는 칸이면 BFS 시작
					if (!visited[i][j] && map[i][j] > h) {
						bfs(i, j, h);
						count++;
					}
				}
			}

			if (count > answer) {
				answer = count;
			}
		}

		System.out.println(answer);
	}

	static void bfs(int sx, int sy, int h) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { sx, sy });
		visited[sx][sy] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				// 범위 벗어나면 패스
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;

				// 이미 방문했거나, 물에 잠긴 칸(높이 <= h)이면 패스
				if (visited[nx][ny])
					continue;
				if (map[nx][ny] <= h)
					continue;

				visited[nx][ny] = true;
				q.offer(new int[] { nx, ny });
			}
		}

	}

}
