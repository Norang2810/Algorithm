import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 세수 정렬
		
		Scanner sc = new Scanner(System.in);
		
		int [] arr = new int [3];
		
		for(int i=0; i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
        
        for(int i=0; i <arr.length;i++){
		System.out.print(arr[i] + " ");
            }
	}

}
