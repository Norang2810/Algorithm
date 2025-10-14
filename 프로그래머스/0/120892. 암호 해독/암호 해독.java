import java.util.*;

class Solution {
    public String solution(String cipher, int code) {
        List<Character> list = new ArrayList<>();
        
        for(int i =0; i<cipher.length();i++){
            if((i+1) % code == 0){
                list.add(cipher.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        
        for(char c : list){
            sb.append(c);
        }
        
        return sb.toString();
    }
}