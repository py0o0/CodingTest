#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;


int gcd(int a,int b){
    if(b == 0)
        return a;
    return gcd(b,a%b); 
}
void div(int A,vector<int>& v){
    for(int i=2;i<=A/2;i++)
        if(A%i == 0)
            v.push_back(i);
}

int solution(vector<int> arrayA, vector<int> arrayB) {
    int answer = 0;
    sort(arrayA.begin(),arrayA.end());
    sort(arrayB.begin(),arrayB.end());
    
    int A = arrayA[0];
    int B = arrayB[0];

    for(int i=1;i<arrayA.size();i++)
        A = gcd(A,arrayA[i]);
    
    vector<int> a;
    div(A,a);
    a.push_back(A);
    
    
    
    for(int i=a.size()-1;i>-1;i--){
        int flag = 1;
        for(auto c:arrayB){
            if(c % a[i] ==0){
                A = 0;
                flag = 0;
                break;
            }
        }
        if(flag == 1){
            A = a[i];
            break;
        }
    }
    
    for(int i=1;i<arrayB.size();i++)
        B = gcd(B,arrayB[i]);
    
    vector<int> b;
    div(B,b);
    b.push_back(B);
    
    
    for(int i=b.size()-1;i>-1;i--){
        int flag = 1;
        for(auto c:arrayA){
            if(c % b[i] ==0){
                B = 0;
                flag = 0;
                break;
            }
        }
        if(flag == 1){
            B = b[i];
            break;
        }
    }
    
    answer = max(A,B);
    
    
    return answer;
}