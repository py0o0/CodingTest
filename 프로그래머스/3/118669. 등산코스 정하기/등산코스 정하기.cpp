#include <string>
#include <vector>
#include <iostream>
#include <climits>
#include <queue>
using namespace std;



struct xy{
    int now;
    int now_t;
};
struct cmp{
    bool operator()(xy a, xy b){
        return a.now_t > b.now_t;
    }
};

struct Road{
    int next;
    int t;
};

int start[50001];
int mou[50001];

vector<Road> roads[50001];

int dist[50001];

void dijkstra(vector<int> s){
    priority_queue<xy,vector<xy>,cmp> pq;
    for(auto c : s){
        dist[c] = 0;
        pq.push({c,0});
    }
    
    while(!pq.empty()){
        xy x = pq.top();
        pq.pop();
        for(auto road : roads[x.now]){
            if(start[road.next] == 1) continue;
            int dis = max(road.t, x.now_t);
            if(dist[road.next] > dis){
                dist[road.next] = dis;
                if(mou[road.next] == 1) continue;
                pq.push({road.next,dist[road.next]});
            }
        }
        
    }
}

vector<int> solution(int n, vector<vector<int>> paths, vector<int> gates, vector<int> summits) {
    vector<int> answer;
    
    for(auto path : paths){
        roads[path[0]].push_back({path[1],path[2]});
        roads[path[1]].push_back({path[0],path[2]});
    }
    
    for(auto gate : gates)
        start[gate] = 1;
    for(auto summit : summits)
        mou[summit] = 1;
    
    int Min = INT_MAX;
    int mountain = 0;
    
    fill(dist, dist + n + 1, INT_MAX);
    dijkstra(gates);
    for(auto m : summits){
        if(dist[m] < Min){
            Min = dist[m];
            mountain = m;
        }
        else if(dist[m] == Min){
            mountain = min(mountain, m);
        }
    }
    
    answer.push_back(mountain);
    answer.push_back(Min);
    
    
    return answer;
}