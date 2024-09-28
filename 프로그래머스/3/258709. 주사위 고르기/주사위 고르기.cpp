#include <string>
#include <vector>
#include <map>
#include <iostream>
#include <algorithm>
using namespace std;
vector<vector<int>> dices;
vector<int> A_sum;
vector<int> B_sum;

struct xy{
    int win;
    double per;
};

map<vector<int>,xy> m;

void roll(char x,int index, int sum, vector<int> d){
    if(index >= d.size()){
        if(x == 'a')
            A_sum.push_back(sum);
        else
            B_sum.push_back(sum);
        return;
    }
    for(int j = 0; j<6;j++)
        roll(x,index + 1, sum + dices[d[index]][j], d);
        
    
}

void choice_dice(vector<int> d,int index, int n){
    if(d.size() == n){
        A_sum.clear();
        B_sum.clear();
        
        vector<int> d2;
        int cur = 0;
        for(int i =0; i<2*n; i++){
            if(cur >= d.size())
                d2.push_back(i);
            else if(i < d[cur])
                d2.push_back(i);
            else if(i == d[cur])
                cur++;
        }
        roll('a',0,0, d);
        roll('b',0,0, d2);
        
        sort(A_sum.begin(),A_sum.end());
        sort(B_sum.begin(),B_sum.end());
        
        int acur = 0;
        int bcur = 0;
        while(acur < A_sum.size() && bcur < B_sum.size()){
            if(A_sum[acur] > B_sum[bcur])
                bcur++;
            else{
                acur++;
                m[d].win += bcur;
            }
        }
        while(acur < A_sum.size()){
            acur++;
            m[d].win += bcur;
        }
        
        m[d].per = (double)m[d].win/(double)(A_sum.size() * B_sum.size());
        
        return;
    }
    for(int i = index;i < 2*n; i++){
        d.push_back(i);
        choice_dice(d,i+1,n);
        d.pop_back();
    }
}

vector<int> solution(vector<vector<int>> dice) {
    vector<int> answer;
    dices = dice;
    vector<int> d;
    choice_dice(d,0,dices.size()/2);
    
    double max = 0;
    for(auto c:m){
        if(max < c.second.per){
            max = c.second.per;
            answer = c.first;
        }
    }
    for(int i =0;i<answer.size();i++)
        answer[i]++;
    
    return answer;
}