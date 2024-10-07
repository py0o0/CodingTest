#include <iostream>
#include <vector>
#include <climits>
#include <queue>
using namespace std;

struct Road {
	int next;
	int t;
};
vector<Road> roads[100001];
int dp[100001];

struct xy {
	int now;
	int now_t;
};
struct cmp {
	bool operator()(xy a, xy b) {
		return a.now_t > b.now_t;
	}
};

void dijkstra(int start) {
	dp[start] = 0;
	priority_queue<xy, vector<xy>, cmp> pq;
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
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int n, m;
	cin >> n >> m;
	
	while (m--) {
		int s, e, t;
		cin >> s >> e >> t;
		roads[s].push_back({ e,t });
	}

	for (int j = 1; j <= n; j++)
		dp[j] = INT_MAX;

	for (int i = 1; i <= n; i++) {
		dijkstra(i);
		for (int j = 1; j <= n; j++) {
			if (dp[j] == INT_MAX) cout << 0 << " ";
			else cout << dp[j] << " ";
			dp[j] = INT_MAX;
		}
		cout << "\n";
	}

	return 0;

}