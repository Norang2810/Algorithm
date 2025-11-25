import java.util.*;

class Solution {
    static class Task {
        String name;
        int start;
        int playtime;
        
        Task(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
    
    public List<String> solution(String[][] plans) {
        List<Task> list = new ArrayList<>();
        
        // 1. Task 객체로 변환
        for (String[] p : plans) {
            String name = p[0];
            int start = toMinute(p[1]);
            int play = Integer.parseInt(p[2]);
            list.add(new Task(name, start, play));
        }
        
        // 2. 시작 시간 기준 정렬
        Collections.sort(list, (a, b) -> a.start - b.start);

        Stack<Task> stack = new Stack<>();
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Task cur = list.get(i);

            // 마지막 과제가 아닌 경우 → 다음 과제 시작 전까지 여유 시간 계산
            if (i < list.size() - 1) {
                Task next = list.get(i + 1);
                int available = next.start - cur.start;

                // 1️⃣ 현재 과제를 끝낼 수 있는 경우
                if (cur.playtime <= available) {
                    answer.add(cur.name);
                    available -= cur.playtime;

                    // 2️⃣ 남은 시간 동안 멈춰둔 과제들 처리
                    while (!stack.isEmpty() && available > 0) {
                        Task paused = stack.pop();
                        if (paused.playtime <= available) {
                            answer.add(paused.name);
                            available -= paused.playtime;
                        } else {
                            paused.playtime -= available;
                            stack.push(paused);
                            break;
                        }
                    }
                } 
                // 3️⃣ 현재 과제를 끝낼 수 없는 경우 → 남은 시간 줄이고 stack에 저장
                else {
                    cur.playtime -= available;
                    stack.push(cur);
                }
            } 
            // 마지막 과제라서 바로 끝낼 수 있음
            else {
                answer.add(cur.name);
            }
        }

        // 4. 모든 정규 과제 처리 후, 스택에 남은 과제 마저 끝내기
        while (!stack.isEmpty()) {
            answer.add(stack.pop().name);
        }

        return answer;
    }

    // "HH:MM" → 분(minutes) 변환
    private int toMinute(String t) {
        String[] arr = t.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}
