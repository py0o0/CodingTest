#include <string>
#include <vector>
#include <iostream>
using namespace std;
int visit[8];
int check[100000000];
int num;

bool isPrime(int n){
    int cnt = 0;
    if(n == 0 or n==1)
        return false;
    for(int i=2;i<=n/2;i++){
        if(n%i == 0)
            return false;
    }
    return true;
}

void dfs(string n, string a){
    if(a.size() !=0){
        if(isPrime(stoll(a)) and !check[stoll(a)]){
            num++;
            check[stoi(a)] = 1;
        }
    }
    
    for(int i=0;i<n.size();i++){
        if(!visit[i]){
            visit[i] = 1;
            dfs(n,a+n[i]);
            visit[i] = 0;
        }
    }
}

int solution(string numbers) {
    int answer;
    dfs(numbers,"");
    answer = num;
    return answer;
}