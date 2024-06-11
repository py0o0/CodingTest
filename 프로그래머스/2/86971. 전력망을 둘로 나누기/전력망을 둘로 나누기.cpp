#include <string>
#include <vector>
#include <queue>
#include <climits>
using namespace std;
int Min = INT_MAX;

void bfs(vector<vector<int>> wire, int n,int x){
    queue<int> q;
    int visit[101] ={0,};
    if(x==0){
        q.push(wire[1][0]);
        q.push(wire[1][1]);
        visit[wire[1][0]]=1;
        visit[wire[1][1]]=1;
    }
    else{
        q.push(wire[0][0]);
        q.push(wire[0][1]);
        visit[wire[0][0]]=1;
        visit[wire[0][1]]=1;
    }
    int cnt= 2;
    while(q.size()!=0){
        int a = q.front();
        q.pop();
        for(int i=0;i<wire.size();i++){
            if(i==x)
                continue;
            if(wire[i][0] == a and !visit[wire[i][1]]){
                visit[wire[i][1]] = 1;
                q.push(wire[i][1]);
                cnt++;
            }
            else if(wire[i][1] == a and !visit[wire[i][0]]){
                visit[wire[i][0]] = 1;
                q.push(wire[i][0]);
                cnt++;
            }
        }
    }
    int a = cnt;
    int b = n-cnt;
    if(a<b)
        swap(a,b);
    Min = min(a-b,Min);
}

int solution(int n, vector<vector<int>> wires) {
    int answer = -1;
    for(int i=0;i<wires.size();i++){
        bfs(wires,n,i);
    }
    answer = Min;
    return answer;
}