#include <string>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

struct xy{
    int x;
    int y;
    int sum;
    int dir;
};

struct cmp{
    bool operator()(xy x, xy y){
        return x.sum > y.sum;
    }
};
int dp[26][26][5];

int solution(vector<vector<int>> board) {
    int answer = 0;
    int dx[] = {0,1,0,-1,0};
    int dy[] = {0,0,1,0,-1};
    int n = board.size();
    int m = board[0].size();
    priority_queue<xy,vector<xy>,cmp> pq;
    for(int i = 0; i < n;i++)
        for(int j = 0; j<m;j++)
            for(int k = 0; k<5;k++)
                dp[i][j][k] = INT_MAX;
    pq.push({0,0,0,0});
    
    while(!pq.empty()){
        xy x = pq.top();
        pq.pop();
        for(int i = 1; i<5;i++){
            int nx = x.x + dx[i];
            int ny = x.y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >=m) continue;
            if(board[nx][ny] == 1) continue;
 
            
            int plus = 0;
            if(x.dir == 0 || x.dir == i)
                plus = 100;
            else if(x.dir != i)
                plus = 600;
            
            if(dp[nx][ny][i] > x.sum + plus){
                dp[nx][ny][i] = x.sum + plus;
                pq.push({nx,ny,x.sum + plus,i});
            }
        }
 
    }
    answer = INT_MAX;
    for(int i = 1; i<5;i++)
        answer = min(answer,dp[n-1][m-1][i]);
    return answer;
}