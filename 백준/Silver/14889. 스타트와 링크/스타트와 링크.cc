#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <cmath>
#include <climits>

using namespace std;

int MIN;
int visit[21];

void dfs(vector<vector<int>> map, vector<int> v, int n, int i) {
	if (v.size() == n) {
		vector<int> ch(2 * n);
		vector<int> r;
		int score1 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				score1 += map[v[i]][v[j]] + map[v[j]][v[i]];
			}
			ch[v[i]] = 1;
		}

		for (int i = 0; i < 2 * n; i++) {
			if (ch[i] == 0)
				r.push_back(i);
		}

		int score2 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				score2 += map[r[i]][r[j]] + map[r[j]][r[i]];
			}
			ch[v[i]] = 1;
		}

		int score = abs(score1 - score2);

		MIN = min(score, MIN);
		return;
	}

	if (i >= 2 * n)
		return;

	for (int j = i + 1; j < 2 * n; j++) {
		if (!visit[j]) {
			v.push_back(j);
			visit[j] = 1;
			dfs(map, v, n, j);
			v.pop_back();
			visit[j] = 0;
			//dfs(map, v, n, j);
		}
	}
}

int main(void) {
	int n;
	cin >> n;
	vector<vector<int>> map(n, vector<int>(n));
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> map[i][j];

	MIN = INT_MAX;
	
	vector<int> v;
	dfs(map, v, n / 2, 0);
	
	cout << MIN;
}
