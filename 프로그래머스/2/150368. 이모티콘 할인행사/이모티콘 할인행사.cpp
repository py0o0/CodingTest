#include <string>
#include <vector>
#include <iostream>
using namespace std;

int Maxn;
int Msum;
double dis[] = {10.0,20.0,30.0,40.0};

void dfs(vector<int> v,vector<vector<int>> users,vector<int> emo){
    if(v.size() == emo.size()){
        int fsum=0;
        int fn=0;
        for(int i=0;i<users.size();i++){
            int sum = 0;
            for(int j=0;j<v.size();j++){
                if(users[i][0] <= v[j]){
                    users[i][1] -= emo[j] - emo[j]* v[j] / 100;
                    sum += emo[j] - emo[j]* v[j] / 100;
                }
            }
            if(v[0]== 40 and v[1]==40 and v[2]==20 and v[3]==40)
                cout<<i<<" "<<users[i][1]<<"\n";
            
            if(users[i][1] <= 0)
                fn++;
            else
                fsum += sum;
            
        }
        
        if(Maxn< fn){
            Maxn = fn;
            Msum = fsum;
        }
        else if(Maxn == fn)
            Msum = max(Msum,fsum);
        
        
        return;
    }
    
    for(int i=0;i<4;i++){
        v.push_back(dis[i]);
        dfs(v,users,emo);
        v.pop_back();
    }
    
}

vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
    vector<int> answer;
    
    vector<int> v;
    dfs(v,users,emoticons);
    
    answer.push_back(Maxn);
    answer.push_back(Msum);
    
    return answer;
}