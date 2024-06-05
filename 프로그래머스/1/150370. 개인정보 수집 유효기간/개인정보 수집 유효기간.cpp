#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

long long yTOd(string a){
    long long d = 0;
    string s ="";
    for(int i=0;i<4;i++)
        s += a[i];
    
    d += stoi(s) * 12 * 28;
    
    s = "";
    for(int i=5;i<7;i++)
        s += a[i];
    
    d += stoi(s)* 28;
    
    s = "";
    for(int i=8;i<10;i++)
        s += a[i];
    d+= stoi(s);
    
    return d;
}

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    map<char, long long> m;
    
    long long d1 = yTOd(today);
    
    for(auto c: terms){
        char a = c[0];
        
        string s = "";
        for(int i=2;i<c.size();i++)
            s+=c[i];
        
        m[a] = d1 - stoi(s) * 28;
    }
    
    int cnt = 1;
    for(auto c: privacies){
        string s = "";
        for(int i=0;i<10;i++)
            s+=c[i];
        
        
        char a = c[11];
        if(m[a] >= yTOd(s))
            answer.push_back(cnt);
            
        cnt++;
    }
    
    
    return answer;
}