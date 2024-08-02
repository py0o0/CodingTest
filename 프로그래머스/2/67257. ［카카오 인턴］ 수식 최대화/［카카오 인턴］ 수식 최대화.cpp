#include <string>
#include <vector>
#include <iostream>
using namespace std;
int visit[3];
long long Max;

string solve(string a, string x, string b){
    if(x == "-")
        return to_string(stoll(a) - stoll(b));
    if(x == "+")
        return to_string(stoll(a) + stoll(b));
    if(x == "*")
        return to_string(stoll(a) * stoll(b));
    return "0";
}

void dfs(string ex,string s, vector<string> e){
    if(ex.size()==3){
        int index = 0;
        for(int i=0; i<3;i++){
            for(int j = 0;j<e.size();j++){
                if(ex[i] == e[j][0] and e[j].size() == 1){
                    string a = solve(e[j-1],e[j],e[j+1]);
                    
                    e[j] = a;                    
                    int k = j-1;
                    while(k!=-1 and e[k] !="-" and e[k] !="+" and e[k] !="*")
                        e[k--] = a;

                    k = j+1;
                    while(k!=e.size() and e[k] !="-" and e[k] !="+" and e[k] !="*")
                        e[k++] = a;
                    
                    index = j;
                    if(ex == "*+-")
                        cout<<a<<"\n";
                }
            }
        }
        long long n = max(-stoll(e[index]),stoll(e[index]));
        
        Max = max(Max,n);
        
        return;
    }
    for(int i=0;i<3;i++){
        if(visit[i])
            continue;
        visit[i] = 1;
        dfs(ex+s[i],s,e);
        visit[i] = 0;
    }
}

long long solution(string expression) {
    long long answer = 0;
    vector<string> e;
    
    string s = "";
    for(auto c:expression){
        if(c == '-' or c == '+' or c == '*'){
            e.push_back(s);
            e.push_back(string(1,c));
            s = "";
            continue;
        }
        s+=c;
    }
    e.push_back(s);
    
    dfs("","-+*",e);
    answer = Max;
    return answer;
}