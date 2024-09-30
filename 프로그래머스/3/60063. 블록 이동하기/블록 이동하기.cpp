#include <string>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

struct xy{
    int x;
    int y;
   
};
struct Point{
    xy x1;
    xy x2;
    int state;
    int cnt;
};


int map[101][101];
int visit[101][101][2];
int row;
int col;

int dx[] = {1,0,-1,0};
int dy[] = {0,1,0,-1};

int lox[][4] = {{1,1,-1,-1},{0,0,0,0}};
int loy[][4] = {{0,0,0,0},{1,1,-1,-1}};

xy decide(xy A, xy B){
    if(A.x == B.x)
        return (A.y < B.y ? A : B);
    return (A.x < B.x ? A : B);
}
bool check(xy A, xy B){
    if(A.x == row -1 && A.y == col-1) return true;
    if(B.x == row -1 && B.y == col-1) return true;
    return false;
}

int solution(vector<vector<int>> board) {
    int answer = INT_MAX;
    row = board.size();
    col = board[0].size();
    for(int i =0; i< board.size();i++)
        for(int j = 0; j<board[0].size(); j++)
            map[i][j]  = board[i][j];
    
    Point p = {{0,0}, {0,1},0,0};
    
    queue<Point> q;
    q.push(p);
    
    int flag = 0;
    while(!q.empty()){
        Point x = q.front(); q.pop();
        for(int i = 0; i<8; i++){
            if(i < 4){
                int nx1 = x.x1.x + dx[i];
                int ny1 = x.x1.y + dy[i];
                int nx2 = x.x2.x + dx[i];
                int ny2 = x.x2.y + dy[i];
                
                if(nx1 < 0 || nx1 >= row || ny1 < 0 || ny1 >= col) continue;
                if(nx2 < 0 || nx2 >= row || ny2 < 0 || ny2 >= col) continue;
                if(map[nx1][ny1] == 1 || map[nx2][ny2] == 1)continue;
                
                xy A = {nx1,ny1};
                xy B = {nx2,ny2};
                xy C = decide(A,B);
                if(visit[C.x][C.y][x.state] == 1) continue;
                visit[C.x][C.y][x.state] = 1;
                
                if(check(A,B)){
                    answer = min(answer,x.cnt + 1);
                    flag = 1;
                    continue;
                } 
                q.push({A,B,x.state,x.cnt + 1});
                
            }
            else{
                xy a,b;
                if(i % 2 == 0){
                    a = x.x1;
                    b = x.x2;
                }
                else{
                    b = x.x1;
                    a = x.x2;
                }
                int chnx = a.x + lox[x.state][i-4];
                int chny = a.y + loy[x.state][i-4];
                int nx = b.x + lox[x.state][i-4];
                int ny = b.y + loy[x.state][i-4];
                
                int state = (x.state + 1) % 2;
                if(chnx < 0 || chnx >= row || chny < 0 || chny >= col) continue;
                if(nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                if(map[chnx][chny] == 1 || map[nx][ny] == 1)continue;
                
                xy A = b;
                xy B = {nx,ny};
                xy C = decide(A,B);
                if(visit[C.x][C.y][state] == 1) continue;
                visit[C.x][C.y][state] = 1;
                
                if(check(A,B)){
                    answer = min(answer,x.cnt + 1);
                    flag = 1;
                    continue;
                } 
                q.push({A,B,state,x.cnt + 1});
                    
            }
        }
        if(flag == 1) break;
    }
    
    return answer;
}