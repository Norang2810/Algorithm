function solution(arr, queries) {
    for(let i=0; i<queries.length; i++){
        let [s,e] = queries[i];
        for(let j=0; j<=e; j++){
            if(j>=s && j<=e){
               arr[j]++;
            }
        }
    }
    return arr;
}