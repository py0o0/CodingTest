#include <string>
#include <vector>
#include <iostream>
using namespace std;
struct Road{
    vector<int> next;
    int in;
};
int Do,Ma,Eh;
Road map[1000001];
int visit[1000001];

void Find_graph(int n){
    
    while(1){
        if(map[n].next.size() == 0){
            Ma++; return;
        }
        if(map[n].next.size() > 1){
            Eh++; return;
        }
        if(visit[n] == 1){
            Do++; return;
        }
        visit[n] = 1;
        n = map[n].next[0];
        
    }
    
}

vector<int> solution(vector<vector<int>> edges) {
    vector<int> answer;
    
    for(auto e : edges){
        map[e[0]].next.push_back(e[1]);
        map[e[1]].in++;
    }
    
    int root = 0;
    for(auto e : edges){
        if(map[e[0]].in == 0 and map[e[0]].next.size() > 1)
            root = e[0];
    }
    
    for(auto ver : map[root].next)
        Find_graph(ver);
    answer.push_back(root); answer.push_back(Do); answer.push_back(Ma); answer.push_back(Eh);
    return answer;
}