import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String str =sc.next().toUpperCase();

        int [] alphabet =   new int[26];

        for (int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            alphabet[ch - 'A']++;
        }    


        int max = -1;
        char result = '?';


        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > max) {
                max = alphabet[i];
                result = (char)(i + 'A');
            } else if (alphabet[i] == max) {
                result = '?';                    // 최빈값 중복 처리
            }
        }

        System.out.println(result);
    }
}