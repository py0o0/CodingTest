#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>

using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m, k;
	cin >> n >> m >> k;
	vector<vector<int>> map(n+1, vector<int>(n+1));
	vector<vector<int>> give (n+1, vector<int>(n+1));
	deque<int> tree[11][11];

	for(int i=1;i<=n;i++)
		for (int j = 1; j <= n; j++) {
			map[i][j] = 5;
			cin >> give[i][j];
		}

	for (int i = 0; i < m; i++) {
		int ci, cj, age;
		cin >> ci >> cj >> age;
		tree[ci][cj].push_back(age);
	}


	for (int t = 0; t < k; t++) {



		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (tree[i][j].size() != 0) {
					int k = 0;
					int size = tree[i][j].size();
					for (; k < size; k++) {
						if (map[i][j] >= tree[i][j][k]) {
							map[i][j] -= tree[i][j][k];
							tree[i][j][k]++;
						}
						else
							break;
					}

					for (int o = size - 1; o >= k; o--) {
						map[i][j] += tree[i][j][o] / 2;
						tree[i][j].pop_back();
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (tree[i][j].size() != 0) {
					for (int k = 0; k < tree[i][j].size(); k++) {
						if (tree[i][j][k] % 5 == 0) {

							if (i - 1 > 0)
								tree[i - 1][j].push_front({ 1 });
							if (i + 1 <= n)
								tree[i + 1][j].push_front({ 1 });
							if (j - 1 > 0)
								tree[i][j - 1].push_front({ 1 });
							if (j + 1 <= n)
								tree[i][j + 1].push_front({ 1 });
							if (i - 1 > 0 && j - 1 > 0)
								tree[i - 1][j - 1].push_front({ 1 });
							if (i + 1 <= n && j + 1 <= n)
								tree[i + 1][j + 1].push_front({ 1 });
							if (j - 1 > 0 && i + 1 <= n)
								tree[i + 1][j - 1].push_front({ 1 });
							if (j + 1 <= n && i - 1 > 0)
								tree[i - 1][j + 1].push_front({ 1 });
						}
					}
				}
				map[i][j] += give[i][j];
			}
		}
	

	}
	
	int cnt = 0;
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			if (tree[i][j].size() != 0)
				cnt += tree[i][j].size();
	cout << cnt;
	
}
