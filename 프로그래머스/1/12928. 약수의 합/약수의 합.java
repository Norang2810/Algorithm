import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int sqrt = (int)Math.sqrt(n);

        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                arr.add(i);
                if (i != n / i) {
                    arr.add(n / i);
                }
            }
        }

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
