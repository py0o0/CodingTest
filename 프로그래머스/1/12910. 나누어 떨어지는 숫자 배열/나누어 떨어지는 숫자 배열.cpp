#include <string>
#include <queue>
#include <vector>

using namespace std;

struct cmp{
    bool operator()(int &n1, int &n2){
        return n1>n2;
    }
};

vector<int> solution(vector<int> arr, int divisor) {
    vector<int> answer;
    priority_queue<int,vector<int>,cmp> q;
    for(auto c:arr)
        if(c % divisor == 0)
            q.push(c);
    
    while(q.size()!=0){
        answer.push_back(q.top());
        q.pop();
    }
    if(answer.size()==0)
        answer.push_back(-1);
    return answer;
}