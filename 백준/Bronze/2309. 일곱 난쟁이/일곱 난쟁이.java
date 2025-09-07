import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int [] arr = new int[9];
		int total = 0;
		
		
		//9명 키 입력
		
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		
		// 0이라 설정하면 키가 0일수도있어서 음수값으로 초기설정
		int fake1 = -1 , fake2 = -1;
			
		//2중 for문 으로 가짜 2명찾기 outer 사용해서 total 100 이면 한번에 2중 for문 나오기
		outer:
		for (int i = 0; i < 9; i++) {
			for (int j = i+1; j < 9; j++) {
				if (total - arr[i] - arr[j] == 100) {
					fake1 = arr[i];
					fake2 = arr[j];
					break outer;
				}
			} 
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < 9; i++) {
			if(arr[i] == fake1 || arr[i] == fake2) continue;
			System.out.println(arr[i]);
		}
		
	}

}
