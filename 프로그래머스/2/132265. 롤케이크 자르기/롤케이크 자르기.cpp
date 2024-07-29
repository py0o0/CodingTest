#include <string>
#include <vector>
#include <set>
#include <iostream>
using namespace std;

int map[10001];
int solution(vector<int> topping) {
    int answer = 0;
    set<int> a;
    for(auto c:topping){
        map[c]++;
        a.insert(c);
    }
    
    int x = a.size();
    
    set<int> s;
    for(auto c:topping){
        s.insert(c);
        map[c]--;
        if(map[c] == 0)
            x--;
        if(x == s.size())
            answer++;
    }
    return answer;
}