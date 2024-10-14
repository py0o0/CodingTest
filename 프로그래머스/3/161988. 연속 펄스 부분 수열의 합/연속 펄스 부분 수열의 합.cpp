#include <string>
#include <vector>

using namespace std;

long long MaxSum(vector<int> v){
    vector<long long> dp(v.size());
    dp[0] = v[0];
    
    long long Max = dp[0];
    for(int i = 1; i<dp.size();i++){
        if(dp[i - 1] + v[i] < v[i]) dp[i] = v[i];
        else dp[i] = dp[i-1] + v[i];
        
        Max = max(Max,(long long)dp[i]);
    }
    return Max;
    
    
}

long long solution(vector<int> sequence) {
    long long answer = 0;
    vector<int> v1(sequence), v2(sequence);
    
    for(int i = 0; i < sequence.size(); i++){
        if(i % 2 == 0) v1[i] *= -1;
        else v2[i] *= -1;
    }
    answer = max(MaxSum(v1), MaxSum(v2));
    return answer;
}