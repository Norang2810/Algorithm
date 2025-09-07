import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int [] arr = new int[5];
		int sum =0;
		
		for (int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		int avg = sum / 5;
		int mid = arr[2];
		
		
		System.out.println(avg);
		System.out.println(mid);
		
		sc.close();
		

	}

}
