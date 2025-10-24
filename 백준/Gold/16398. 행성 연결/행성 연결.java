import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//인접행렬 2중for문 그래프그리기
//인접리스트 + pq 사용 X

public class Main {
	static int N;
	static int[][] graph;
	static StringTokenizer st;
	static boolean[] visited;
	static int[] minCost;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		graph = new int[N][N];
		visited = new boolean[N];
		minCost = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.fill(minCost, Integer.MAX_VALUE);
		minCost[0] = 0; // 0번 행성부터 시작

		long total = 0;
	
		// N개의 정점을 모두 MST에 포함시킬 때까지 반복
		for (int i = 0; i < N; i++) {
			int u = -1;
			int min = Integer.MAX_VALUE;

			// 방문하지 않은 노드 중 최소비용 노드 찾기
			for (int j = 0; j < N; j++) {
				if (!visited[j] && minCost[j] < min) {
					min = minCost[j];
					u = j;
				}
			}

			visited[u] = true; // MST에 포함
			total += min; // 최소비용 누적

			// u를 기준으로 인접 정점 최소비용 갱신
			for (int v = 0; v < N; v++) {
				if (!visited[v] && graph[u][v] < minCost[v]) {
					minCost[v] = graph[u][v];
				}
			}
		}

		System.out.println(total);

	}

}
