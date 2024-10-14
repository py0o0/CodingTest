#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(vector<int> v1,vector<int> v2){
    return v1[0]>v2[0];
}

int solution(vector<vector<int>> scores) {
    int answer = 1;
    int WonScore = scores[0][0] + scores[0][1];
    int s1 = scores[0][0];
    int s2 = scores[0][1];
    
    sort(scores.begin(), scores.end(), cmp);
    
    int a = scores[0][1], b = scores[0][1];
    for(int i = 0; i<scores.size(); i++){
        if(s1 < scores[i][0] and s2 < scores[i][1]) return -1;
        
        
        if(i == 0){
            if(WonScore < scores[i][0] + scores[i][1]) answer++;
        }
        else{
            if(scores[i - 1][0] >scores[i][0]) a = b;
                
            if(a > scores[i][1]) continue;
                
            if(WonScore < scores[i][0] + scores[i][1]) answer++;      
            b = max(scores[i][1], b);
        }
    
    }
    
    return answer;
}