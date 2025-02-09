function solution(targets) {
 
    let answer = 1;
    // 1. 시작점을 기준으로 오름차순
    targets.sort((a,b) => a[0]-b[0]);
    // 2. 구하기
    let [s, e] = [-1, 100000001]; 
 
    for(const target of targets){
        const [t_s, t_b] = target;
        if(t_s >= s && t_b <= e)
            [s, e] = [t_s, t_b];
        else if(t_s < e && t_b > e)
            [s, e] = [t_s, e];
        else {
            answer+=1;
            [s, e] = [t_s, t_b];
        }
    }
    return answer;
}