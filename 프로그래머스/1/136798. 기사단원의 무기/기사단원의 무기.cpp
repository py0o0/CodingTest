#include <string>
#include <vector>
#include <iostream>
using namespace std;

int div(int n){
    int cnt = 1;
    for(int i=1;i<=n/2;i++){
        if(n%i == 0)
            cnt++;
    }
    return cnt;
}

int solution(int number, int limit, int power) {
    int answer = 0;
    vector<int> v;
    
    for(int i=1;i<=number;i++){
        int n = div(i);
        v.push_back(n);
    }

    for(int i=0;i<v.size();i++){
        if(v[i] > limit)
            v[i] = power;
        answer+=v[i];
    }
    
    return answer;
}