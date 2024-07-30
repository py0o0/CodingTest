#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    
    map<string,int> m;
    for(int i=0;i+10 <= discount.size();i++){
        for(int j=0;j<number.size();j++)
            m[want[j]] = number[j];
        
        for(int j=i;j<i+10;j++)
            m[discount[j]]--;
        
        int flag = 1;
        for(int j=0;j<number.size();j++)
            if(m[want[j]]>0){
                flag = 0;
                break;
            }
        if(flag)
            answer++;
        
    }
    
    return answer;
}