import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph[B].add(A);
		}
		int[] count = new int[N + 1]; // 각 노드에 대해 BFS로 도달 가능한 수 저장
		int max = 0;

		for (int i = 1; i <= N; i++) {
			count[i] = bfsCount(i);
			if (count[i] > max)
				max = count[i];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (count[i] == max) {
				sb.append(i).append(' ');
			}
		}
		System.out.println(sb.toString().trim());
	}

	static int bfsCount(int start) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		visited[start] = true;
		q.offer(start);
		int cnt = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : graph[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
					cnt++; //
				}
			}
		}
		return cnt;
	}
}
