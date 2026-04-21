/*
x기준으로 자르기
사전순 정렬

빈 문자열은 배열에 반환하지않기 -> 리스트만들어서 따로 빈문자열 아닌것만 담기
*/

import java.util.*;
class Solution {
    public String[] solution(String myString) {
        String[] arr = myString.split("x");
        List<String> list = new ArrayList<>();
        
        for(String str : arr){
            if(!str.equals("")){
                list.add(str);
            }
        }
        
        Collections.sort(list);
        
        return list.toArray(new String[0]);
    }
}