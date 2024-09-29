#include <string>
#include <vector>

using namespace std;
int map[1001][1001];
int sum[1001][1001];
int solution(vector<vector<int>> board, vector<vector<int>> skill) {
    int answer = 0;
    for(int i = 0; i<board.size();i++)
        for(int j = 0; j<board[0].size(); j++)
            map[i][j] = board[i][j];
    
    for(auto sk : skill){
        int degree = (sk[0] == 1 ? -sk[5] : sk[5]);
        
        int r1 = sk[1], c1 = sk[2];
        int r2 = sk[3], c2 = sk[4];
        
        sum[r1][c1] += degree;
        sum[r1][c2 + 1] -= degree;
        sum[r2 + 1][c2 + 1] += degree;
        sum[r2 + 1][c1] -= degree;
        
    }
    for(int i = 0; i<board.size();i++)
        for(int j = 1; j<board[0].size(); j++)
            sum[i][j] += sum[i][j-1];
    
    for(int i = 1; i<board[0].size();i++)
        for(int j = 0; j<board.size(); j++)
            sum[i][j] += sum[i-1][j];
    

    
    for(int i = 0; i<board.size();i++)
        for(int j = 0; j<board[0].size(); j++)
            if(map[i][j] + sum[i][j]> 0)
                answer++;
            
    return answer;
}