#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <set>
using namespace std;

int a[10000001];
bool cmp(int x,int y){
    if(a[x]!=a[y])
        return a[x]>a[y];
    return x>y;
}

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    for(auto c:tangerine)
        a[c]++;
    sort(tangerine.begin(),tangerine.end(),cmp);
    
    set<int> s;
    
    for(int i=0; i<k;i++)
        s.insert(tangerine[i]);
    
    answer = s.size();
    return answer;
}