import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];

        for (int i=0; i<N;i++){
            A[i] = sc.nextInt();
        }

        int max = A[0];
        int min = A[0];

        for (int i=0;i<N;i++) {
            if (A[i]< min) min = A[i];
            if (A[i] > max) max = A[i];
            }
        System.out.print(min + " " + max);
    }
}
