#include <string>
#include <vector>
#include <climits>
#include <iostream>
using namespace std;
int Min = INT_MAX;
int Weak[16];
int visit[16];
int check[201];
int wsize;
int Dist[9];
int dsize;
int N;

void dfs(int index,int suc,int target){
    if(suc == target){
        Min = min(dsize - 1 - index ,Min );
        return;
    }
    if(index < 0) return;
    
    for(int i = 0; i<wsize;i++){
        if(visit[i] == 1) continue;
        
        visit[i] = 1;
        vector<int> v;
        v.push_back(i);
        int start = Weak[i];
        
        for(int j = 0; j<Dist[index];j++){
            start = (start + 1)%N;
            if(check[start] != -1 and visit[check[start]] == 0){
                v.push_back(check[start]);
                visit[check[start]] = 1;
            }
        }
        dfs(index - 1, suc + v.size(), target);
        
        for(auto c:v)
            visit[c] = 0;
        
    }
}


int solution(int n, vector<int> weak, vector<int> dist) {
    int answer = 0;
    N = n;
    wsize = weak.size();
    dsize = dist.size();
    for(int i = 0; i<= n; i++)
        check[i] = -1;
    for(int i = 0; i<wsize;i++){
        Weak[i] = weak[i];
        check[Weak[i]] = i;
    }
    for(int i = 0; i<dsize;i++)
        Dist[i] = dist[i];
    
    dfs(dsize - 1, 0, wsize);
    answer = Min;
    if(answer == INT_MAX) answer = -1;
    
    
    
    return answer;
}