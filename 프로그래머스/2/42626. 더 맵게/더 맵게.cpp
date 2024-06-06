#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

struct cmp{
    bool operator()(int &n1,int &n2){
        return n1>n2;
    }
};

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int,vector<int>,cmp> pq;
    for(auto c:scoville)
        pq.push(c);
    
    int cnt=0;
    
    while(pq.top()<K){
        int a = pq.top();
        pq.pop();
        
        if(pq.size()==0)
            return -1;
        
        int b = pq.top();
        pq.pop();
        pq.push(a+b*2);
        cnt++;
    }
    answer = cnt;
    return answer;
}