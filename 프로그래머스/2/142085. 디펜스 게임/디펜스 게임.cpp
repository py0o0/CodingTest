#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;


int solution(int n, int k, vector<int> enemy) {
    int an = 0;
    priority_queue<int> pq;
    for(auto c:enemy){
        if(n >= c){
            pq.push(c);
            n -= c;
        }
        else if(n < c){
            if(k < 1)
                break;
            k--;
            pq.push(c);
            n-=c;
            
            n += pq.top();
            pq.pop();
        }
        an++;
    }
    return an;
}