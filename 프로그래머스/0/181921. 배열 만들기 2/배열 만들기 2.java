import java.util.*;

public class Solution {
    public static int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            if (isOnlyZeroAndFive(i)) {
                list.add(i);
            }
        }

        if (list.isEmpty()) {
            return new int[]{-1};
        }

        // 리스트를 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    // "0"과 "5"로만 이루어졌는지 확인
    private static boolean isOnlyZeroAndFive(int num) {
        String str = String.valueOf(num);
        for (char ch : str.toCharArray()) {
            if (ch != '0' && ch != '5') {
                return false;
            }
        }
        return true;
    }
}
