import java.util.*;
class Solution {
    public int solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        
        for(char c : my_string.toCharArray()){
            if(Character.isDigit(c)){
                cnt += c-'0';
            }                
        }
        
        return cnt;
    }
}