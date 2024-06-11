#include <string>
#include <vector>
#include <algorithm>
using namespace std;
int a;
bool cmp(string &n1,string &n2){
    if(n1[a] == n2[a]){
        return n1<n2;
    }
    return n1[a]<n2[a];
}

vector<string> solution(vector<string> strings, int n) {
    vector<string> answer;
    a = n;
    sort(strings.begin(),strings.end(),cmp);
    answer = strings;
    return answer;
}