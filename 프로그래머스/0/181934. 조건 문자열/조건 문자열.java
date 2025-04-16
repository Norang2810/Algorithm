class Solution {
    public int solution(String ineq, String eq, int n, int m) {

        if (n < m) {
            return ineq.equals("<") ? 1 : 0;
        } else if (n > m) {
            return ineq.equals(">") ? 1 : 0;
        } else {
            return eq.equals("=") ? 1 : 0;
        }
    }
}
