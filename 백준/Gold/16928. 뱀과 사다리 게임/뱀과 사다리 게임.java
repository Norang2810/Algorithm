import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] move = new int[101];
	static int[] dist = new int[101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사다리 개수
		int M = Integer.parseInt(st.nextToken()); // 뱀 개수

		Arrays.fill(move, 0);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			move[x] = y;
		}

	
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			move[u] = v; 
		}

		Arrays.fill(dist, -1);

		bfs();

		System.out.println(dist[100]);
	}

	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();

		dist[1] = 0; 
		q.offer(1);

		while (!q.isEmpty()) {
			int cur = q.poll();

			
			for (int dice = 1; dice <= 6; dice++) {
				int next = cur + dice;

				
				if (next > 100)
					continue;

				// 만약 next 칸이 사다리나 뱀 시작점이면 즉시 이동
				if (move[next] != 0) {
					next = move[next];
				}

				
				if (dist[next] != -1)
					continue;

				
				dist[next] = dist[cur] + 1;
				q.offer(next);
			}
		}
	}

}
