import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
// 벽은 세우는 것 : 조합
// 바이러스가 퍼지는 것 : 완탐(bfs, dfs)
// 반복문으로 2차원 배열 중 안전지대 계산 -> max 갱신
// 위의 처리를 위해서는 map 이 변경되어야 한다.
// 원본 -> 조합 -> 완탐, 원 -> 조합 -> 완탐..... <= 하나의 맵으로는 어렵다. 원본 맵은 그대로 유지. 복사한 맵에 조합, 완탐 적용
// 0 (zero ) 항목 중 벽 3개를 세워야 한다. <= 0 항목:src, tgt: 3개, 0 인 항목을 자료구조 (List> 넣고 3개를 뽑는 방법 선택
// virus 항목도 별도의 자료구조 (List) 로 관리
public class Main {
    static int N, M, max;
    static int[][] map, copyMap;
    static List<Node> zero = new ArrayList<Node>(); // src
    static List<Node> virus = new ArrayList<Node>();
    static int zeroSize;
    static Node[] wall = new Node[3]; // tgt
    
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = {  0, 0,-1, 1 };
    
    static Queue<Node> queue = new ArrayDeque<>();
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                
                if( n == 0 ) zero.add(new Node(i, j)); // 0 항목들
                else if( n == 2 ) virus.add(new Node(i, j)); // 2 항목들
            }
        }
        
        zeroSize = zero.size();
        
        // 풀이
        max = Integer.MIN_VALUE;
        
        comb(0, 0);
        
        System.out.println(max);
    }
    static void comb(int srcIdx, int tgtIdx) {
        // 기저 조건
        if( tgtIdx == 3 ) {
            // complete code
            // 조합 완성
            check();
            return;
        }
        
        if( srcIdx == zeroSize ) return;
        
        wall[tgtIdx] = zero.get(srcIdx); // 선택
        comb(srcIdx + 1, tgtIdx + 1);
        comb(srcIdx + 1, tgtIdx); // 비선택
    }
    
    static void check() {
        // map -> copyMap 초기화 ( 최초 상태 )
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        
        // 벽을 세운다.
        for (int i = 0; i < 3; i++) {
            int y = wall[i].y;
            int x = wall[i].x;
            copyMap[y][x] = 1;
        }
        
        // virus 퍼진다. (bfs)
        queue.addAll(virus);
        
        while( ! queue.isEmpty() ) {
            
            Node n = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int ny = n.y + dy[d];
                int nx = n.x + dx[d];
                if( ny < 0 || nx < 0 || ny >= N || nx >= M ) continue;
                if( copyMap[ny][nx] == 0 ) { // 빈 칸이면 퍼진다.
                    copyMap[ny][nx] = 2;
                    queue.offer(new Node(ny, nx));
                }
            }
        }
        
        // 안전지역 계산 -> max 갱신
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if( copyMap[i][j] == 0 ) sum++;
            }
        }   
        
        max = Math.max(max, sum);
    }
    
    static class Node{
        int y, x;
        Node(int y, int x){
            this.y = y; this.x = x;
        }
    }
}