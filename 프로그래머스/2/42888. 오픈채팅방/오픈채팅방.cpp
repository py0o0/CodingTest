#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

void change(string s,string &ch, string &id, string &name){
    string str = "";
    for(int i=0;i<s.size();i++){
        if(s[i] == ' '){
            if(ch == "")
                ch = str;
            else
                id = str;
            str = "";
            continue;
        }
        str += s[i];
        
    }
    if(id == "")
        id = str;
    else
        name = str;
}

vector<string> solution(vector<string> record) {
    vector<string> answer;
    map<string,string> m;
    for(auto c:record){
        string ch,id,name;
        change(c,ch,id,name);

        if(ch == "Enter" or ch == "Change")
            m[id] = name;
    }
    
    for(auto c:record){
        string ch,id,name;
        change(c,ch,id,name);
        
        if(ch == "Enter")
            answer.push_back(m[id] + "님이 들어왔습니다.");
        else if(ch == "Leave")
            answer.push_back(m[id] + "님이 나갔습니다.");
    }
    
    return answer;
}