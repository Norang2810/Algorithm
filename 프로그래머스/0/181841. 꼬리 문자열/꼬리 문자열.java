class Solution {
    public String solution(String[] str_list, String ex) {
        String result = "";
        
        for(String s : str_list){
            if(!s.contains(ex)){
                result+=s;
            }
        }
        
        return result;
    }
}