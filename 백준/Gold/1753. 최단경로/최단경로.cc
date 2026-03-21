#include <iostream>
#include <climits>
#include <vector>
#include <queue>
using namespace std;

struct xy {
	int now;
	int now_t;
};
struct cmp {
	bool operator()(xy a, xy b) {
		return a.now_t > b.now_t;
	}
};

struct Road {
	int next;
	int t;
};

vector<Road> roads[20001];
int dp[20001];
void dijkstra(int n) {
	dp[n] = 0;
	priority_queue<xy, vector<xy>, cmp> pq;
	pq.push({ n,0 });
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

int main() {
	int v, e, target;
	cin >> v >> e >> target;
	for (int i = 1; i <= v; i++)
		dp[i] = INT_MAX;
	while (e--) {
		int a, b, c;
		cin >> a >> b >> c;
		roads[a].push_back({ b,c });
	}
	dijkstra(target);

	for (int i = 1; i <= v; i++) {
		if (dp[i] == INT_MAX) cout << "INF\n";
		else cout << dp[i] << "\n";
	}
	
	return 0;
}