import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  //변수 N에 과목의 수 입력받기
        int A[] = new int[N]; // 길이가 N인 1차원 배열 선언

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();   //for문을 N번 만큼 돌아 A[i]에 각 과목별 점수 저장하기
        }
        long sum = 0;           //웬만한 코테 문제에서의 계산되는 값 int대신 long선언
        long max = 0;           //웬만한 코테 문제에서의 계산되는 값 int대신 long선언
        for (int i = 0; i < N; i++) {
            if (A[i] > max) {
                max = A[i];             //N번만큼 돌면서 A[i]가 max보다 크면 max = A[i] 값 저장
            }
            sum += A[i];                //N번만큼 for문 돌면서 A[i]에 배열들 누적산 값은 sum
        }
        System.out.print(sum*100.0/max/N); // (A / M*100 + B/M*100 + C/M*100) / 3 => (A+B+C)*100 / M / 3(N)  변환한 점수의 평균
    }
}
//세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다. 일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다.
// 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
// 예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
//세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.