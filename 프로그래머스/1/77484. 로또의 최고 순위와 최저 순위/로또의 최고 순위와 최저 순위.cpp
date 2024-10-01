#include <string>
#include <vector>
#include <iostream>
using namespace std;

int num[46];
vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    
    for(auto w:win_nums)
        num[w]++;
    int zero = 0;
    int suc = 0;
    for(auto l:lottos){
        if(l == 0) zero++;
        if(num[l] >0) suc ++;
    }
    answer.push_back(min(6,6 - (suc + zero) + 1));
    answer.push_back(min(6,6 - suc + 1));
    
    
    return answer;
}