#include <string>
#include <vector>
#include <climits>
#include <algorithm>
#include <iostream>
using namespace std;


vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer;
    int min = INT_MAX;
    int sum  = 0;
    int s = 0;
    int a =0;
    int b = 0;
    for(int i = 0;i<sequence.size();i++){
        sum+=sequence[i];
        if(sum>k){
            while(sum>k)
                sum-=sequence[s++];
            
            
        }
        if(sum==k){
            int len = i-s;
            if(min>len){
                min = len;
                a = i;
                b = s;
            }
        }
    }
            answer.push_back(b);
            answer.push_back(a);

    return answer;
}