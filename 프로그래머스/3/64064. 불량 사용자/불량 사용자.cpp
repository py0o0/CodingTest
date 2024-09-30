#include <string>
#include <vector>
#include <iostream>
#include <map>
#include <algorithm>
using namespace std;
string ban[9];
int ban_size;

int visit[9];

string user[9];
int user_size;

int cnt;

map<string,int> m;

void dfs(int index,vector<string> v){
    if(index >= ban_size){
        string s = "";
        sort(v.begin(),v.end());
        for(auto c:v)
            s+=c + " ";
        
        if(m[s] == 0)
            cnt++;
        m[s] = 1;
        return;
    }
    
    
    for(int i = 0; i<user_size;i++){
        if(visit[i] == 1) continue;
        if(user[i].size() != ban[index].size()) continue;
        
        int cur = -1;
        int flag = 0;
        
        for(auto c:ban[index]){
            cur++;
            if(c == '*') continue;
            
            
            if(c != user[i][cur]){
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            visit[i] = 1;
            v.push_back(user[i]);
            dfs(index + 1,v);
            v.pop_back();
            visit[i] = 0;
        }
    }
}


int solution(vector<string> user_id, vector<string> banned_id) {
    int answer = 0;
    
    int cur = 0;
    for(auto c:user_id)
        user[cur++] = c;
    user_size = user_id.size();
    
    cur = 0;
    for(auto c:banned_id)
        ban[cur++] = c;
    ban_size = banned_id.size();
    
    vector<string> v;
    dfs(0,v);
    
    answer = cnt;
    return answer;
}