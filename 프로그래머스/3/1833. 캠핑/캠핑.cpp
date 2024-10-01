#include <vector>
#include <cmath>
#include <algorithm>
using namespace std;

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int n, vector<vector<int>> data) {
    int answer = 0;
    
    sort(data.begin(),data.end());
    for(int i = 0; i<n; i++){
        for(int j = i + 1; j<n; j++){
            if( abs(data[i][0] - data[j][0]) * abs(data[i][1] - data[j][1]) == 0)
                continue;
            int flag  = 0;
            int x1 = min(data[i][0], data[j][0]);
            int y1 = min(data[i][1], data[j][1]);
            int x2 = max(data[i][0], data[j][0]);
            int y2 = max(data[i][1], data[j][1]);
            
            for(int k = i+1; k<n;k++){
                if(k == i || k == j) continue;
                int x3 = data[k][0];
                int y3 = data[k][1];
                
                if(x3 > x1 and y3 > y1 and x3 < x2 and y3 < y2){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) answer++;
        }
    }
    return answer;
}