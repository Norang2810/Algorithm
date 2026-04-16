import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, V;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] Args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        //그래프 초기화하기

        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<Integer>();
        }

        //간선 입력받기

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list[v1].add(v2);
            list[v2].add(v1);
        }

        // 정렬
        for (int i = 0; i < N + 1; i++) {
            Collections.sort(list[i]);
        }

        // static  으로 선언해서 메모리에 남아있음 그래서 초기화
        visited = new boolean[N + 1];
        DFS(V);
        sb.append("\n");

        visited = new boolean[N + 1];
        BFS(V);
        System.out.println(sb);
    }


    static void DFS(int now) {
        visited[now] = true;
        sb.append(now).append(" ");

        for (int next : list[now]) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            sb.append(now).append(" ");

            for(int next :list[now]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
