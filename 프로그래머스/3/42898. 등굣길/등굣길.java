class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] grid = new int[n+1][m+1];
        for(int[] p : puddles)
            grid[p[1]][p[0]] = -1;
        
        grid[1][1] = 1;
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=m ; j++){
                if(i==1 && j==1)
                    continue;
                if(grid[i][j] == -1){
                    grid[i][j] = 0;
                    continue;
                }
                grid[i][j] = (grid[i][j-1] + grid[i-1][j]) % 1000000007;
            }
        }
        return grid[n][m];
    }
}