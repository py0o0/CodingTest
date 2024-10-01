#include <string>
#include <vector>
#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

struct xy{
    int s;
    int e;
};

struct com{
    bool operator()(xy x, xy y){
    if(x.e == y.e) return x.s < y.s;
    return x.e > y.e; 
    }
};

bool cmp(xy x, xy y){
    if(x.s == y.s) return x.e < y.e;
    return x.s < y.s; 
}

int seco1(string s){
    double x  = 0;
    x += stoi(s.substr(0,2)) * 3600 * 1000;
    x += stoi(s.substr(3,2)) * 60 * 1000;
    x += stod(s.substr(6))* 1000;
    return x;
}
int seco2(string s){
    s.pop_back();
    return stod(s)* 1000;
}

int solution(vector<string> lines) {
    int answer = 0;
    
    vector<xy> v;
    
    for(auto l : lines){
        string e = l.substr(11,12);
        string s = l.substr(24);
        int end = seco1(e);
        int start = seco2(s);
        start = end - (start - 1);
        
        v.push_back({start,end});       

    }
    sort(v.begin(),v.end(),cmp);
    
    priority_queue<xy,vector<xy>,com> pq;
    
    for(auto c:v){
        cout<<c.s <<" "<<c.e<<"\n";
        if(pq.size() == 0 || pq.top().e - c.s > -1000) pq.push(c);
        else {
            while(pq.size() != 0 and pq.top().e - c.s <= -1000) pq.pop();
            pq.push(c);
        }
        answer = max((int)pq.size(),answer);
    }

    
    return answer;
}