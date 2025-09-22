import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//DP 풀이
public class Main {
	static int N;
	static int[][] map;
	static int[][][] memoi;
	// 현재방향(대각선,가로,세로)에 대한 좌표의 변화량

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1]; // dummy 이곳이 N+1인 이유는?
		// 좌표 4,3 으로 이동하는 방법 아래 3개를 합친다.
		// memoi [0][4][3] :대각선으로 4,3 으로 이동하는 경우의 수 (누적합)
		// memoi [1][4][3] :가로로 4,3 으로 이동하는 경우의 수 (누적합)
		// memoi [2][4][3] :세로로 4,3 으로 이동하는 경우의 수 (누적합)
		memoi = new int[3][N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// dp
		// * X
		memoi[1][1][2] = 1; // 가로, 시작좌표
		for (int y = 1; y <= N; y++) {
            for (int x = 2; x <= N; x++) {
                // 벽
                if( map[y][x] == 1 ) continue;
                
                // 대각선
                if( y < N && x < N && map[y + 1][x + 1] == 0 && map[y + 1][x] == 0 && map[y][x + 1] == 0) {
                    memoi[0][y + 1][x + 1] += ( memoi[0][y][x] + memoi[1][y][x] + memoi[2][y][x]);
                }
                // 가로
                if( x < N && map[y][x + 1] == 0 ) {
                    memoi[1][y][x + 1] += ( memoi[0][y][x] + memoi[1][y][x] );
                }
                // 세로
                if( y < N && map[y + 1][x] == 0 ) {
                    memoi[2][y + 1][x] += ( memoi[0][y][x] + memoi[2][y][x] );
                }
            }
        }
        
        System.out.println(memoi[0][N][N] + memoi[1][N][N] + memoi[2][N][N]);
    }
}
