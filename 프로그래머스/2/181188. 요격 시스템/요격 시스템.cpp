#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

bool cmp(vector<int> &v1,vector<int> &v2){
    return v1[0]<v2[0];
}

int solution(vector<vector<int>> targets) {
    int answer = 0;
    sort(targets.begin(),targets.end(),cmp);
    
    int x = targets[0][1];
    int cnt = 1;
    
    for(int i=1;i<targets.size();i++){
        if(x <= targets[i][0]){
            cnt++;
            x= targets[i][1];
        }
        else if(x > targets[i][1])
            x = targets[i][1];
    }
    
    answer = cnt;
    return answer;
}