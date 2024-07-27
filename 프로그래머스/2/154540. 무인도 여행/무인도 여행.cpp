#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

struct xy{
    int x;
    int y;
};
int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};

int visit[101][101];

vector<int> solution(vector<string> maps) {
    vector<int> answer;
    
    queue<xy> q;
    for(int i=0;i<maps.size();i++){
        for(int j=0;j<maps[0].size();j++){
            if(maps[i][j] == 'X' or visit[i][j])
                continue;
            int sum = 0;
            visit[i][j] = 1;
            q.push({i,j});
            
            while(q.size() !=0){
                int x = q.front().x;
                int y = q.front().y;
                sum += maps[x][y] - '0';
               
                q.pop();
                
                for(int k=0;k<4;k++){
                    int nx = x+dx[k];
                    int ny = y+dy[k];
                    if(nx >= maps.size() or nx < 0 or ny >= maps[0].size() or ny < 0)
                        continue;
                    if(maps[nx][ny] == 'X' or visit[nx][ny])
                        continue;
                    q.push({nx,ny});
                    visit[nx][ny] = 1;
                }
            }
            answer.push_back(sum);
        }
    }
    if(answer.size()==0)
        answer.push_back(-1);
    sort(answer.begin(),answer.end());
    
    return answer;
}