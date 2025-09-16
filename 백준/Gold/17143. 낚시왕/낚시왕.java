import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int R, C, M, sum;
	static Shark[][] map;
	static List<Shark> list = new ArrayList<>();

	// delta : 상-하-우-좌
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R + 1][C + 1]; // 0 dummy

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()); // 1-4 -> 0-3
			int z = Integer.parseInt(st.nextToken());

			Shark shark = new Shark(r, c, s, d - 1, z);
			list.add(shark);
			map[r][c] = shark;
		}

		// 풀이
		// 시물레이션 진행
		for (int i = 1; i <= C; i++) {
			catchShark(i);
			moveShark();
			killShark();
		}

		System.out.println(sum);
	}

	static void catchShark(int col) {
		// 밑으로 내려오면서
		for (int i = 1; i <= R; i++) {
			if (map[i][col] != null) {
				sum += map[i][col].z; // 크기 더한다.
				list.remove(map[i][col]); // list 삭제
				// map 초기화 생략
				break;
			}
		}
	}

	// list 에서 진행
	static void moveShark() {
		for (Shark shark : list) {
			int r = shark.r;
			int c = shark.c;
			int s = shark.s;
			int d = shark.d;

			switch (d) {
			case 0:
			case 1:
				// (R-1)*2
				s = s % (R * 2 - 2); // 어차피 제자리, 동일방향임을 이용해서 보정
				for (int i = 0; i < s; i++) {
					if (r == 1)
						d = 1; // 상 -> 하
					else if (r == R)
						d = 0; // 하 -> 상
					r += dy[d];
				}
				shark.r = r;
				shark.d = d;
				break;
			case 2:
			case 3:
				// (C-1)*2
				s = s % (C * 2 - 2); // 어차피 제자리, 동일방향임을 이용해서 보정
				for (int i = 0; i < s; i++) {
					if (c == 1)
						d = 2; // 좌 -> 우
					else if (c == C)
						d = 3; // 우 -> 좌
					c += dx[d];
				}
				shark.c = c;
				shark.d = d;
				break;
			}
		}
	}

	// list 에서 moveShark() 를 통해서 정리된 Shark 데이터를 이용해서 map 정리
	static void killShark() {
		// map 초기화
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = null;
			}
		}

		// list 에서 하나씩 꺼내서 map 에 놓으면서 처리
		// list 에서 삭제 할 때 삭제 오류 방지를 위해 뒤에서 삭제
		int size = list.size();
		for (int i = size - 1; i >= 0; i--) {
			Shark s = list.get(i);

			if (map[s.r][s.c] == null) { // 빈자리
				map[s.r][s.c] = s;
			} else if (s.z > map[s.r][s.c].z) { // 크기 비교 후 map[s.r][s.c] 삭제
				list.remove(map[s.r][s.c]);
				map[s.r][s.c] = s;
			} else { // 크기 비교 후 s 삭제
				list.remove(s);
			}
		}
	}

	static class Shark {
		// d: 0 ~ 3
		int r, c, s, d, z;

		Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
