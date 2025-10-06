import java.io.*;
import java.util.*;
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = Integer.MAX_VALUE;
        
        int[][] dp = new int[151][151];
        for(int i = 0; i < 151; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        
        xy[] v = new xy[problems.length];
        
        int targetA = 0;
        int targetB = 0;
        for(int i = 0; i < problems.length; i++){
            v[i] = new xy();
            v[i].needA = problems[i][0];
            v[i].needB = problems[i][1];
            v[i].plusA = problems[i][2];
            v[i].plusB = problems[i][3];
            v[i].cost = problems[i][4];
            
            targetA = Math.max(targetA, v[i].needA);
            targetB = Math.max(targetB, v[i].needB);
        }
        if(targetA < alp) targetA = alp;
        if(targetB < cop) targetB = cop;
        dp[alp][cop] = 0;
        
        for(int i = alp; i <= targetA; i++){
            for(int j = cop; j <= targetB; j++){
                if(i + 1 <= targetA)
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                if(j + 1 <= targetB)
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                
                for(xy x : v){
                    if(i < x.needA || j < x.needB) continue;
                    
                    int k = Math.min(i + x.plusA, targetA);
                    int l = Math.min(j + x.plusB, targetB);
                    
                    dp[k][l] = Math.min(dp[k][l], dp[i][j] + x.cost);
                }
            }
        }
        
        answer = dp[targetA][targetB];
        
        return answer;
    }
    static class xy{
        int needA, needB, plusA, plusB, cost;
    }
}