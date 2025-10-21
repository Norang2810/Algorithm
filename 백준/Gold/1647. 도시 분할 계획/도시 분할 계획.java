import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] parent;
	static List<Edge> edges = new ArrayList<Edge>();
	static StringTokenizer st;

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b)
			parent[b] = a;
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
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edges.add(new Edge(a, b, w));
		}

		edges.sort((a, b) -> a.weight - b.weight);

		int totalWeight = 0;
		int maxEdge = 0;

		for (Edge e : edges) {
			if (find(e.from) != find(e.to)) {
				union(e.from, e.to);
				totalWeight += e.weight;
				maxEdge = e.weight; // 마지막 더해진 간선이 가장큰간선 ->람다식 로직으로인해
			}
		}
		System.out.println(totalWeight - maxEdge);
	}

}
