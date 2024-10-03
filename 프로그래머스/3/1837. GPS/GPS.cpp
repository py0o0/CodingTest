#include <vector>
#include <iostream>
using namespace std;
struct Road{
    int next;
};
// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int n, int m, vector<vector<int>> edge_list, int k, vector<int> gps_log) {
    int INF = 987654321;
    int answer = INF;
    vector<Road> roads[201];
    for(int i = 0; i<201;i++)
        roads[i].clear();
    
    for(auto e: edge_list){
        roads[e[0]].push_back({e[1]});
        roads[e[1]].push_back({e[0]});
    }
    
    int dp[101][201];      //초, 정점
    for(int i = 0; i<101;i++)
        for(int j = 0; j<201; j++)
            dp[i][j] = INF;
    
    dp[0][gps_log[0]] = 0;      //시작점 = 수정횟수 0
    for(int i = 1; i<k;i++)
        for(int j = 1; j<=n;j++){
            dp[i][j] = min(dp[i-1][j], dp[i][j]); // 이전정점에서 가만히 있으면 여기 올수 있음
            for(auto road:roads[j])
                dp[i][j] = min(dp[i-1][road.next], dp[i][j]); //이전에 있던 곳이 인접해있으면 여기로 올 수 있음,
            //여기로 올 루트 중 최소 수정 횟수를 가지고 있는 루트 탐색
            
            dp[i][j] += (j == gps_log[i] ? 0 : 1); 
            //지금 잇는 정점이 적힌 정점이면 수정 필요 없음, 적힌 정점이랑 다르면 여기 수정해야함
        }

    answer = min(answer,dp[k-1][gps_log[k - 1]]); //k초에 i까지 왓을 경우 중 최소 수정 횟수 루트
    if(answer >= INF) return -1;
    return answer;
}