class Solution {
    public int solution(String myString, String pat) {
        
        String converted = myString
            .replace("A","X")
            .replace("B","A")
            .replace("X","B");
        
        return converted.contains(pat) ? 1:0;
    }
}