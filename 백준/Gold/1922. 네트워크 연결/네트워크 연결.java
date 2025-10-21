import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

//kruskal풀이
// 메서드 분리

public class Main {
	static int N, M;
	static int[] parent;
	static List<Edge> edges;
	static StringTokenizer st;

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[b] = a;
		}
	}

	static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		edges = new ArrayList();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edges.add(new Edge(a, b, w));

		}

		parent = new int[N + 1];
		for (int j = 1; j <= N; j++) {
			parent[j] = j;
		}

		edges.sort((a, b) -> a.weight - b.weight);

		int totalCost = 0;
		int connected = 0;

		// kruskal
		for (Edge e : edges) {
			if (find(e.from) != find(e.to)) {
				union(e.from, e.to);
				totalCost += e.weight;
				connected++;
			}

			if (connected == N - 1)
				break;
		}
		System.out.println(totalCost);
	}

}
