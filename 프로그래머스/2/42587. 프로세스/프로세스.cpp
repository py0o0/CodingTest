#include <string>
#include <vector>
#include <queue>
using namespace std;

struct Data{
    int p;
    int x;
};

int solution(vector<int> priorities, int location) {
    int answer = 0;
    deque<Data> q;
    for(int i=0; i<priorities.size();i++){
        q.push_back({priorities[i],i});
    }
    int cnt = 0;
    while(q.size()!=0){
        Data d = q.front();
        q.pop_front();
        
        int fail = 0;
        for(int i=0;i<q.size();i++){
            if(q[i].p > d.p){
                q.push_back(d);
                fail = 1;
                break;
            }
        }
        if(fail)
            continue;
        
        cnt++;
        if(d.x == location)
            return cnt;
        
    }
    
    
    return answer;
}