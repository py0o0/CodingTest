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

vector<Road> roads[101];
vector<int> items;
int dp[101][101];

void dijkstra(int start) {
	dp[start][start] = 0;
	priority_queue<xy, vector<xy>, cmp> pq;
	pq.push({ start,0 });

	while (!pq.empty()) {
		xy x = pq.top(); pq.pop();
		for (auto road : roads[x.now]) {
			if (dp[start][road.next] > dp[start][x.now] + road.t) {
				dp[start][road.next] = dp[start][x.now] + road.t;
				pq.push({ road.next, dp[start][road.next] });
			}
		}
	}

}

int main(void) {
	int n, m, r;
	cin >> n >> m >> r;
	items.push_back(0);
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		items.push_back(x);
	}
	for (int i = 0; i < r; i++) {
		int s, e, t;
		cin >> s >> e >> t;
		roads[s].push_back({ e,t });
		roads[e].push_back({ s,t });
	}
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			dp[i][j] = INT_MAX;

	for (int i = 1; i <= n; i++) 
		dijkstra(i);
	
	int Max = 0;
	for (int i = 1; i <= n; i++) {
		int sum = 0;
		for (int j = 1; j <= n; j++) {
			if (dp[i][j] > m) continue;
			sum += items[j];
		}
		Max = max(Max, sum);
	}
	cout << Max;

	return 0;
}