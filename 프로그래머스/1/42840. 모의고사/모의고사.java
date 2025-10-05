import java.util.ArrayList;
import java.util.List;

public class Solution {

	public int[] solution(int[] answers) {

		int[] p1 = { 1, 2, 3, 4, 5 }; // 5개씩 반복
		int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 }; // 8개씩 반복
		int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }; // 10개씩 반복
		int[] score = { 0, 0, 0 }; // 각 수포자들의 점수

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == p1[i % p1.length])
				score[0]++;
			if (answers[i] == p2[i % p2.length])
				score[1]++;
			if (answers[i] == p3[i % p3.length])
				score[2]++;
		}
				
		// 최대 점수 구하기
		int max = Math.max(score[0], Math.max(score[1], score[2]));
		
		
		List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) result.add(i + 1); // 인덱스+1 = 수포자 번호
        }
        
		return result.stream().mapToInt(i->i).toArray();
	}

}
