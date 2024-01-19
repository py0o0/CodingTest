#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>

using namespace std;



int main(void) {
	int n, w;
	cin >> n >> w;
	vector <pair<int, int>> bp;
	bp.push_back(make_pair(0, 0));
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		bp.push_back(make_pair(a, b));
	}

	vector<vector<int>> map(n+1, vector<int>(w+1));

	for (int i = 1; i <= w; i++)
		if (bp[1].first <= i)
			map[1][i] = bp[1].second;

	for (int i = 2; i <= n; i++) {
		for (int j = 1; j <= w; j++) {
			map[i][j] = map[i - 1][j];
			if (j >= bp[i].first) {
				int k = j - bp[i].first;

				map[i][j] = max(map[i][j], bp[i].second + map[i - 1][k]);

			}

		}
	}

	cout << map[n][w];

}


