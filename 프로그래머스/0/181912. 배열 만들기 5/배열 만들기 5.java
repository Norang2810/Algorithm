import java.util.*;

public class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> result = new ArrayList<>();

        for (String str : intStrs) {
            String sub = str.substring(s, s + l); // 부분 문자열 자르기
            int num = Integer.parseInt(sub);     // 정수 변환
            if (num > k) {
                result.add(num);                 // 조건 만족 시 리스트에 추가
            }
        }

        // 리스트를 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
