#include <string>
#include <vector>
#include <iostream>
using namespace std;

struct xy{
    int s;
    int e;
};

int map[18];
xy edge[18];
int edge_size;
int visit[18];

int Max = 0;
void dfs(int wolf, int meat){
    if(wolf >= meat)
        return;
    
    Max = max(meat, Max);
    
    for(int i = 0; i < edge_size; i++){
        if(visit[edge[i].s] == 1 and visit[edge[i].e] == 0){
            visit[edge[i].e] = 1;
    
            if(map[edge[i].e] == 1)
                dfs(wolf + 1, meat);
            else
                dfs(wolf,meat + 1);
            visit[edge[i].e] = 0;
        }
    }
    
}

int solution(vector<int> info, vector<vector<int>> edges) {
    int answer = 0;
    for(int i = 0; i<info.size(); i++)
        map[i] = info[i];
    for(int i = 0;i<edges.size(); i++){
        edge[i].s = edges[i][0];
        edge[i].e = edges[i][1];
    }
    edge_size = edges.size();
    visit[0] = 1;
    dfs(0,1);
    answer = Max;
    
    return answer;
}