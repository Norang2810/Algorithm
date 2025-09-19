import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 가중치가 없는 최단경로 => bfs
// visit : 2차원 배열이고, 사방탐색일 경우 visit[y][x] 로 해결
//  이 문제는 말처럼 K번 이동하는 상황 동일한 좌표에서 발생. <= y,x 좌표에서 사방탐색 + 제한적 8방 탐색
//  그래서 같은 좌표라 하더라도 K 값이 어떤 값이냐에 따라 이후의 상황이 달라진다. visit[y][x][k]
public class Main {
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visit;
    
    // 상하좌우
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = {  0, 0,-1, 1 };
    
    // 말
    static int[] hdy = { -2, -2, -1, -1,  2,  2,  1, 1};
    static int[] hdx = { -1,  1, -2,  2, -1,  1, -2, 2};
    
    static class Node{
        int y, x, k, d;
        Node(int y, int x, int k, int d){
            this.y = y; this.x = x; this.k = k; this.d = d;
        }
    }
    
    static Queue<Node> queue = new ArrayDeque<>();
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visit = new boolean[H][W][K + 1]; // 0, 1 ~ K
        
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        bfs();
    }
    static void bfs() {
        // 시작 좌표
        visit[0][0][K] = true;
        queue.offer(new Node(0, 0, K, 0));
        
        while(! queue.isEmpty() ) {
            
            Node node = queue.poll();
            
            // 목표 도달?
            if( node.y == H - 1 && node.x == W - 1 ) {
                System.out.println(node.d);
                return;
            }
            
            // 4방 탐색
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if( ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][node.k] ) continue;
                
                visit[ny][nx][node.k] = true;
                queue.offer(new Node(ny, nx, node.k, node.d + 1));
            }
            
            // 8방 탐색 (제한적)
            if( node.k == 0 ) continue;
            
            // k 를 1개 쓴다. k -> k - 1
            for (int i = 0; i < 8; i++) {
                int ny = node.y + hdy[i];
                int nx = node.x + hdx[i];
                if( ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][node.k - 1] ) continue;
                
                visit[ny][nx][node.k - 1] = true;
                queue.offer(new Node(ny, nx, node.k - 1, node.d + 1));
            }           
        }
        
        System.out.println(-1);
    }
}
