#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(int n) {
    int answer = 0;
    
    deque<int> dq;
    int sum = 0;
    for(int i=1;i<=n;i++){
        sum += i;
        dq.push_back(i);
        if(sum == n)
            answer++;
        else if(sum > n){
            while(sum > n){
                sum -= dq[0];
                dq.pop_front();
            }
            if(sum == n)
                answer++;
        }
    }
    
    return answer;
}