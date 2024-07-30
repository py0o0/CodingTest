#include <string>
#include <vector>
#include <queue>
#include <map>
#include <iostream>
using namespace std;

map<string,int> m;

struct car{
    string time;
    string num;
};

int tomin(string s){
    string h = s.substr(0,2);
    string m = s.substr(3,2);
    
    return stoi(h) * 60 + stoi(m);
}

vector<int> solution(vector<int> fees, vector<string> records) {
    vector<int> answer;
    
    queue<car> q;
    for(auto c:records){
        string time = c.substr(0,5);
        string num = c.substr(6,4);
        string io = c.substr(11,3);
        
        if(io == "IN"){
            q.push({time,num});
        }
        else{
            car x;
            x = q.front();
            
            while(x.num != num){
                q.pop();
                q.push(x);
                x = q.front();
            }
            q.pop();
            
            m[num] += tomin(time) - tomin(x.time);
            
        }
    }
    while (q.size()!=0){
        m[q.front().num] += tomin("23:59") - tomin(q.front().time);
        q.pop();
    }
    for(auto c:m){
        int fee = fees[1];
        if(fees[0] >= c.second){
            answer.push_back(fee);
            continue;
        }
        if((c.second - fees[0]) % fees[2] == 0)
            fee += (c.second - fees[0])/fees[2] * fees[3];
        else
            fee += ((c.second - fees[0])/fees[2] + 1) * fees[3];
        answer.push_back(fee);
    }
    
    return answer;
}