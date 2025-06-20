import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //sc 변수명을 가진 scanner 선언
        String S = sc.next();   //문자열 s입력
        int [] alpha = new int[26];  // 정수형 알파뱃 배열은 a~z 까지 이므로 배열크기 26으로 선언

        Arrays.fill(alpha,-1);  //알파벳 배열을 -1로 초기화

        for (int i=0; i<S.length();i++){
            int index = S.charAt(i) - 'a';
            if (alpha[index] == -1){
                alpha[index] = i;
            }
        }
        for (int i=0; i<26;i++){
            System.out.print(alpha[i]+ " ");
        }
    }
}
