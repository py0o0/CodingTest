#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <queue>
using namespace std;

bool cmp(vector<string> a,vector<string> b){
    return a[0] < b[0];
}

struct cmp2{
    bool operator()(string a,string b){
        return a > b;
    }
};

string to(string a){
    string h;
    for(int i=0;i<2;i++)
        h += a[i];
    
    string m;
    for(int i=3;i<5;i++)
        m += a[i];
    
    m = to_string(stoi(m) + 10);
    if (m >= "60"){
        m = to_string(stoi(m) - 60);
        h = to_string(stoi(h) + 1);
    }
    if(m.size() ==1)
        m = '0' + m;
    if(h.size() ==1)
        h = '0' + h;
    
    return h + ":" + m;
    
}

int solution(vector<vector<string>> book_time) {
    int answer = 0;
    sort(book_time.begin(),book_time.end(),cmp);
    
    priority_queue<string,vector<string>,cmp2> pq;
    for(auto c:book_time){
        if(pq.size() == 0)
            pq.push(to(c[1]));
        
        else if(pq.top() <= c[0]){
            pq.pop();
            pq.push(to(c[1]));
        }
        else if(pq.top() > c[0])
            pq.push(to(c[1]));
              
        if(answer < pq.size())
            answer = pq.size();

    }
    return answer;
}