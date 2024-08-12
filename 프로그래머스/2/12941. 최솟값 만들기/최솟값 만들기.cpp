#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool big(int a,int b){
    return a<b;
}
bool low(int a,int b){
    return a>b;
}

int solution(vector<int> A, vector<int> B)
{
    int answer = 0;
    
    sort(A.begin(),A.end(),big);
    sort(B.begin(),B.end(),low);
    
    for(int i=0;i<A.size();i++)
        answer += A[i] * B[i];
    
    return answer;
}