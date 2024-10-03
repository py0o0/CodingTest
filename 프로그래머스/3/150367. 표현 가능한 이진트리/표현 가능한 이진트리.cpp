#include <string>
#include <vector>
#include <iostream>
#include <cmath>
using namespace std;
string s;
int suc;
string change(long long n){
    string s = "";
    while(n >= 2){
        s += to_string(n%2); n/=2;
    }
    s+= to_string(n);
    for(int i = 0; i<s.size()/2;i++) swap(s[i],s[s.size()-1-i]);
    return s;
}

long long find_level(int size){
    int level = 0;
    while(pow(2,level) <= size) level++;
    return level;
}

void dfs(long long root, long long parent, long long level){
    if(s[parent] - '0' == 0 && s[root] - '0' == 1){
        suc = 0; return;
    }
    if(level == 0) return;
    dfs(root - pow(2,level - 1),root,level - 1);
    dfs(root + pow(2,level - 1),root,level - 1);
    return;
}

vector<int> solution(vector<long long> numbers) {
    vector<int> answer;
    for(auto c:numbers){
        s = change(c);
        long long level = find_level(s.size());
        long long node_cnt = pow(2,level) - 1;
        string plus = "";
        for(int i = 0; i<node_cnt - s.size(); i++) plus += '0';
       
        s = plus + s;
        long long root = s.size()/2;
        suc = 1;
        if(s[root] - '0' == 0){
            answer.push_back(0); continue;
        }
        dfs(root,root,level - 1);
        answer.push_back(suc);
        
    }
    return answer;
}