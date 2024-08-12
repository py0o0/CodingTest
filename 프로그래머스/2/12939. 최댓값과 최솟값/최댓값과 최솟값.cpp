#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

string solution(string s) {
    string answer = "";
    vector<int> v;
    
    string n;
    for(auto c:s){
        if(c == ' '){
            v.push_back(stoi(n));
            n = "";
            continue;
        }
        n += c;
    }
    v.push_back(stoi(n));
    
    sort(v.begin(),v.end());
    
    answer += to_string(v[0]) + " " + to_string(v[v.size()-1]);
    
    return answer;
}