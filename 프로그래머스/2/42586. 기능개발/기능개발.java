import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        // 배포까지 필요한 날짜 Queue에 담기
        for (int i = 0; i < progresses.length; i++) {
            // 필요한 날짜를 속도로 나눈 나머지가 0이면 당일 배포 가능
            if ((100 - progresses[i]) % speeds[i] == 0) {
                queue.offer((100 - progresses[i]) / speeds[i]);
            } else { // 나머지가 0이 아니면 다음날 배포해야 함
                queue.offer(((100 - progresses[i]) / speeds[i]) + 1);
            }
        }

        // 첫 번째 기능 배포 날짜
        int now = queue.poll();
        int count = 1;

        // queue가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 현재 배포 날짜가 queue의 다음 기능의 배포날짜보다 크면 추가
            if (now >= queue.peek()) {
                count++;
                queue.poll();
            } else { // 현재 배포 날짜가 queue의 다음 기능 날짜보다 작으면
                answer.add(count); // count answer에 담기
                count = 1; // count 초기화
                now = queue.poll(); // 다음 배포날짜
            }
        }
        answer.add(count); // 마지막 count 담기

        return answer.stream().mapToInt(i -> i).toArray();
    }
}