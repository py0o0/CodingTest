#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int map[100001];

bool cmp(vector<int> a, vector<int> b){
    return a.size()<b.size();
}

vector<int> solution(string s) {
    vector<int> answer;
    vector<vector<int>> v;
    vector<int> v1;
    int flag = 0;
    string str = "";
    for(int i=1;i<s.size()-1;i++){
        if(s[i]=='{'){
            str = "";
            flag = 1;
            continue;
        }
        if(s[i]=='}'){
            flag = 0;
            v1.push_back(stoi(str));
            v.push_back(v1);
            v1.clear();
            continue;
        }
        if(flag and s[i]!=',')
            str += s[i];
        else if(flag and s[i]==','){
            v1.push_back(stoi(str));
            str = "";
        }
        
    }
    
    sort(v.begin(),v.end(),cmp);
    
    for(auto c:v)
        for(auto b:c)
            if(!map[b]){
                map[b] = 1;
                answer.push_back(b);
            }
    
    return answer;
}