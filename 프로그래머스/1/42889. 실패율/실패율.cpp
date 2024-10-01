#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

struct xy{
    int n;
    double per;
};
struct cmp{
    bool operator()(xy x, xy y){
        if(x.per == y.per) return x.n > y.n;
        return y.per > x.per;
    }
};

int che[502];

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    
    for(auto c:stages)
        che[c]++;
    
    priority_queue<xy,vector<xy>,cmp> pq;
    int size = stages.size();
    int prev = stages[0];
    int cnt = 1;
    
    for(int i = 1; i<=N;i++){
        if(che[i] == 0)
            pq.push({i,0});
        else{
            pq.push({i,(double)che[i] / (double) size});
            size -= che[i];
        }
    }
    
    while(pq.size()!=0){
        answer.push_back(pq.top().n); pq.pop(); 
    }
    
    return answer;
}