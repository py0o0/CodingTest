#include <string>
#include <vector>
#include <climits>
#include <queue>
#include <iostream>
using namespace std;
struct xy{
    int x;
    int y;
};
struct seek{
    int x;
    int y;
    int cnt;
};
vector<xy> in[7];
vector<int> index;
xy start;
int Min = INT_MAX;
int visit[7];
int map[4][4];
int bfs_visit[4][4];

int dx[] = {1,-1,0,0};
int dy[] = {0,0,1,-1};

int bfs(xy a, xy b){
    
    if(a.y == b.y && b.x == a.x) return 0;
    for(int i = 0;i<4;i++)
        for(int j =0; j<4;j++)
            bfs_visit[i][j] = 0;
    
    queue<seek> q;
    q.push({a.x,a.y,0});
    bfs_visit[a.x][a.y] = 1;
    
    while(q.size() != 0){
        seek x =q.front(); q.pop();
        for(int i = 0; i<8;i++){
            if(i < 4){
                int nx = x.x + dx[i];
                int ny = x.y + dy[i];
                if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
                if(bfs_visit[nx][ny] == 1) continue;
                bfs_visit[nx][ny] = 1;
                if(b.x == nx and b.y == ny)
                    return x.cnt + 1;

                q.push({nx,ny,x.cnt+1});
            }
            else{
                int nx = x.x + dx[i-4];
                int ny = x.y + dy[i-4];
                if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
                
                if(map[nx][ny] == 0){
                    while(map[nx][ny] == 0){
                        nx += dx[i-4];
                        ny += dy[i-4];
                        if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) break;
                    }
                    if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4){
                        nx -= dx[i-4];
                        ny -= dy[i-4];
                    }
                }
                if(bfs_visit[nx][ny] == 1) continue;
                bfs_visit[nx][ny] = 1;
                if(b.x == nx and b.y == ny)
                    return x.cnt + 1;

                q.push({nx,ny,x.cnt+1});
                
            }
        }
    }
    return 0;
}

void dfs(int cur, vector<int> v,vector<xy> next){
    
    if(cur >= v.size()){
        int dis = 0;
        xy prev = start;
        for(auto x:next){
            dis += bfs(prev,x);
            map[x.x][x.y] = 0;
            prev = x;
        }
        
        for(int i = 1; i<7;i++){
            if(in[i].size()==0) continue;
            map[in[i][0].x][in[i][0].y] = i;
            map[in[i][1].x][in[i][1].y] = i;
        }
        
        dis += next.size();
        
        Min = min(Min,dis);
        
        return;
    }
    
    next.push_back(in[v[cur]][0]);
    next.push_back(in[v[cur]][1]);
    dfs(cur+1,v,next);
    next.pop_back();
    next.pop_back();
        
    next.push_back(in[v[cur]][1]);
    next.push_back(in[v[cur]][0]);
    dfs(cur+1,v,next);
    next.pop_back();
    next.pop_back();
    
}

void combi(vector<int> v){
    if(v.size() == index.size()){
        vector<xy> next;
        dfs(0,v,next);
        return;
    }
    for(int i = 0; i<index.size();i++){
        if(visit[index[i]]) continue;
        visit[index[i]] = 1;
        v.push_back(index[i]);
        combi(v);
        v.pop_back();
        visit[index[i]] = 0;
    }
}

int solution(vector<vector<int>> board, int r, int c) {
    int answer = 0;
    
    start = {r,c};
    for(int i = 0; i<4;i++)
        for(int j = 0; j<4;j++){
            map[i][j] = board[i][j];
            if(map[i][j]!= 0)
                in[map[i][j]].push_back({i,j});
            
        }
    for(int i = 1; i<7; i++)
        if(in[i].size()!=0)
            index.push_back(i);
    
    vector<int> v;
    combi(v);
    answer = Min;
    
    return answer;
}