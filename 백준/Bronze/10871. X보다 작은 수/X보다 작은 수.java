import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int value = sc.nextInt();
            if (value < X) {
                System.out.print(value + " ");
            }
        }
    }
}