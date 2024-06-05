#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

void dfs(map<string, int> &m,string s,string a,int size,int start){
    if(a.size() == size){
        m[a]++;    
        return;
    }
    for(int i=start; i < s.size();i++)
        dfs(m,s,a + s[i],size,i+1);   
}

vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer;
    
    for(auto c:course){
        
        map<string, int> m;
        
        for(auto s: orders){
            sort(s.begin(), s.end());
            dfs(m,s,"",c,0);
        }
        
        int Max = 0;
        for(auto s:m){
            Max = max(Max,s.second);
        }
        
        if(Max<2)
            continue;
        
        for(auto s:m){
            if(s.second == Max)
                answer.push_back(s.first);
        }
        
    }
    sort(answer.begin(),answer.end());
    
    return answer;
}