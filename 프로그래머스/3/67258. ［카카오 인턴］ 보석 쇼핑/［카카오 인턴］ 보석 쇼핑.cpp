#include <string>
#include <vector>
#include <map>
#include <iostream>
#include <climits>
using namespace std;

vector<int> solution(vector<string> gems) {
    vector<int> answer;
    map<string,int> m;
    for(auto gem : gems)
        m[gem] = 0;
    
    int size = m.size();
    int start = 0;
    int min = INT_MAX;
    int cnt = 0;
    int x = 0, y = 0;
    for(int i = 0; i< gems.size(); i++){
        if(m[gems[i]] == 0)
            cnt++;
        m[gems[i]]++;
        
        if(m[gems[start]] > 1){
            while(m[gems[start]] > 1){
                m[gems[start]]--;
                start++;
            }
        }
        if(cnt == size && min > i - start + 1){
            min = i - start + 1;
            x = start + 1;
            y = i + 1;
        }
    }
    answer.push_back(x);
    answer.push_back(y);
    
    return answer;
}