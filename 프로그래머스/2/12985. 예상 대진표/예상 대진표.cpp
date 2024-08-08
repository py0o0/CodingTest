#include <iostream>

using namespace std;

int solution(int n, int a, int b)
{
    int answer = 0;

    if(a>b)
        swap(a,b);
    
    int cnt = 1;
    while(1){
        if(a % 2 == 1 and a+1 == b){
            answer = cnt;
            break;
        }
        if(a % 2 == 1)
            a = (a+1)/2;
        else
            a = a/2;
        
        if(b % 2 == 1)
            b = (b+1)/2;
        else
            b = b/2;
        
        cnt++;
    }
    return answer;
}