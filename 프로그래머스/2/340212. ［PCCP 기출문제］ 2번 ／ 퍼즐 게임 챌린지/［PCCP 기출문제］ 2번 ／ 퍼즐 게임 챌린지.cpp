#include <string>
#include <vector>
#include <iostream>
using namespace std;
int Max = 0;

bool check(int level,vector<int> diffs, vector<int> times, long long limit){
    long long sum = 0;
    int prev = 0;
    
    for(int i =0; i<diffs.size(); i++){
        if(diffs[i] <= level) sum += times[i];
        else{
            int X = diffs[i] - level;
            sum += (times[i] + prev) * X;
            sum += times[i];
        }
        if(sum > limit) return false;
        prev = times[i];
    }
    return true;
    
}

int solution(vector<int> diffs, vector<int> times, long long limit) {
    int answer = 0;
    
    for(auto c: diffs) Max = max(Max,c);
    
    int start = 1, end = Max;
    
    while(start <= end){
        int mid = (start + end)/2;
        bool clear = check(mid,diffs,times, limit);
        if(clear){
            answer = mid;
            end = mid - 1;
        }
        else start = mid + 1; 
    }

    
    return answer;
}