class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        int idx = 0;
        //n번째 이후 원소들 먼저 (덩어리)
        for(int i=n;i<num_list.length;i++){
                answer[idx++]= num_list[i];
        }
        //n번째 이전 원소들 나중에 (덩어리)
        for(int i=0;i<n;i++){
            answer[idx++] = num_list[i];
        }
        return answer;
    }
}