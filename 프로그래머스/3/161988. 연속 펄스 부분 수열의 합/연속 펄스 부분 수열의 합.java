class Solution {
    static long max;
    public long solution(int[] sequence) {
        long answer = 0;
        int n = sequence.length;
        max = Long.MIN_VALUE;
        
        int[] v1 = new int[n];
        int[] v2 = new int[n];
        long[] dp = new long[n];
        
        int x1 = 1;
        int x2 = -1;
        for(int i = 0; i < n; i++){
            v1[i] = sequence[i] * x1;
            v2[i] = sequence[i] * x2;
            x1 *= -1; x2 *=-1;
        }
        maxValue(v1, dp); maxValue(v2, dp);
        
        answer = max;
        
        return answer;
    }
    static void maxValue(int[] v, long[] dp){
        dp[0] = v[0];
        max = Math.max(max, v[0]);
        for(int i = 1; i < v.length; i++){
            dp[i] = Math.max(dp[i-1] + v[i], v[i]);
            max = Math.max(max,dp[i]);
        }
    }
        
}