#include <string>
#include <vector>
#include <iostream>
using namespace std;

char dp[100001];
char map[17] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

string change(int x,int n){
    string s = "";
    while(x >= n){
        s += map[x%n];
        x /= n;
    }
    s += map[x%n];
    
    for(int i = 0; i<s.size()/2; i++)
        swap(s[i], s[s.size() -1 -i]);
    
    return s;
}
string solution(int n, int t, int m, int p) {
    string answer = "";
    
    int i = 0;
    int cur = 0;
    while(cur < t*m){
        string s = change(i,n); i++;
        for(auto c:s){
            dp[cur] = c;
            cur++;
            if(cur >= t*m) break;
        }
    }
    for(int i = p - 1; i<t*m; i += m)
        answer += dp[i];
    
    
    return answer;
}