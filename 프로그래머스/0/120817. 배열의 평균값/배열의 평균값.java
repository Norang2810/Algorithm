class Solution {
    public double solution(int[] numbers) {
        double sum = 0;
        double avg = 0;
        
        for(int i=0;i<numbers.length;i++){
            sum += numbers[i];
        }
        avg = sum / numbers.length;        
        
        return avg;
    }
}