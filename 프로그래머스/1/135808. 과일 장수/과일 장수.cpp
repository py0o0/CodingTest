#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(int &n1, int &n2){
    return n1>n2;
}

int solution(int k, int m, vector<int> score) {
    int answer = 0;
    sort(score.begin(),score.end(),cmp);
    
    int i = 1;
    for(auto c:score){
        if(m==i){
            answer += m*c;
            i= 1;
            continue;
        }
        i++;
    }
    
    
    return answer;
}