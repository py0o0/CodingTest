#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(string new_id) {
    string answer = "";
    
    string s = "";
    string id = new_id;
    for(auto c : id){
        if(isalpha(c))
            s += tolower(c);
        else if(c == '-')
            s += c;
        else if(c == '_')
            s += c;
        else if(c == '.')
            s += c;
        else if(isdigit(c))
            s += c;
        
    }
    
    id = s;
    s = "";
    
    char prev = ' ';
    for(auto c : id){
        if(prev == '.' and c == '.') continue;
        prev = c;
        s += c;
            
    }
    
    
    if(s.size() != 0 && s[0] == '.')
        s = s.substr(1,s.size()-1);
    if(s.size() != 0 && s[s.size()-1] == '.')
        s.pop_back();
    
    if(s.size() == 0)
        s += 'a';
    
    if(s.size() >= 16){
        s = s.substr(0,15);
        if(s[s.size() - 1] == '.')
            s.pop_back();
    }
    
    if(s.size() < 3){
        char a = s[s.size() - 1];
        while(s.size() < 3)
            s += a;
    }
    
    answer = s;
    return answer;
}