import java.util.*;

public class Solution {
    public String solution(String my_string, int[] indices) {
        
        Set<Integer> removeSet = new HashSet<>();
        for (int i : indices) {
            removeSet.add(i);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            if (!removeSet.contains(i)) {
                result.append(my_string.charAt(i));
            }
        }

        return result.toString();
    }
}
