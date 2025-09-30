import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;
/*
V: 시작 노드 부터 DFS,BFS 통해 방문하게되는 노드를 순서대로 출력
*/


public class Main {
	static int N,M,V;
	static int [] result ,visit;	
	static ArrayList<Integer> [] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
 		M = Integer.parseInt(st.nextToken());
 		V = Integer.parseInt(st.nextToken());
 		
 		arr = new ArrayList[N+1];
 		visit = new int [N+1];
 		
 		for(int i=0;i<=N;i++) {
 			arr[i] = new ArrayList<>();
 		}
 		
 		for(int i=0; i<M;i++) {
 			st = new StringTokenizer(br.readLine());
 			
 			int v = Integer.parseInt(st.nextToken());
 			int u = Integer.parseInt(st.nextToken());
 			arr[v].add(u);
 			arr[u].add(v);
 		}
 		
 		//정렬 list이므로 Collections 사용
 		for(int i=1;i<=N;i++) {
 			Collections.sort(arr[i]);
 		}
 		
 		dfs(V);
 		sb.append("\n");
 		bfs(V);
 		
 		System.out.println(sb);
	}
	
	public static void dfs(int start) {
		//제귀 로직
		visit[start] = 1;
		sb.append(start).append(" ");
		for(int next : arr[start]) {
			if(visit[next] == 0 ) dfs(next);
		} 
	
	}
	
	public static void bfs(int start) {
		Deque<Integer> q = new ArrayDeque<>();
		
		Arrays.fill(visit, 0); //visit배열은 static선언이므로 메모리에 dfs에서 사용한게 남아있음 그래서 초기화
		
		q.add(start);
		visit[start] =1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			
			for (int next: arr[cur]) {
				if(visit[next] == 0) {
					visit[next] =1;
					q.add(next);
				}
			}
		}
	}
}
