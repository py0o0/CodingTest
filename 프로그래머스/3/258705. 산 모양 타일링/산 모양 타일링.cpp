#include <string>
#include <vector>

using namespace std;
int a[100001];
int b[100001];
int solution(int n, vector<int> tops) {
    int answer = 0;
    
    a[0] = 1;
    b[0] = (tops[0] == 1 ? 3 : 2);
    for(int i = 1; i < n; i++){
        a[i] = (b[i - 1] + a[i - 1]) % 10007;
        if(tops[i] == 0)
            b[i] = ((a[i - 1] * 1) + (b[i - 1] * 2)) % 10007;
        
        else
            b[i] = ((a[i - 1] * 2) + (b[i - 1] * 3)) % 10007;
    }
    answer = (a[n - 1] + b[n - 1]) % 10007;
    
    return answer;
}