#include <string>
#include <vector>
#include <algorithm>
using namespace std;

long long solution(vector<int> weights) {
    long long answer = 0;
    
    sort(weights.begin(),weights.end());
    for(int i=0;i<weights.size();i++){
        for(int j=i+1;j<weights.size();j++){
            if(weights[i] == weights[j])
                answer++;
            else if(weights[i] * 3 % 2 ==0 and weights[i] * 3 / 2 == weights[j])
                answer++;
            else if(weights[i] * 4 % 3 ==0 and weights[i] * 4 / 3 == weights[j])
                answer++;
            else if(weights[i] * 2 == weights[j])
                answer++;
        }
    }
    return answer;
}