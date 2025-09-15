import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
		
	public static int [][] paper ;
	
	public static int GRAY = 0;
	public static int WHITE = 0;
	public static int BLACK = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N =Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		
		StringTokenizer st ;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() + " ");
			for (int j = 0; j < N; j++) {
				paper[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		
		partition(0,0,N);
		
		
		System.out.println(GRAY);
		System.out.println(WHITE);
		System.out.println(BLACK);
	}
	//전체 -> 부분을 재귀로 반복
	public static void partition(int row,int col,int size) {
		
		if(colorCheck(row,col,size)) {
			if(paper[row][col] == -1 ) {
				GRAY++;
			}else if(paper[row][col] == 0) {
				WHITE++;
			}else {
				BLACK++;
			}
			return;
		}
		
		int newSize =size /3 ;
		
		partition(row, col, newSize);								// 왼쪽 위
		partition(row, col + newSize, newSize);						// 중앙 위
		partition(row, col + 2 * newSize, newSize);					// 오른쪽 위
		
		partition(row + newSize, col, newSize);						// 왼쪽 중간
		partition(row + newSize, col + newSize, newSize);			// 중앙 중간
		partition(row + newSize, col + 2 * newSize, newSize);		// 오른쪽 중간
		
		partition(row + 2 * newSize, col, newSize);					// 왼쪽 아래
		partition(row + 2 * newSize, col + newSize, newSize);		// 중앙 아래
		partition(row + 2 * newSize, col + 2 * newSize, newSize);	// 오른쪽 
	}
	
	public static boolean colorCheck(int row,int col,int size) {
		int color = paper[row][col];
		
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if(color != paper[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
