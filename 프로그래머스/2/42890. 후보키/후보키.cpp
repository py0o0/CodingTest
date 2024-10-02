#include <string>
#include <vector>
#include <map>
#include <iostream>
#include <algorithm>
using namespace std;

map<string,int> m;
vector<vector<int>> Min;
int row,col;
string Map[21][9];
int visit[9];
int cnt;


bool check(vector<int> v){
    for(int i = 0; i<Min.size(); i++){
        int flag = 0;
        for(int j = 0; j<Min[i].size(); j++){
            if(find(v.begin(),v.end(),Min[i][j]) == v.end()){
                flag = 1;
                break;
            }
            
        }
        if(flag == 0) return false;
    }
    return true;
}

void dfs(int index, int size, vector<int> v){
    if(size == v.size()){
        
        m.clear();
        for(int i = 0;i<row;i++){
            string s = "";
            for(auto c:v)
                s += Map[i][c];
            if(m[s] != 0) return;
            m[s] = 1;
        }
        if(check(v)){
            for(auto c:v)
                visit[c] = 1;       
            cnt++;
            Min.push_back(v);
        }
        return;
    }
    for(int i = index; i<col;i++){
        v.push_back(i);
        dfs(i+1,size,v);
        v.pop_back();
    }
    
    
}

int solution(vector<vector<string>> relation) {
    int answer = 0;
    row = relation.size(); col = relation[0].size();
    
    for(int i = 0; i<row;i++)
        for(int j = 0; j<col; j++)
            Map[i][j] = relation[i][j];
    
    vector<int> v;
    for(int i = 1; i<=col; i++)
        dfs(0,i,v);
    answer = cnt;
    return answer;
}