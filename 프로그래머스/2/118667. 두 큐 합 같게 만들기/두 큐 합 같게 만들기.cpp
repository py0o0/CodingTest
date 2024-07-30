#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
    int answer = 0;
    long long s1=0, s2=0;
    queue<long long> q1, q2;
    
    for(int i=0;i<queue1.size();i++){
        q1.push(queue1[i]);
        s1 += queue1[i];
        q2.push(queue2[i]);
        s2 += queue2[i];
    }
    int size = q1.size() + q2.size() + 1;
    
    while(s1 != s2){
        if(answer > size){
            answer = -1;
            break;
        }

        else if(s1 > s2){
            int a = q1.front();
            q1.pop();
            s1 -= a;
            
            q2.push(a);
            s2 += a;
            answer++;
        }
        else if(s1 < s2){
            int a = q2.front();
            q2.pop();
            s2 -= a;
            
            q1.push(a);
            s1 += a;
            answer++;
        }
    }
    
    return answer;
}