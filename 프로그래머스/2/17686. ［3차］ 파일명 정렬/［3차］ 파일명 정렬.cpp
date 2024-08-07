#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

struct File{
    string head;
    string number;
    string tail;
    int n;
};

bool cmp(File a, File b){
    string s1,s2;
    for(auto c:a.head)
        s1 += tolower(c);
    for(auto c:b.head)
        s2 += tolower(c);
    
    if(s1 == s2){
        if(stoi(a.number) == stoi(b.number))
            return a.n < b.n;
        return stoi(a.number)<stoi(b.number);
    }
    return s1 < s2;
}

vector<string> solution(vector<string> files) {
    vector<string> answer;
    
    vector<File> v;
    int index = 0;
    for(auto c:files){
        string h,n,t;
        int i = 0;
        while(!isdigit(c[i]))
            h+=c[i++];
        
        while(isdigit(c[i]))
            n+=c[i++];
        
        while(i < c.size())
            t+=c[i++];
        
        v.push_back({h,n,t,index++});
    }
    
    sort(v.begin(),v.end(),cmp);
    for(auto c:v)
        answer.push_back(c.head + c.number + c.tail);
    
    return answer;
}