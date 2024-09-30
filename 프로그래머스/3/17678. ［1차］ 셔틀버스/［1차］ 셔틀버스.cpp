#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

int hm(string s){
    return stoi(s.substr(0,2)) * 60 + stoi(s.substr(3,2));
}
string mh(int x){
    string s = "";
    int h = x/60;
    if(h < 10)
        s += '0';
    s+= to_string(h) + ":";
    
    int m = x%60;
    if(m < 10)
        s += '0';
    s+= to_string(m);
    return s;
    
}

struct cmp{
    bool operator()(int a,int b){
        return a>b;
    }
};

string solution(int n, int t, int m, vector<string> timetable) {
    string answer = "";
    priority_queue<int,vector<int>,cmp> pq;
    for(auto c :timetable)
        pq.push(hm(c));
    
    int an = 0;
    int start = hm("09:00");
    for(int i = 0; i<n; i++){
        
        for(int j = 0; j<m;j++){
            if(i == n-1 and j == m-1){
                if(pq.size() == 0)
                    an = start;
                else{
                    if(pq.top() > start)
                        an = start;
                    else
                        an = pq.top() - 1;
                }
            }
            
            if(pq.size() > 0 and pq.top() <= start)
                pq.pop();
            
        }
        
        start += t;
    }
    
    answer = mh(an);
    return answer;
}