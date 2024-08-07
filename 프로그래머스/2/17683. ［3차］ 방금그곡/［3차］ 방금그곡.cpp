#include <string>
#include <vector>
#include <iostream>
using namespace std;

string change(string s){
    string str = "";
    for(int i=0;i<s.size();i++){
        if(i+1 < s.size() and s[i+1] == '#'){
            str += tolower(s[i++]);
            continue;
        }
        str += s[i];
    }
    return str;
}

string solution(string m, vector<string> musicinfos) {
    string answer = "";
    m = change(m);
    int len = 0;
    
    for(auto c:musicinfos){
        int t =  (stoi(c.substr(6,2)) * 60 + stoi(c.substr(9,2))) - (stoi(c.substr(0,2)) * 60 + stoi(c.substr(3,2)));
        
        string name = "", mu = "";
        int i = 12;
        while(c[i] != ',')
            name += c[i++];
        
        i++;
        while(i < c.size())
            mu += c[i++];
        
        mu = change(mu);
        
        string str = "";
        for(int i = 0;i<t;i++)
            str += mu[i % mu.size()];      
        
        if(str.find(m) != -1 and len < str.size()){
            answer = name;
            len = str.size();
        }
    }
    if(answer == "")
        answer = "(None)";
    return answer;
}