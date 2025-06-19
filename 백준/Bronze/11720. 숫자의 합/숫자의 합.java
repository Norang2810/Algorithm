import java.util.Scanner;
public class Main {
    public static void main(String[] args) {            
        //N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

        Scanner sc = new Scanner(System.in); //N값 입력 받기
        int N = sc.nextInt();  //입력 받은 값 정수형 변수 N에 저장

        String sNum = sc.next(); //입력값을 String형 변수 sNum에 저장
        char [] cNum = sNum.toCharArray(); // char[]형 변수로 변환하기

        int sum = 0;

        for (int i=0;i<cNum.length;i++){
            sum += cNum[i] - '0'; //cNum[i]를 정수형으로 변환하면서 sum에 누적산
        }
        System.out.println(sum);
    }
}
