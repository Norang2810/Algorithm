import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * 
		 * 문제 세 정수 A, B, C가 주어진다. 이때, 두 번째로 큰 정수를 출력하는 프로그램을 작성하시오.
		 * 
		 * 입력 첫째 줄에 세 정수 A, B, C가 공백으로 구분되어 주어진다. (1 ≤ A, B, C ≤ 100)
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int [] arr = new int[3];
		
		for(int i=0; i<arr.length;i++) {
			arr [i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(arr[1]);
	}

}