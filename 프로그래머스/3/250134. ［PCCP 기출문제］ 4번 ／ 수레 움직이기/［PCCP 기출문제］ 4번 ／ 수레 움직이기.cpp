#include <string>
#include <vector>
#include <climits>
using namespace std;

struct xy{
    int x;
    int y;
};
int Min = INT_MAX;
int n,m;

int visit[5][5][2];
int map[5][5];
int dx[] = {1,-1,0,0};
int dy[]  = {0,0,1,-1};
void dfs(xy R, xy B, int sta,int cnt,int turn, int sucR, int sucB){
    if(R.x < 0||R.x >= n || R.y < 0 || R.y >= m) return;
    if(B.x < 0||B.x >= n || B.y < 0 || B.y >= m) return;
    if(R.x == B.x and R.y == B.y) return;
    
    int nx = (sta == 0 ? R.x : B.x);        //이전에 0을 움직임 = 빨강
    int ny = (sta == 0 ? R.y : B.y);
    
    if(map[nx][ny] == 5) return;
    if(visit[nx][ny][sta] == 1) return;
    
    if(sta == 1) //파란검사
        if(map[nx][ny] == 4) sucB = 1;
    
    if(sta == 0) //빨간 검사
        if(map[nx][ny] == 3) sucR = 1;
    
    if(cnt%2 == 1) turn++;
    if(sucR == 1 and sucB == 1){
        Min = min(Min,turn); return;
    }
    
    
    visit[nx][ny][sta] = 1;
    
    if(sta == 1){//파랑움직임, 빨강차례
        if(sucR == 1){//빨이미 되있으면 파랑움직임
            for(int i = 0; i<4; i++)
                dfs(R, {B.x + dx[i], B.y + dy[i]}, 1,0,turn + 1, sucR,sucB);//파랑움직임
        }
        else{
            for(int i = 0; i<4; i++)
                dfs({R.x + dx[i], R.y + dy[i]}, B, 0,cnt + 1,turn, sucR,sucB);
        }

    }
    else{
        if(sucB == 1){
            for(int i = 0; i<4; i++)
                 dfs({R.x + dx[i], R.y + dy[i]}, B, 0,0,turn + 1, sucR,sucB);
        }
        else{
            for(int i = 0; i<4; i++)
                dfs(R, {B.x + dx[i], B.y + dy[i]}, 1,cnt + 1,turn, sucR,sucB);
        }

    }
    visit[nx][ny][sta] = 0;
    
}

int solution(vector<vector<int>> maze) {
    int answer = 0;
    
    xy RT,BT,RS,BS;
    n = maze.size();
    m = maze[0].size();
    for(int i = 0; i< maze.size(); i++){
        for(int j = 0; j<maze[0].size(); j++){
            if(maze[i][j] == 1) RS = {i,j};
            else if(maze[i][j] == 2) BS = {i,j};
            else if(maze[i][j] == 3) RT = {i,j};
            else if(maze[i][j] == 4) BT = {i,j};
            map[i][j] = maze[i][j];
        }
    }
    
    dfs(RS,BS,0,0,0,0,0);
    
    for(int i = 0; i<5;i++)
        for(int j = 0; j<5;j++)
            for(int k = 0 ;k<2;k++)
                visit[i][j][k] = 0;
    
    
    dfs(RS,BS,1,0,0,0,0);
    answer = (Min != INT_MAX ? Min : 0);
    return answer;
}