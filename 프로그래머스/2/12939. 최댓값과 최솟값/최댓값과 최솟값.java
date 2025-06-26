class Solution {
    public String solution(String s) {
        String [] parts = s.split(" ");
            
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String part : parts){
            int num = Integer.parseInt(part);
            if(num<min) min = num;
            if(num>max) max = num;
        }
        
        return min + " " + max;
    }
}


/*
1.공백을 기준으로 문자열을 나눈다.
문자열 리스트 = s 를 기준으로 split

2.문자열 리스트를 => 정수형 리스트로 변환
정수 리스트 = 빈 리스트
반복 (문자열 리스트의 각 원소 str에 대해)
    정수 리스트에 정수로 변환된 str추가
    
3.최솟값 ,최댓값 구하기
min = 정수리스트의 첫번째 값
max = 정수리스트의 첫번째 값


반복(정수리스트의 각 숫자 num 에 대해 )
    만약 num < min 이면 min = num
    만약 num < max 이면 max = num

4. 결과 문자열 만들기
결과는 min + " " + max

5.결과 반환
return 결과
*/