import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int N, M;

	public static StringBuilder sb = new StringBuilder(); //출력 최적화

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];

		dfs(1, 0);
		System.out.println(sb);
	}

	public static void dfs(int at, int depth) {

		if (depth == M) { // depth == M이면 M개를 다 뽑은 상태. (깊이가 M이랑 같을경우 출력)
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}    // <- 여기까지 for문
		
		for (int i = at; i <= N; i++) {  // i는 at부터 탐색 시작   => at은 시작위치 (현재위치)
			arr[depth] = i;
			dfs(i +1 , depth + 1);
		}

	}

}
