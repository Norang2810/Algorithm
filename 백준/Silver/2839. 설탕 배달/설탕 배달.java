import java.util.Arrays;
import java.util.Scanner;

// 18 kg <- 두가지 방법
// 1. 15kg 에서 3kg 사용
// 2. 13kg 에서 5kg 사용


public class Main {

	static int N;
	static int [] memoi;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		//초기 데이터 처리
		if(N <= 5) {
			if(N==3 || N==5) System.out.println(1);
			else System.out.println(-1);
			return;
		}
		
		memoi = new int[N+1]; //0 dummy     n kg을 만드는 최소 봉투 수 관리
		Arrays.fill(memoi, 5000); // 최소값 비교 갱신을 위해 충분히 큰 값으로 초기화
		
		//점화식 초기값
		memoi[3] = 1;
		memoi[5] = 1;
		
		//반복문을 통해서 점화식을 적용
		for(int i= 6; i<= N; i++) {
			memoi[i] = Math.min(memoi[i-3] + 1,memoi[i-5] + 1);
		}
		if(memoi[N] >= 5000) System.out.println(-1);
		else System.out.println(memoi[N]);
		sc.close();
	}

}
