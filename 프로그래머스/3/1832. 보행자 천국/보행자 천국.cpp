#include <vector>
#include <iostream>
using namespace std;

int MOD = 20170805;
int solution(int m, int n, vector<vector<int>> city_map) {
    int answer = 0;
    
    int map[502][502] = {{0,},};
    int dp[502][502] = {{0,},};
    for(int i = 0; i<m;i++)
        for(int j = 0; j<n;j++)
            map[i + 1][j + 1] = city_map[i][j];
    
    dp[1][1]= 1;
    for(int i = 2; i<=n; i++){
        if(map[1][i] == 1) break;
        dp[1][i] = dp[1][i-1];
    }
    for(int i = 2; i<=m; i++){
        if(map[i][1] == 1) break;
        dp[i][1] = dp[i-1][1];
    }
    
    for(int i = 2; i<=m; i++){
        for(int j = 2; j<=n; j++){
            if(map[i][j] == 1) continue;
            
            int x = dp[i][j - 1];
            if(map[i][j - 1] == 2) {
                int cnt = 1;
                while(map[i][j - cnt] == 2) cnt++;
                x = dp[i][j - cnt];
            }
            int y = dp[i - 1][j];
            if(map[i - 1][j] == 2) {
                int cnt = 1;
                while(map[i - cnt][j] == 2) cnt++;
                y = dp[i - cnt][j];
            } 
        
            dp[i][j] = (x+y) % MOD;
        }
    }
   
    
    answer = dp[m][n] % MOD;
    return answer;
}