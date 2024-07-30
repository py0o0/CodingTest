#include <string>
#include <vector>

using namespace std;

int visit[8];
int Max;
vector<vector<int>> d;
void dfs(int size, int cnt,int k){
    for(int i=0;i<size;i++){
        if(!visit[i] and k >= d[i][0]){
            visit[i] = 1;
            dfs(size, cnt+1,k-d[i][1]);
            visit[i] = 0;
        }
    }
    Max = max(cnt,Max);
}

int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;
    d = dungeons;
    dfs(d.size(),0,k);
    answer = Max;
    return answer;
}