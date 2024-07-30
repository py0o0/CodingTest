#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

int visit[101];

int solution(vector<int> cards) {
    int answer = 0;
    
    priority_queue<int> pq;
    for(int i=0;i<cards.size();i++){
        if(visit[i])
            continue;
        
        int cnt = 1;
        visit[i] = 1;
        int x = cards[i] - 1;
        while(i != x){
            visit[x] = 1;
            x = cards[x] - 1;
            cnt++;
        }
        pq.push(cnt);
    }
    if(pq.size() < 2)
        return 0;
    answer = pq.top();
    pq.pop();
    answer *= pq.top();
    
    return answer;
}