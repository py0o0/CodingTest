#include <string>
#include <vector>
#include <climits>
using namespace std;

int dp[151][151];
int solution(int alp, int cop, vector<vector<int>> problems) {
    int answer = 0;
    
    for(int i = 0; i<151; i++)
        fill(dp[i],dp[i]+151,INT_MAX);
    
    dp[alp][cop] = 0;
    
    int max_al = 0, max_co = 0;
    for(auto c : problems){
        max_al = max(c[0],max_al);
        max_co = max(c[1],max_co);
    }
    
    if(max_al < alp)
        max_al = alp;
    if(max_co < cop)
        max_co = cop;

    
    for(int i = alp; i<=max_al;i++){
        for(int j = cop; j<=max_co; j++){
            if(j + 1 <= max_co)
                dp[i][j+1] = min(dp[i][j+1], dp[i][j] + 1);
            if(i + 1 <= max_al)
                dp[i+1][j] = min(dp[i+1][j], dp[i][j] + 1);
            
            for(auto p :  problems){
                if(i >= p[0] and j >= p[1]){
                    int Icur = min(i + p[2], max_al);
                    int Jcur = min(j + p[3], max_co);
                    dp[Icur][Jcur] = min(dp[Icur][Jcur], dp[i][j] + p[4]);
                }
            }
        }
    }
    
    answer = dp[max_al][max_co];
    
    return answer;
}