#include <iostream>
#include <vector>
#include <climits>
#include <queue>
using namespace std;


struct Road {
	int next;
	int t;	
};

struct xy {
	int now;
	int now_t;
};
struct cmp {
	bool operator()(xy a, xy b) {
		return a.now_t > b.now_t;
	}
};

vector<Road> roads[20001];
int dp[20001];

void dijkstra(int start,int n) {
	dp[start] = 0;
	priority_queue<xy, vector<xy>,cmp> pq;
	pq.push({ start, 0 });

	while (pq.size() != 0) {
		xy x = pq.top(); pq.pop();
		for (auto road : roads[x.now]) {
			if (dp[road.next] > dp[x.now] + road.t) {
				dp[road.next] = dp[x.now] + road.t;
				pq.push({ road.next, dp[road.next] });
			}
		}
	}

}

int main(void) {

	int n, m,start;
	cin >> n >> m >> start;
	for (int i = 0; i < m; i++) {
		int s, e, t;
		cin >> s >> e >> t;
		roads[s].push_back({ e,t });
	}

	for (int i = 1; i <= n; i++)
		dp[i] = INT_MAX;

	dijkstra(start,n);

	for (int i = 1; i <= n; i++) {
		if (dp[i] == INT_MAX) cout << "INF\n";
		else cout << dp[i] << "\n";
	}
	return 0;
}