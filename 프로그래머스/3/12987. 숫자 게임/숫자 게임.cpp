#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

bool cmp(int a, int b){
    return a>b;
}

int solution(vector<int> A, vector<int> B) {
    int answer = 0;
    sort(A.begin(),A.end(),cmp);
    sort(B.begin(),B.end(),cmp);
    
    int b_cur = 0;
    for(auto a : A){
        if(a < B[b_cur]){
            answer++;
            b_cur++;
        }
        else B.pop_back();
        
    }
    
    return answer;
}