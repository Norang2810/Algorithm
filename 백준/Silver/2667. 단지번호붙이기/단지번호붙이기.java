import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	static char[][] map;
	static int N, cnt;
	static boolean[][] visit;
	
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	// 각 단지의 값을 담는 list
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		//풀이
		//2차원 배열 순회 탐색 visit 하지 않은 1이 있으면 dfs 로 단지 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != '1' || visit[i][j]) continue;
				
				// 새로운 단지 발견
				cnt = 0; //초기화
				dfs(i,j);
				list.add(cnt);
			}
		}
		//정렬 오름차순으로 list 정렬
		Collections.sort(list);
		
		System.out.println(list.size());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	static void dfs(int y,int x) {
		visit[y][x] =true; //방문 체크
		cnt ++; // 단지내 주택 수 증가
		
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			
			// 새로운 좌표(ny,nx) 대한 범위 체크, visit 체크
			if (ny<0 || nx <0 ||ny>=N || nx >=N || map[ny][nx] != '1' ||visit[ny][nx]) continue;
			
			dfs(ny,nx);
		}
	}

}
