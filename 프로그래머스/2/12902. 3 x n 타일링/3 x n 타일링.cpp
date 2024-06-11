#include <string>
#include <vector>

using namespace std;

long long d[2501];

int solution(int n) {
    int answer = 0;
    d[0] = 0;
    d[1] = 3;
    d[2] = 11;
    for(int i=3;i<=n/2;i++){
        d[i] = d[i-1] *3;
        for(int j=0;j<i-1;j++)
            d[i] += d[j] *2;
        d[i]+=2;
        d[i] = d[i]%1000000007;
    }
    answer = d[n/2];
    return answer;
}