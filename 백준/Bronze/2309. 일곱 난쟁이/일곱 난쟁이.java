import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int [] arr = new int [9];
	static int [] result = new int [7];
	static boolean found = false;
	
	public static void main(String[] args) {
		// Combination 사용해서 풀기
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Combination(0,0);
		
		sc.close();
	}
	
	
	static void Combination(int idx,int depth) {
		
		if (found) return; //  정답 찾은 경우 중단
		
		if(depth == 7) { // 7명 뽑았을 때 (조합 완성)
			int sum = 0;
			for(int h : result) sum+= h;
			if(sum==100) {
				Arrays.sort(result);
				for(int h : result) {
					System.out.println(h);
				}
				found = true;
			}
			return;
		}
		if(idx >= 9) return; //더 이상 뽑을 인덱스가 없을 때 중단
		
		result[depth] = arr[idx]; 
	    Combination(idx + 1, depth + 1); // 선택
	    Combination(idx + 1, depth);     // 선택 안함
		
	}

}
