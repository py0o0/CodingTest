#include <string>
#include <vector>
#include <climits>
#include <queue>
using namespace std;

struct Road{
    int next;
    int t;
};

struct xy{
    int now;
    int now_t;
};
struct cmp{
    bool operator()(xy a, xy b){
        return a.now_t > b.now_t;
    }
};

vector<Road> Roads[100001];
int dp[100001];



void dijkstra(int start){
    dp[start] = 0;
    priority_queue<xy,vector<xy>,cmp> pq;
    pq.push({start, 0});
    while(pq.size() !=0){
        xy x = pq.top(); pq.pop();
        for(Road road : Roads[x.now]){
            if(dp[road.next] > dp[x.now] + road.t){
                dp[road.next] = dp[x.now] + road.t;
                pq.push({road.next, dp[road.next]});
            }
        }
    }
}

vector<int> solution(int n, vector<vector<int>> roads, vector<int> sources, int destination) {
    vector<int> answer;
    
    for(int i = 0; i<roads.size();i++){
        Roads[roads[i][0]].push_back({roads[i][1],1});
        Roads[roads[i][1]].push_back({roads[i][0],1});
    }
    
    for(int i = 0; i<=n; i++)
        dp[i] = INT_MAX;
    
    dijkstra(destination);
    
    for(auto c : sources){
        if(dp[c] == INT_MAX) answer.push_back(-1);
        else answer.push_back(dp[c]);
    }
    
    return answer;
}