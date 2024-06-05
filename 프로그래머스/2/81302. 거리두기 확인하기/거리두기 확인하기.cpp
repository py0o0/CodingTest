#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

int dx[] = {1,-1,0,0};
int dy[] = {0,0,1,-1};
int visit[6][6];
struct xy{
    int x;
    int y;
    int cnt;
};

bool bfs(vector<string> map,int i,int j){
    queue<xy> q;
    q.push({i,j, 0});
    visit[i][j] = 1;
    
    while(q.size()!=0){
        int x = q.front().x;
        int y = q.front().y;
        int cnt = q.front().cnt;
        if(cnt > 1)
            break;
        
        q.pop();
        for(int k=0;k<4;k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx < 0 or nx >= map.size() or ny < 0 or ny >= map[0].size() or visit[nx][ny])
                continue;
            visit[nx][ny] = 1;
            if(map[nx][ny] == 'P')
                return false;
            if(map[nx][ny] == 'O')
                q.push({nx,ny, cnt + 1});
        }
    }
    
    return true;
}

vector<int> solution(vector<vector<string>> places) {
    vector<int> answer;
    for(int i=0;i<places.size();i++){
        bool suc = true;
        
        for(int j=0;j<5;j++)
            for(int k=0;k<5;k++)
                visit[j][k] = 0;
        
        for(int j=0;j<places[i].size();j++){
            for(int k=0;k<places[i][j].size();k++){
                if(places[i][j][k] == 'P')
                    suc = bfs(places[i],j,k);
                if(!suc)
                    break;
            }
            if(!suc)
                break;
        }
        if(!suc)
            answer.push_back(0);
        else
            answer.push_back(1);
    }
    return answer;
}