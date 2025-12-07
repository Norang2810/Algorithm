
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();


        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

 
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                return key;
            }
        }

        return ""; // 문제 조건상 여기 오면 안 됨
    }
}