import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//DFS 풀이
public class Main {
	static int [] virus ;
	static int result = 0;
	static ArrayList<Integer>[] arr;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[n+1];
		virus = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int j = 0; j < m; j++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}
		
		dfs(1);
		System.out.println(result);

	}
	
	public static void dfs(int start) {
		virus[start] = 1;
		for(int x : arr[start]) {
			if(virus[x] == 0) {
				result++;
				dfs(x);
			}
		}
	}

}
