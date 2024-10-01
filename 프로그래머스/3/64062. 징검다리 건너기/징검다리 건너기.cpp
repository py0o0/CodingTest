#include <string>
#include <vector>

using namespace std;

bool check(int n, int k, vector<int> v){
    int cnt = 0;
    for(auto c : v){
        if(c - n < 0) cnt++;
        else cnt = 0;
        
        if(cnt >= k) return false;
    }
    return true;
}

int solution(vector<int> stones, int k) {
    int answer = 0;
    int Max = 0;
    for(auto stone : stones)
        Max = max(Max, stone);
    
    int start = 1;
    int end = Max;
    
    while(start<=end){
        int mid = (start + end) / 2;
        
        if(check(mid,k,stones)){
            start = mid + 1;
            answer = mid;
        }
        else
            end = mid - 1;
    }

    return answer;
}