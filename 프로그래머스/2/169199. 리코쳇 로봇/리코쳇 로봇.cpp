#include <string>
#include <vector>
#include <queue>
using namespace std;

int dx[] = {1,-1,0,0};
int dy[] = {0,0,-1,1};
int visit[101][101];

struct xy{
    int x;
    int y;
    int lev;
};

int solution(vector<string> board) {
    int answer = -1;
    
    queue<xy> q;
    int suc = 0;
    
    for(int i=0;i<board.size();i++)
        for(int j=0;j<board[0].size();j++)
            if(board[i][j] =='R'){
                q.push({i,j,0});
                board[i][j] =' ';
                break;
            }
    
    while(q.size()!=0){
        xy a = q.front();
        q.pop();

        for(int k=0;k<4;k++){
            int nx = a.x + dx[k];
            int ny = a.y +dy[k];
            
            if(nx<0 or nx >= board.size() or ny <0 or ny>= board[0].size())
                continue;
            
            while(board[nx][ny] != 'D' ){
                nx = nx + dx[k];
                ny = ny +dy[k];
                if(nx<0 or nx >= board.size() or ny <0 or ny>= board[0].size())
                    break;
            }
            nx = nx - dx[k];
            ny = ny - dy[k];
            
            if(visit[nx][ny])
                continue;
            
            visit[nx][ny] = 1;
            
            if(board[nx][ny] == 'G'){
                suc = 1;
                answer = a.lev + 1;
                break; 
            }
            q.push({nx,ny,a.lev+1});
        }
        if(suc)
            break;
    }
    
    return answer;
}