#include <string>
#include <vector>
#include <cmath>
#include <iostream>
using namespace std;

bool isprime(long long n){
    if(n < 2)
        return false;
    for(int i=2;i<=sqrt(n);i++)
        if(n % i == 0)
            return false;
    return true;
}

int solution(int n, int k) {
    int answer = 0;
    
    string s="";
    while(n>=k){
        s += to_string(n%k);
        n /= k;
    }
    s += to_string(n);
    
    for(int i=0;i<s.size()/2;i++)
        swap(s[i],s[s.size()-1-i]);
    
    long long x = 0;
    for(int i=0;i<s.size();i++){
        if(s[i] == '0'){
            if(isprime(x))
                answer++;
            x = 0;
            continue;
        }
        x*=10;
        x += s[i] - '0';
    }
    if(isprime(x))
        answer++;

    return answer;
}